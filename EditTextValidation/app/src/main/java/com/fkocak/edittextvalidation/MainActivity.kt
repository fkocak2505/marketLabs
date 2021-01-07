package com.fkocak.edittextvalidation

import android.os.Bundle
import android.text.InputFilter
import android.text.InputType
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        c_et.inputType = InputType.TYPE_CLASS_NUMBER
        c_et.filters = arrayOf(VFPhone(c_et), InputFilter.LengthFilter(10))

        val vfName = VFName()
            .regexRule("^[a-zA-ZğüşöçıİĞÜŞÖÇ ]+\$")
            .declineFirstCharecters("a")
            .consecutiveLimit(2)
            .consecutiveVowelLimit(2)
            .consecutiveConsonantLimit(3)

        c_et2.filters = arrayOf(vfName)

        c_et3.filters = arrayOf(VFEmail(c_et))

    }

}