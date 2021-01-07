package com.fkocak.mlparalallaxrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.content.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_category.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_category.adapter = CountryAdapter(getModels())

    }

    private fun getModels(): MutableList<CountryModel> {

        return mutableListOf(
                CountryModel(R.drawable.ic_launcher_background, "Çin", "Pekin"),
                CountryModel(R.drawable.ic_launcher_background, "Mısır", "Kahire"),
                CountryModel(R.drawable.ic_launcher_background, "Almanya", "Berlin"),
                CountryModel(R.drawable.ic_launcher_background, "Türkiye", "Ankara"),
                CountryModel(R.drawable.ic_launcher_background, "Rusya", "Moskova"),
                CountryModel(R.drawable.ic_launcher_background, "İngiltere", "Londra"),
                CountryModel(R.drawable.ic_launcher_background, "Ukrayna", "Kiev"),
                CountryModel(R.drawable.ic_launcher_background, "Japonya", "Tokyo")
        )
    }
}