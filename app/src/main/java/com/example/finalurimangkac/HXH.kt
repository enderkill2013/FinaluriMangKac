package com.example.finalurimangkac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalurimangkac.adapters.itemsadapter
import com.example.finalurimangkac.adapters.itemsdata

class HXH : AppCompatActivity() {
    private lateinit var  recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_h_x_h)
        recyclerView = findViewById(R.id.recyclerview)
        supportActionBar?.hide()

        val hxh = ArrayList<itemsdata>()


        hxh.add(itemsdata("https://upload.wikimedia.org/wikipedia/en/0/0f/Hunter_x_Hunter_cover_-_vol1.jpg"))
        hxh.add(itemsdata("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQu2gUiNaxZNCK8OgLr5p0Oyyo0lPlq_spOow&usqp=CAU"))
        hxh.add(itemsdata("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVfbYO2fsq3GYZqj5hjtiQr8XJUjLo4_wOQA&usqp=CAU"))
        hxh.add(itemsdata("https://i.pinimg.com/originals/e9/b0/31/e9b03114f1880b69583c9ce249d0a2e5.jpg"))
        hxh.add(itemsdata("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/cf7ef530-8d37-4778-a1ba-2146feeb1176/d4p3bbe-046dd13b-77ed-48ac-919b-ba6d20d82204.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3sicGF0aCI6IlwvZlwvY2Y3ZWY1MzAtOGQzNy00Nzc4LWExYmEtMjE0NmZlZWIxMTc2XC9kNHAzYmJlLTA0NmRkMTNiLTc3ZWQtNDhhYy05MTliLWJhNmQyMGQ4MjIwNC5wbmcifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6ZmlsZS5kb3dubG9hZCJdfQ.hvesIyr1Sv5HQncA5jf9LoDbpLrWZKzxw222JzdWliQ"))

        val adapter= itemsadapter(hxh)

        recyclerView.layoutManager = LinearLayoutManager(this )
        recyclerView.adapter = adapter
    }
}