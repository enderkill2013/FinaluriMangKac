package com.example.finalurimangkac.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.finalurimangkac.frmangad.d1
import com.example.finalurimangkac.frmangad.d2
import com.example.finalurimangkac.frmangad.d3
import com.example.finalurimangkac.frmangad.d4

class ViewPageAdapterDeathNote(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0->d1()
            1->d2()
            2->d3()
            3->d4()

            else -> d1()
        }
    }
}