package com.fkocak.edittextvalidation

import android.text.InputFilter
import android.text.Spanned
import android.util.Log
import android.util.Patterns
import android.widget.EditText
import java.util.regex.Pattern

class VFEmail(var et: EditText) : InputFilter, BaseVF() {

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

        for (i in start until end) {

            val regex = "[a-zA-Z0-9@._-]"

            val checkMe = source?.get(i).toString()
            val pattern = Pattern.compile(regex)
            val matcher = pattern.matcher(checkMe)

            etLoseFunctions()

            /**
             * multiple @ charecters ignore
             */
            if (source.toString() == "@") {
                if (ignoreMultipleSpesificSymbol(source.toString())) {
                    return source?.dropLast(1)
                }
            }

            /**
             * ignore @ charecters for first charecters..
             */
            if (ignoreSpesificChar(dend, source!!,"@"))
                return source.drop(1)

            /**
             * ignore . charecters for first charecters..
             */
            if (ignoreSpesificChar(dend, source,"."))
                return source.drop(1)

            /**
             * ignore .. charecters
             */
            if (source.toString() == ".") {
                if (checkConsecutiveRule(dest.toString() + source.toString(), 1))
                    return source.dropLast(1)
            }

            /**
             * ignore .@ charecters
             */
            if (ignoreDotAndAtCharsConsecutive(dest.toString() + source.toString(), ".@"))
                return source.dropLast(1)

            /**
             * ignore @. charecters
             */
            if (ignoreDotAndAtCharsConsecutive(dest.toString() + source.toString(), "@."))
                return source.dropLast(1)


            when (matcher.matches()) {
                false -> {
                    return source.dropLast(1)
                }
            }

        }

        return null
    }

    /**
     * ignore multiple spesific symbol..
     */
    private fun ignoreMultipleSpesificSymbol(symbol: String): Boolean {
        return if (dest!!.isNotEmpty()) {
            if (dest!![dest!!.length.minus(1)].toString() == symbol) {
                true
            } else {
                dest!!.contains(symbol, ignoreCase = true)
            }
        } else {
            false
        }
    }

    /**
     * igore dot(.) and at(@) chars consecutive
     */
    private fun ignoreDotAndAtCharsConsecutive(str: String, symbol: String): Boolean {
        return if (str.isNotEmpty()) {
            str.contains(symbol, ignoreCase = true)
        } else {
            false
        }
    }

    /**
     * et loses functions..
     */
    private fun etLoseFunctions() {
        et.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                Log.i("FOCUS = ", "Focus Loses..")
                var finalTexEmail = et.text.toString()


                if (ignoreLastSpesificChar(finalTexEmail, ".")) {
                    finalTexEmail = finalTexEmail.dropLast(1)
                    et.setText(finalTexEmail)
                }

                if (calculateStrLength(finalTexEmail) > 4)
                    Log.i("COUNT = ", "Count Valid ${calculateStrLength(finalTexEmail)}")
                else
                    Log.i("COUNT = ", "Count Invalid ${calculateStrLength(finalTexEmail)}")


                if (isValidEmail(finalTexEmail))
                    Log.i("VALID = ", "Valid")
                else
                    Log.i("VALID = ", "Invalid")
            }
        }
    }

    /**
     * ignore last spesific chars..
     */
    private fun ignoreLastSpesificChar(text: String, c: String): Boolean {
        return text[text.length.minus(1)].toString() == c
    }

    /**
     * calculate str length without @ , - , _ , .
     */
    private fun calculateStrLength(str: String): Int {
        var count = 0
        str.forEach {
            when (it) {
                '@' -> {

                }
                '-' -> {

                }
                '_' -> {

                }
                '.' -> {

                }
                else -> {
                    count++
                }
            }
        }

        return count
    }

    /**
     * isValid email
     */
    private fun isValidEmail(target: CharSequence?): Boolean {
        return if (target == null) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }
}