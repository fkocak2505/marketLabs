package com.fkocak.edittextvalidation

import java.util.*

abstract class BaseVF: IBaseVF {

    /**
     * ignore Spesific Char..
     */
    override fun ignoreSpesificChar(dend: Int, source: CharSequence, c: CharSequence): Boolean {
        if (dend == 0 && (source.toString() == c.toString() || source.toString() == c.toString().toUpperCase(Locale.getDefault())))
            return true
        return false
    }

    /**
     * check consecutive rule for limit params..
     */
    override fun checkConsecutiveRule(str: String, limit: Int): Boolean {
        for (i in str.indices) {
            var count = 1
            for (j in i + 1 until str.length) {
                if (str[i] != str[j])
                    break
                count++
            }

            if (count > limit)
                return true

        }

        return false
    }
}