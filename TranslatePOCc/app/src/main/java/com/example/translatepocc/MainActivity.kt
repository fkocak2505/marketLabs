package com.example.translatepocc

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.translatepocc.api.ApiInterface
import com.example.translatepocc.api.ApiUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var apiInterface: ApiInterface
    lateinit var tk: TokenGenerator
    lateinit var tokenForSpesificString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        apiInterface = ApiUtils.getApiInterface()
        tk = TokenGenerator("406249.3075489964")
        tokenForSpesificString = tk.token("Benim adım Fatih. Ben Bilgisayar Mühendisiyim")

        val client = "t"
        val sl = "tr"
        val tl = "en"
        val hl = "en"
        val dtArray: MutableList<String> = ArrayList()
        dtArray.add("at")
        dtArray.add("bd")
        dtArray.add("ex")
        dtArray.add("ld")
        dtArray.add("md")
        dtArray.add("qca")
        dtArray.add("rw")
        dtArray.add("rm")
        dtArray.add("ss")
        dtArray.add("t")
        val ie = "UTF-8"
        val oe = "UTF-8"
        val otf = 1
        val ssel = 0
        val tsel = 0
        val kc = 7
        val q = "Benim adım Fatih. Ben Bilgisayar Mühendisiyim"
        val tk = tokenForSpesificString

        deneme.setOnClickListener{
            apiInterface.translate(client, sl, tl, hl, dtArray, ie, oe, otf, ssel, tsel, kc, q, tk).enqueue(object : retrofit2.Callback<String>{
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    response.body()?.let {
                        val translatedText = it
                        val jsonArray = JSONArray(translatedText)
                        val subJArray = jsonArray.getJSONArray(0)
                        var appendedTranslatedText = ""

                        for(i in 0 until subJArray.length()){
                            val jArr = subJArray.getJSONArray(i)
                            val itemOfTranslatedText = jArr.get(0).toString()
                            appendedTranslatedText += " $itemOfTranslatedText"
                        }

                        translatedTextView.text = appendedTranslatedText

                    }
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Toast.makeText(applicationContext, "awfawf", Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}