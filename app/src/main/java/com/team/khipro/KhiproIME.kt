package com.team.khipro

import android.inputmethodservice.InputMethodService
import android.os.Handler
import android.os.Looper
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

class KhiproIME : InputMethodService() {

    private var isCaps = false
    private var isBengali = false
    private var isSymbols = false
    private lateinit var keyboardView: View
    private val bengaliEngine = BengaliEngine()

    // প্রতিটি বাটনের অরিজিনাল লেটার মনে রাখার জন্য
    private val originalKeys = mutableMapOf<Button, String>()

    private val symbolMap = mapOf(
        "q" to "1", "w" to "2", "e" to "3", "r" to "4", "t" to "5",
        "y" to "6", "u" to "7", "i" to "8", "o" to "9", "p" to "0",
        "a" to "@", "s" to "#", "d" to "$", "f" to "%", "g" to "&",
        "h" to "-", "j" to "+", "k" to "(", "l" to ")",
        "z" to "*", "x" to "\"", "c" to "'", "v" to ":", "b" to ";",
        "n" to "!", "m" to "?"
    )

    // ব্যাকস্পেস রিপিট লজিক
    private val handler = Handler(Looper.getMainLooper())
    private val backspaceRunnable = object : Runnable {
        override fun run() {
            if (isBengali && !isSymbols) {
                bengaliEngine.handleBackspace(currentInputConnection)
            } else {
                triggerKeyEvent(KeyEvent.KEYCODE_DEL)
            }
            handler.postDelayed(this, 50)
        }
    }

    @android.annotation.SuppressLint("InflateParams")
    override fun onCreateInputView(): View {
        keyboardView = layoutInflater.inflate(R.layout.keyboard_layout, null)
        setupKeyListeners(keyboardView as ViewGroup)
        updateKeyLabels(keyboardView as ViewGroup)
        return keyboardView
    }

    @android.annotation.SuppressLint("ClickableViewAccessibility")
    private fun setupKeyListeners(viewGroup: ViewGroup) {
        for (i in 0 until viewGroup.childCount) {
            val child = viewGroup.getChildAt(i)
            if (child is ViewGroup) {
                setupKeyListeners(child)
            } else if (child is Button) {
                if (child.tag == "key") {
                    originalKeys[child] = child.text.toString().lowercase()
                    child.setOnTouchListener { v, event ->
                        if (event.action == MotionEvent.ACTION_DOWN) {
                            val textToCommit = child.text.toString()
                            if (isBengali && !isSymbols) {
                                bengaliEngine.processKeystroke(textToCommit, currentInputConnection)
                            } else {
                                currentInputConnection?.commitText(textToCommit, 1)
                            }
                            v.performClick()
                        }
                        true
                    }
                } else {
                    when (child.id) {
                        R.id.btn_delete -> setupBackspace(child)
                        R.id.btn_space -> child.setOnTouchListener { v, event ->
                            if (event.action == MotionEvent.ACTION_DOWN) {
                                if (isBengali) bengaliEngine.resetBuffer()
                                currentInputConnection?.commitText(" ", 1)
                                v.performClick()
                            }
                            true
                        }
                        R.id.btn_enter -> child.setOnTouchListener { v, event ->
                            if (event.action == MotionEvent.ACTION_DOWN) {
                                triggerKeyEvent(KeyEvent.KEYCODE_ENTER)
                                v.performClick()
                            }
                            true
                        }
                        R.id.btn_shift -> child.setOnTouchListener { v, event ->
                            if (event.action == MotionEvent.ACTION_DOWN) {
                                isSymbols = false
                                toggleCapsLock()
                                v.performClick()
                            }
                            true
                        }
                        R.id.btn_lang -> child.setOnTouchListener { v, event ->
                            if (event.action == MotionEvent.ACTION_DOWN) {
                                toggleLanguage(child)
                                v.performClick()
                            }
                            true
                        }
                        R.id.btn_sym -> child.setOnTouchListener { v, event ->
                            if (event.action == MotionEvent.ACTION_DOWN) {
                                toggleSymbols(child)
                                v.performClick()
                            }
                            true
                        }
                    }
                }
            }
        }
    }

    @android.annotation.SuppressLint("ClickableViewAccessibility")
    private fun setupBackspace(button: Button) {
        button.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    if (isBengali && !isSymbols) {
                        bengaliEngine.handleBackspace(currentInputConnection)
                    } else {
                        triggerKeyEvent(KeyEvent.KEYCODE_DEL)
                    }
                    handler.postDelayed(backspaceRunnable, 400)
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    handler.removeCallbacks(backspaceRunnable)
                    if (event.action == MotionEvent.ACTION_UP) {
                        v.performClick()
                    }
                }
            }
            true
        }
    }

    private fun toggleCapsLock() {
        isCaps = !isCaps
        updateKeyLabels(keyboardView as ViewGroup)
    }

    private fun toggleSymbols(symButton: Button) {
        isSymbols = !isSymbols
        symButton.text = if (isSymbols) "ABC" else "123"
        updateKeyLabels(keyboardView as ViewGroup)
    }

    private fun toggleLanguage(langButton: Button) {
        isBengali = !isBengali
        langButton.text = if (isBengali) "🌐 BN" else "🌐 EN"
        Toast.makeText(this, if (isBengali) "বাংলা মোড সক্রিয়" else "English Mode Active", Toast.LENGTH_SHORT).show()
    }

    private fun updateKeyLabels(viewGroup: ViewGroup) {
        for (i in 0 until viewGroup.childCount) {
            val child = viewGroup.getChildAt(i)
            if (child is ViewGroup) {
                updateKeyLabels(child)
            } else if (child is Button && child.tag == "key") {
                val original = originalKeys[child] ?: child.text.toString().lowercase()
                val newText = if (isSymbols) symbolMap[original] ?: original else original
                child.text = if (isCaps && !isSymbols) newText.uppercase() else newText
            }
        }
    }

    private fun triggerKeyEvent(keyCode: Int) {
        currentInputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, keyCode))
        currentInputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, keyCode))
    }
}
