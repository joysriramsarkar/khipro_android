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

    private var capsState = 0 // 0: lowercase, 1: shifted, 2: caps lock
    private var lastShiftClickTime: Long = 0
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
        "n" to "!", "m" to "?",
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
        originalKeys.clear()
        keyboardView = layoutInflater.inflate(R.layout.keyboard_layout, null)
        setupKeyListeners(keyboardView as ViewGroup)
        updateKeyLabels(keyboardView as ViewGroup)
        return keyboardView
    }

    override fun onUpdateSelection(
        oldSelStart: Int, oldSelEnd: Int,
        newSelStart: Int, newSelEnd: Int,
        candidatesStart: Int, candidatesEnd: Int,
    ) {
        super.onUpdateSelection(oldSelStart, oldSelEnd, newSelStart, newSelEnd, candidatesStart, candidatesEnd)
        if (candidatesEnd != -1 && (newSelStart != candidatesEnd)) {
            bengaliEngine.resetBuffer()
        }
    }

    override fun onStartInput(attribute: android.view.inputmethod.EditorInfo?, restarting: Boolean) {
        super.onStartInput(attribute, restarting)
        if (!restarting) bengaliEngine.resetBuffer()
    }

    override fun onFinishInputView(finishingInput: Boolean) {
        super.onFinishInputView(finishingInput)
        bengaliEngine.resetBuffer()
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
                        when (event.action) {
                            MotionEvent.ACTION_DOWN -> {
                                v.animate().scaleX(0.90f).scaleY(0.90f).setDuration(60).start()
                                v.alpha = 0.7f
                                val textToCommit = child.text.toString()
                                if (isBengali && !isSymbols) {
                                    bengaliEngine.processKeystroke(textToCommit, currentInputConnection)
                                } else {
                                    currentInputConnection?.commitText(textToCommit, 1)
                                    if (capsState == 1) {
                                        capsState = 0
                                        updateKeyLabels(keyboardView as ViewGroup)
                                    }
                                }
                                v.performClick()
                            }
                            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                                v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(60).start()
                                v.alpha = 1.0f
                            }
                        }
                        true
                    }
                } else {
                    when (child.id) {
                        R.id.btn_delete -> setupBackspace(child)
                        R.id.btn_space -> child.setOnTouchListener { v, event ->
                            when (event.action) {
                                MotionEvent.ACTION_DOWN -> {
                                    v.animate().scaleX(0.98f).scaleY(0.92f).setDuration(60).start()
                                    v.alpha = 0.7f
                                    if (isBengali && !isSymbols) {
                                        bengaliEngine.commitAndReset(currentInputConnection)
                                    }
                                    currentInputConnection?.commitText(" ", 1)
                                    v.performClick()
                                }
                                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                                    v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(60).start()
                                    v.alpha = 1.0f
                                }
                            }
                            true
                        }
                        R.id.btn_enter -> child.setOnTouchListener { v, event ->
                            when (event.action) {
                                MotionEvent.ACTION_DOWN -> {
                                    v.animate().scaleX(0.90f).scaleY(0.90f).setDuration(60).start()
                                    v.alpha = 0.8f
                                    if (isBengali && !isSymbols) {
                                        bengaliEngine.commitAndReset(currentInputConnection)
                                    }
                                    triggerKeyEvent(KeyEvent.KEYCODE_ENTER)
                                    v.performClick()
                                }
                                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                                    v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(60).start()
                                    v.alpha = 1.0f
                                }
                            }
                            true
                        }
                        R.id.btn_shift -> child.setOnTouchListener { v, event ->
                            when (event.action) {
                                MotionEvent.ACTION_DOWN -> {
                                    v.animate().scaleX(0.90f).scaleY(0.90f).setDuration(60).start()
                                    v.alpha = 0.7f
                                    if (isBengali && !isSymbols) {
                                        bengaliEngine.processKeystroke("/", currentInputConnection)
                                    } else {
                                        isSymbols = false
                                        handleShiftClick()
                                    }
                                    v.performClick()
                                }
                                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                                    v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(60).start()
                                    v.alpha = 1.0f
                                }
                            }
                            true
                        }
                        R.id.btn_lang -> child.setOnTouchListener { v, event ->
                            when (event.action) {
                                MotionEvent.ACTION_DOWN -> {
                                    v.animate().scaleX(0.90f).scaleY(0.90f).setDuration(60).start()
                                    v.alpha = 0.7f
                                    if (isBengali && !isSymbols) {
                                        bengaliEngine.commitAndReset(currentInputConnection)
                                    }
                                    toggleLanguage(child)
                                    v.performClick()
                                }
                                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                                    v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(60).start()
                                    v.alpha = 1.0f
                                }
                            }
                            true
                        }
                        R.id.btn_sym -> child.setOnTouchListener { v, event ->
                            when (event.action) {
                                MotionEvent.ACTION_DOWN -> {
                                    v.animate().scaleX(0.90f).scaleY(0.90f).setDuration(60).start()
                                    v.alpha = 0.7f
                                    if (isBengali && !isSymbols) {
                                        bengaliEngine.commitAndReset(currentInputConnection)
                                    }
                                    toggleSymbols(child)
                                    v.performClick()
                                }
                                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                                    v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(60).start()
                                    v.alpha = 1.0f
                                }
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
                    v.animate().scaleX(0.90f).scaleY(0.90f).setDuration(60).start()
                    v.alpha = 0.7f
                    if (isBengali && !isSymbols) {
                        bengaliEngine.handleBackspace(currentInputConnection)
                    } else {
                        triggerKeyEvent(KeyEvent.KEYCODE_DEL)
                    }
                    handler.postDelayed(backspaceRunnable, 400)
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(60).start()
                    v.alpha = 1.0f
                    handler.removeCallbacks(backspaceRunnable)
                    if (event.action == MotionEvent.ACTION_UP) {
                        v.performClick()
                    }
                }
            }
            true
        }
    }

    private fun handleShiftClick() {
        val currentTime = System.currentTimeMillis()
        capsState = if (currentTime - lastShiftClickTime < 300) {
            2 // Caps Lock
        } else {
            if (capsState == 0) 1 else 0
        }
        lastShiftClickTime = currentTime
        updateKeyLabels(keyboardView as ViewGroup)
    }

    private fun toggleSymbols(symButton: Button) {
        isSymbols = !isSymbols
        symButton.text = if (isSymbols) "ABC" else "123"
        updateKeyLabels(keyboardView as ViewGroup)
    }

    private fun toggleLanguage(langButton: Button) {
        isBengali = !isBengali
        if (isBengali) capsState = 0
        langButton.text = if (isBengali) "🌐 BN" else "🌐 EN"
        updateKeyLabels(keyboardView as ViewGroup)
        Toast.makeText(this, if (isBengali) "বাংলা মোড সক্রিয়" else "English Mode Active", Toast.LENGTH_SHORT).show()
    }

    private fun updateKeyLabels(viewGroup: ViewGroup) {
        for (i in 0 until viewGroup.childCount) {
            val child = viewGroup.getChildAt(i)
            if (child is ViewGroup) {
                updateKeyLabels(child)
            } else if (child is Button) {
                if (child.tag == "key") {
                    val original = originalKeys[child] ?: child.text.toString().lowercase()
                    var newText = if (isSymbols) symbolMap[original] ?: original else original

                    if (isBengali && isSymbols) {
                        newText = when (newText) {
                            "1" -> "১"
                            "2" -> "২"
                            "3" -> "৩"
                            "4" -> "৪"
                            "5" -> "৫"
                            "6" -> "৬"
                            "7" -> "৭"
                            "8" -> "৮"
                            "9" -> "৯"
                            "0" -> "০"
                            else -> KhiproData.BIRAM[newText] ?: newText
                        }
                    }

                    child.text = if (capsState > 0 && !isSymbols) newText.uppercase() else newText
                } else if (child.id == R.id.btn_shift) {
                    if (isBengali && !isSymbols) {
                        child.text = "/"
                    } else {
                        child.text = when (capsState) {
                            2 -> "CAPS"
                            1 -> "⇧"
                            else -> "⇧"
                        }
                    }
                } else if (child.id == R.id.btn_sym) {
                    child.text = if (isSymbols) "ABC" else "123"
                } else if (child.id == R.id.btn_lang) {
                    child.text = if (isBengali) "🌐 BN" else "🌐 EN"
                }
            }
        }
    }

    private fun triggerKeyEvent(keyCode: Int) {
        currentInputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, keyCode))
        currentInputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, keyCode))
    }
}
