package com.fkocak.edittextfilterlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import com.fkocak.edittextfilterlab.databinding.ActivityMainBinding
import com.fkocak.vif.VIFEmail
import com.fkocak.vif.VIFName
import com.fkocak.vif.VIFPhone

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val validationOfEmail = VIFEmail(binding.editText, this@MainActivity)
            .etLosesFocus(".", 4)
            .ignoreMultipleSpesificSymbol("@")
            .ignoreFirstSpesificChar(mutableListOf("@","."))
            .ignoreConsecutiveChars(".")
            .ignoreTwoCharsConsecutive(mutableListOf(".@", "@."))

        binding.editText.filters = arrayOf(validationOfEmail)


        val validationOfName = VIFName(this@MainActivity)
            .ignoreFirstSpesificChar(mutableListOf("ğ", " "))
            .ignoreConsecutiveCharByLimit(2)
            .ignoreVowelCharByLimit(3)
            .ignoreConsonantCharByLimit(4)

        binding.editTex1.inputType = InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        binding.editTex1.filters = arrayOf(validationOfName)

        val validationOfPhone = VIFPhone(binding.editTex2, this@MainActivity)
            .etLoseFunction("5", "+90")

        binding.editTex2.filters = arrayOf(validationOfPhone)

//        binding.aaaaa.setOnClickListener {
//            binding.editText.clearFocus()
//        }

    }
}