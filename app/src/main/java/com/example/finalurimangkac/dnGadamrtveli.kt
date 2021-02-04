package com.example.finalurimangkac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.finalurimangkac.adapters.ViewPageAdapterDeathNote
import com.google.android.material.tabs.TabLayout

class dnGadamrtveli : AppCompatActivity() {

    private lateinit var tabLayoutDeathNote: TabLayout
    private lateinit var viewPager: ViewPager2

    private lateinit var viewPagerDeathNote: ViewPageAdapterDeathNote

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dn_gadamrtveli)

        tabLayoutDeathNote = findViewById(R.id.tabLayoutDeathNote)
        viewPager = findViewById(R.id.viewPagerDeathNote)

        viewPagerDeathNote = ViewPageAdapterDeathNote(this)

        viewPager.adapter = viewPagerDeathNote
    }
}