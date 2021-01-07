package com.fkocak.edittextvalidation

interface IBaseVF {

    fun ignoreSpesificChar(dend: Int, source: CharSequence, c: CharSequence): Boolean

    fun checkConsecutiveRule(str: String, limit: Int): Boolean

}