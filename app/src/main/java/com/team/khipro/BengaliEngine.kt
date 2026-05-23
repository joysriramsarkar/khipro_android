package com.team.khipro

import android.view.inputmethod.InputConnection

class BengaliEngine {

    private var activeRomanBuffer = ""
    private var lastBengaliLength = 0

    private val stateInit = "init"
    private val shorState = "shor-state"
    private val rephState = "reph-state"
    private val byanjonState = "byanjon-state"

    fun processKeystroke(char: String, ic: InputConnection?) {
        if (ic == null) return

        activeRomanBuffer += char
        val newBengali = convertBufferToBengali(activeRomanBuffer)

        if (lastBengaliLength > 0) {
            ic.deleteSurroundingText(lastBengaliLength, 0)
        }
        ic.commitText(newBengali, 1)
        lastBengaliLength = newBengali.length
    }

    fun handleBackspace(ic: InputConnection?) {
        if (ic == null) return
        
        if (activeRomanBuffer.isNotEmpty()) {
            activeRomanBuffer = activeRomanBuffer.substring(0, activeRomanBuffer.length - 1)
            val newBengali = convertBufferToBengali(activeRomanBuffer)
            
            if (lastBengaliLength > 0) {
                ic.deleteSurroundingText(lastBengaliLength, 0)
            }
            
            if (newBengali.isNotEmpty()) {
                ic.commitText(newBengali, 1)
            }
            lastBengaliLength = newBengali.length
        } else {
            ic.deleteSurroundingText(1, 0)
        }
    }

    fun resetBuffer() {
        activeRomanBuffer = ""
        lastBengaliLength = 0
    }

    private fun convertBufferToBengali(text: String): String {
        var i = 0
        val n = text.length
        var state = stateInit
        val out = StringBuilder()

        while (i < n) {
            val (group, key, value) = findLongest(state, text, i)

            if (group == "") {
                out.append(text[i])
                i++
                state = stateInit
                continue
            }

            if (state == byanjonState && group == "phola") {
                out.append("্")
                out.append(value)
            } else {
                out.append(value)
            }

            i += key.length
            state = applyTransition(state, group)
        }

        return out.toString()
    }

    private fun findLongest(state: String, text: String, i: Int): Triple<String, String, String> {
        val allowed = KhiproData.STATE_GROUP_ORDER[state] ?: return Triple("", "", "")
        
        var maxLookahead = 0
        for (g in allowed) {
            val groupMax = KhiproData.MAXLEN_PER_GROUP[g] ?: 0
            if (groupMax > maxLookahead) maxLookahead = groupMax
        }
        
        val end = minOf(text.length, i + maxLookahead)
        
        for (length in (end - i) downTo 1) {
            val chunk = text.substring(i, i + length)
            for (g in allowed) {
                val map = KhiproData.GROUP_MAPS[g]
                if (map != null && map.containsKey(chunk)) {
                    return Triple(g, chunk, map[chunk]!!)
                }
            }
        }
        return Triple("", "", "")
    }

    private fun applyTransition(state: String, group: String): String {
        return when (state) {
            stateInit -> when (group) {
                "diacritic", "ng", "shor", "fkar", "prithayok", "ongko", "biram" -> shorState
                "reph" -> rephState
                "juktoborno", "byanjon" -> byanjonState
                else -> stateInit
            }
            shorState -> when (group) {
                "diacritic", "ng", "fkar", "shor", "biram", "prithayok", "ongko" -> shorState
                "reph" -> rephState
                "juktoborno", "byanjon" -> byanjonState
                else -> shorState
            }
            rephState -> when (group) {
                "prithayok", "diacritic", "ng", "ae", "kar", "nil" -> shorState
                "juktoborno", "byanjon" -> byanjonState
                else -> rephState
            }
            byanjonState -> when (group) {
                "diacritic", "ng", "prithayok", "ongko", "biram", "kar" -> shorState
                "juktoborno", "phola", "byanjon" -> byanjonState
                else -> byanjonState
            }
            else -> stateInit
        }
    }
}
