package com.team.khipro

import android.inputmethodservice.InputMethodService
import android.os.Handler
import android.os.Looper
import android.view.HapticFeedbackConstants
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.OvershootInterpolator
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class KhiproIME : InputMethodService() {

    private var capsState = 0 // 0: lowercase, 1: shifted, 2: caps lock
    private var lastShiftClickTime: Long = 0
    private var isBengali = false
    private var isSymbols = false
    private var isExtraSymbols = false
    private lateinit var keyboardView: View
    private val bengaliEngine = BengaliEngine()

    // প্রতিটি বাটনের অরিজিনাল লেটার মনে রাখার জন্য
    private val originalKeys = mutableMapOf<TextView, String>()

    private val symbolMap = mapOf(
        "q" to "1", "w" to "2", "e" to "3", "r" to "4", "t" to "5",
        "y" to "6", "u" to "7", "i" to "8", "o" to "9", "p" to "0",
        "a" to "@", "s" to "#", "d" to "$", "f" to "%", "g" to "&",
        "h" to "-", "j" to "+", "k" to "(", "l" to ")",
        "z" to "*", "x" to "\"", "c" to "'", "v" to ":", "b" to ";",
        "n" to "!", "m" to "?",
    )

    private val symbolMap2 = mapOf(
        "q" to "[", "w" to "]", "e" to "{", "r" to "}", "t" to "#",
        "y" to "%", "u" to "^", "i" to "*", "o" to "+", "p" to "=",
        "a" to "_", "s" to "\\", "d" to "|", "f" to "~", "g" to "<",
        "h" to ">", "j" to "$", "k" to "£", "l" to "¥",
        "z" to "•", "x" to "°", "c" to "μ", "v" to "π", "b" to "÷",
        "n" to "×", "m" to "¶",
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
        
        // Window Insets handle
        val initialPaddingBottom = keyboardView.paddingBottom
        ViewCompat.setOnApplyWindowInsetsListener(keyboardView) { v, insets ->
            val navBar = insets.getInsets(WindowInsetsCompat.Type.navigationBars())
            v.setPadding(0, v.paddingTop, 0, navBar.bottom + initialPaddingBottom)
            insets
        }

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
        
        // যদি ইউজার ম্যানুয়ালি কার্সর সরায় (কম্পোজিং এরিয়ার বাইরে), তবে বাফার রিসেট করতে হবে।
        // candidatesEnd -1 হলে বুঝতে হবে এখন কোনো কম্পোজিং এরিয়া নেই।
        if (!bengaliEngine.isBufferEmpty() && 
            (newSelStart != candidatesEnd || newSelEnd != candidatesEnd)) {
            bengaliEngine.resetBuffer()
            currentInputConnection?.finishComposingText()
        }
    }

    override fun onStartInput(attribute: EditorInfo?, restarting: Boolean) {
        super.onStartInput(attribute, restarting)
        // নতুন ইনপুট সেশন শুরু হলে বাফার এবং কিবোর্ড স্টেট রিসেট করা নিরাপদ।
        bengaliEngine.resetBuffer()
        if (!restarting) {
            isSymbols = false
            isExtraSymbols = false
            if (isBengali) capsState = 0
            if (::keyboardView.isInitialized) {
                updateKeyLabels(keyboardView as ViewGroup)
            }
        }
    }

    override fun onFinishInputView(finishingInput: Boolean) {
        super.onFinishInputView(finishingInput)
        if (!bengaliEngine.isBufferEmpty()) {
            bengaliEngine.commitAndReset(currentInputConnection)
        }
    }

    private fun applyPressAnimation(v: View) {
        v.animate()
            .scaleX(0.92f).scaleY(0.92f)
            .alpha(0.75f)
            .setDuration(40)
            .setInterpolator(AccelerateInterpolator())
            .start()
        v.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP)
    }

    private fun applyReleaseAnimation(v: View) {
        v.animate()
            .scaleX(1.0f).scaleY(1.0f)
            .alpha(1.0f)
            .setDuration(100)
            .setInterpolator(OvershootInterpolator(1.2f))
            .start()
    }

    @android.annotation.SuppressLint("ClickableViewAccessibility")
    private fun setupKeyListeners(viewGroup: ViewGroup) {
        for (i in 0 until viewGroup.childCount) {
            val child = viewGroup.getChildAt(i)
            if (child is ViewGroup) {
                setupKeyListeners(child)
            } else if (child is TextView) {
                if (child.tag == "key") {
                    originalKeys[child] = child.text.toString().lowercase()
                    child.setOnTouchListener { v, event ->
                        when (event.action) {
                            MotionEvent.ACTION_DOWN -> {
                                applyPressAnimation(v)
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
                                applyReleaseAnimation(v)
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
                                    applyPressAnimation(v)
                                    if (isBengali && !isSymbols) {
                                        bengaliEngine.commitAndReset(currentInputConnection)
                                    }
                                    currentInputConnection?.commitText(" ", 1)
                                    v.performClick()
                                }
                                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                                    applyReleaseAnimation(v)
                                }
                            }
                            true
                        }
                        R.id.btn_enter -> child.setOnTouchListener { v, event ->
                            when (event.action) {
                                MotionEvent.ACTION_DOWN -> {
                                    applyPressAnimation(v)
                                    if (isBengali && !isSymbols) {
                                        bengaliEngine.commitAndReset(currentInputConnection)
                                    }
                                    
                                    val action = currentInputEditorInfo?.actionId ?: EditorInfo.IME_ACTION_NONE
                                    if (action != EditorInfo.IME_ACTION_NONE && action != EditorInfo.IME_ACTION_UNSPECIFIED) {
                                        currentInputConnection?.performEditorAction(action)
                                    } else {
                                        triggerKeyEvent(KeyEvent.KEYCODE_ENTER)
                                    }
                                    v.performClick()
                                }
                                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                                    applyReleaseAnimation(v)
                                }
                            }
                            true
                        }
                        R.id.btn_shift -> child.setOnTouchListener { v, event ->
                            when (event.action) {
                                MotionEvent.ACTION_DOWN -> {
                                    applyPressAnimation(v)
                                    if (isBengali && !isSymbols) {
                                        bengaliEngine.processKeystroke("/", currentInputConnection)
                                    } else if (isSymbols) {
                                        isExtraSymbols = !isExtraSymbols
                                        updateKeyLabels(keyboardView as ViewGroup)
                                    } else {
                                        handleShiftClick()
                                    }
                                    v.performClick()
                                }
                                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                                    applyReleaseAnimation(v)
                                }
                            }
                            true
                        }
                        R.id.btn_lang -> child.setOnTouchListener { v, event ->
                            when (event.action) {
                                MotionEvent.ACTION_DOWN -> {
                                    applyPressAnimation(v)
                                    if (isBengali && !isSymbols) {
                                        bengaliEngine.commitAndReset(currentInputConnection)
                                    }
                                    toggleLanguage()
                                    v.performClick()
                                }
                                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                                    applyReleaseAnimation(v)
                                }
                            }
                            true
                        }
                        R.id.btn_sym -> child.setOnTouchListener { v, event ->
                            when (event.action) {
                                MotionEvent.ACTION_DOWN -> {
                                    applyPressAnimation(v)
                                    if (isBengali && !isSymbols) {
                                        bengaliEngine.commitAndReset(currentInputConnection)
                                    }
                                    toggleSymbols()
                                    v.performClick()
                                }
                                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                                    applyReleaseAnimation(v)
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
    private fun setupBackspace(textView: TextView) {
        textView.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    applyPressAnimation(v)
                    if (isBengali && !isSymbols) {
                        bengaliEngine.handleBackspace(currentInputConnection)
                    } else {
                        triggerKeyEvent(KeyEvent.KEYCODE_DEL)
                    }
                    handler.postDelayed(backspaceRunnable, 400)
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    applyReleaseAnimation(v)
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

    private fun toggleSymbols() {
        isSymbols = !isSymbols
        if (!isSymbols) isExtraSymbols = false
        updateKeyLabels(keyboardView as ViewGroup)
    }

    private fun toggleLanguage() {
        isBengali = !isBengali
        if (isBengali) capsState = 0
        updateKeyLabels(keyboardView as ViewGroup)
        Toast.makeText(this, if (isBengali) "বাংলা মোড সক্রিয়" else "English Mode Active", Toast.LENGTH_SHORT).show()
    }

    private fun updateKeyLabels(viewGroup: ViewGroup) {
        for (i in 0 until viewGroup.childCount) {
            val child = viewGroup.getChildAt(i)
            if (child is ViewGroup) {
                updateKeyLabels(child)
            } else if (child is TextView) {
                when {
                    child.tag == "key" -> {
                        val original = originalKeys[child] ?: child.text.toString().lowercase()
                        val currentMap = if (isExtraSymbols) symbolMap2 else symbolMap
                        var newText = if (isSymbols) currentMap[original] ?: original else original

                        if (isBengali && isSymbols) {
                            newText = KhiproData.ONGKO[newText] ?: KhiproData.BIRAM[newText] ?: newText
                        }

                        child.text = if (capsState > 0 && !isSymbols) newText.uppercase() else newText
                    }
                    child.id == R.id.btn_shift -> {
                        if (isBengali && !isSymbols) {
                            child.text = "/"
                        } else if (isSymbols) {
                            child.text = if (isExtraSymbols) "2/2" else "1/2"
                        } else {
                            child.text = when (capsState) {
                                2 -> "CAPS"
                                1 -> "⬆"
                                else -> "⇧"
                            }
                        }
                    }
                    child.id == R.id.btn_sym -> {
                        child.text = if (isSymbols) "ABC" else "?123"
                    }
                    child.id == R.id.btn_lang -> {
                        child.text = if (isBengali) "🌐 BN" else "🌐 EN"
                    }
                    child.id == R.id.btn_space -> {
                        child.text = if (isBengali) "বাংলা" else "English"
                    }
                    child.id == R.id.btn_enter -> {
                        val action = currentInputEditorInfo?.actionId ?: EditorInfo.IME_ACTION_NONE
                        child.text = when (action) {
                            EditorInfo.IME_ACTION_GO -> "GO"
                            EditorInfo.IME_ACTION_NEXT -> "NEXT"
                            EditorInfo.IME_ACTION_SEARCH -> "SEARCH"
                            EditorInfo.IME_ACTION_SEND -> "SEND"
                            EditorInfo.IME_ACTION_DONE -> "DONE"
                            else -> "↵"
                        }
                    }
                }
            }
        }
    }

    private fun triggerKeyEvent(keyCode: Int) {
        currentInputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, keyCode))
        currentInputConnection?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, keyCode))
    }
}
