package com.example.finalurimangkac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalurimangkac.adapters.deathnoteadapter
import com.example.finalurimangkac.adapters.deathnotedata

class DN : AppCompatActivity() {
    private  lateinit var  recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d_n)
        recyclerView = findViewById(R.id.r1)
        supportActionBar?.hide()

        val death = ArrayList<deathnotedata>()

        death.add(deathnotedata("https://i.pinimg.com/originals/99/c6/59/99c6595ca45238b21a41c547dd55d223.jpg?fbclid=IwAR3NgV7THJmyntZZPi5EeLf7IA1TlGOJou7jD6eYND9a-Ru43egZAxcfCvg"))
        death.add(deathnotedata("https://media1.fdncms.com/charlotte/imager/death-note-and-company-a-case-for-manga/u/original/3192685/1377219476-deathnote2.jpg?fbclid=IwAR3FI9q8h5XyrKqAM6Jo-WZvdQ0Dst989fu4Z-xMc65vrY7UvyYEkR4efIg"))
        death.add(deathnotedata(""))
        death.add(deathnotedata(""))
        death.add(deathnotedata(""))
        death.add(deathnotedata(""))

        val adapter= deathnoteadapter(death)
        recyclerView.layoutManager = LinearLayoutManager(this )
        recyclerView.adapter = adapter
    }
}