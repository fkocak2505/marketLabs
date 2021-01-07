package com.fkocak.edittextvalidation

import android.text.InputFilter
import android.text.Spanned
import android.util.Log
import android.widget.EditText

class VFPhone(var et: EditText) : InputFilter, BaseVF() {

    private var source: CharSequence? = null
    private var start: Int? = null
    private var end: Int? = null
    private var dest: Spanned? = null
    private var dstart: Int? = null
    private var dend: Int? = null

    override fun filter(
        source: CharSequence?,
        start: Int,
        end: Int,
        dest: Spanned?,
        dstart: Int,
        dend: Int
    ): CharSequence? {

        this.source = source
        this.start = start
        this.end = end
        this.dest = dest
        this.dstart = dstart
        this.dend = dend

        /*for (i in start until end) {
            if (checkConsecutiveRule(dest.toString() + source.toString(), 8))
                return source?.dropLast(1)

            if (ignoreSequentialNumber(dest.toString() + source.toString()))
                return source?.dropLast(1)

        }*/

        etLoseFunction()

        return null
    }

    /**
     * ignore sequential number. Rule for 5 or more
     */
    private fun ignoreSequentialNumber(str: String): Boolean {
        var count = 0
        for (i in str.indices) {

            for (j in i + 1 until str.length) {

                if (str[i].toInt() + 1 == str[j].toInt()) {
                    count++
                    break
                } else
                    break
            }

        }

        return count > 8
    }

    /**
     * et Functions..
     */
    private fun etLoseFunction() {
        et.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val phoneNumber = et.text.toString()

                checkAreaCode(phoneNumber)?.let {
                    if (it)
                        Log.i("Invalid == ", phoneNumber)
                    else
                        Log.i("Valid == ", phoneNumber)
                }

            }
        }
    }

    /**
     * check are code first digit is 5..
     */
    private fun checkAreaCode(str: String): Boolean? {
        return if (str.isNotEmpty())
            str[0].toString() != "5"
        else
            null

    }
}