package com.fkocak.edittextfilterlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fkocak.edittextfilterlab.databinding.ActivityMainBinding
import com.fkocak.vif.VIFEmail

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

//        binding.aaaaa.setOnClickListener {
//            binding.editText.clearFocus()
//        }

    }
}