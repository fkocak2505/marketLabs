package com.fkocak.edittextvalidation


import android.text.InputFilter
import android.text.Spanned
import java.util.regex.Pattern

class VFName : InputFilter, BaseVF() {

    private var source: CharSequence? = null
    private var start: Int? = null
    private var end: Int? = null
    private var dest: Spanned? = null
    private var dstart: Int? = null
    private var dend: Int? = null

    private var regex: String = ""
    private var declineFirstCharecter: String = ""
    private var cLimit: Int = 0
    private var cVowelLimit: Int = 0
    private var cConsonantLimit: Int = 0


    override fun filter(
        source: CharSequence?,
        start: Int,
        end: Int,
        dest: Spanned?,
        dstart: Int,
        dend: Int
    ): CharSequence? {

        this.source = source!!
        this.start = start
        this.end = end
        this.dest = dest!!
        this.dstart = dstart
        this.dend = dend

        for (i in start until end) {

            val checkMe = source.get(i).toString()
            val pattern = Pattern.compile(regex)
            val matcher = pattern.matcher(checkMe)

            /**
             * Igonore spesific charecter started
             */
            if (ignoreSpesificChar(dend, source, declineFirstCharecter))
                return source.drop(1)


            /**
             * ignore consecutive charecter more than 2
             */
            if (checkTurkishChars(source)) {
                if (checkConsecutiveRule(dest.toString() + source.toString(), cLimit))
                    return source.dropLast(1)
            } else {
                if (checkConsecutiveRule(source.toString(), cLimit))
                    return source.dropLast(1)
            }

            /**
             * ignore 3 vowel or 4 consonant charecters
             */
            if (checkTurkishChars(source)) {
                if (checkConsecutiveRule4Vowel(dest.toString() + source.toString(), cVowelLimit)) {
                    return source.dropLast(1)
                }

                if (checkConsecutiveRule4Consonant(dest.toString() + source.toString(), 3)) {
                    return source.dropLast(1)
                }
            } else {
                if (checkConsecutiveRule4Vowel(source.toString(), cVowelLimit)) {
                    return source.dropLast(1)
                }

                if (checkConsecutiveRule4Consonant(source.toString(), cConsonantLimit)) {
                    return source.dropLast(1)
                }
            }

            /**
             * check regex..
             */
            when (matcher.matches()) {
                false -> {
                    return source.dropLast(1)
                }
            }
        }

        return null
    }

    fun regexRule(regex: String): VFName {
        this.regex = regex
        return this
    }

    fun declineFirstCharecters(declineFirstCharecter: String): VFName {
        this.declineFirstCharecter = declineFirstCharecter
        return this
    }

    fun consecutiveLimit(cLimit: Int): VFName {
        this.cLimit = cLimit
        return this
    }

    fun consecutiveVowelLimit(cVowelLimit: Int): VFName {
        this.cVowelLimit = cVowelLimit
        return this
    }

    fun consecutiveConsonantLimit(cConsonantLimit: Int): VFName {
        this.cConsonantLimit = cConsonantLimit
        return this
    }

    /**
     * check Turkish chars for user input letter..
     */
    private fun checkTurkishChars(source: CharSequence?): Boolean {
        return source?.length == 1
    }

    /**
     * Check consecutive Rule 4 Vowel charecters
     */
    private fun checkConsecutiveRule4Vowel(str: String, cLimitVowel: Int): Boolean {
        for (i in str.indices) {
            var count = 1

            if (!isVowel(str[i].toLowerCase()))
                continue

            for (j in i + 1 until str.length) {
                if (!isVowel(str[j].toLowerCase()))
                    break
                count++
            }

            if (count > cLimitVowel)
                return true

        }

        return false


    }

    /**
     * check consecutive Rule 4 Consonant
     */
    private fun checkConsecutiveRule4Consonant(str: String, cLimitConsonant: Int): Boolean {

        for (i in str.indices) {
            var count = 1

            if (str[i] == ' ')
                continue

            if (isVowel(str[i].toLowerCase()))
                continue

            for (j in i + 1 until str.length) {
                if (str[j] == ' ')
                    continue

                if (isVowel(str[j].toLowerCase()))
                    break
                count++
            }

            if (count > cLimitConsonant)
                return true

        }

        return false

    }

    /**
     * charecters isVowel..
     */
    private fun isVowel(char: Char): Boolean {
        return (char == 'a') or (char == 'e') or (char == 'ı') or (char == 'i') or (char == 'o') or (char == 'ö') or (char == 'u') or (char == 'ü')
    }
}