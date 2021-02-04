package com.example.finalurimangkac.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.finalurimangkac.*


class HomeFragment: Fragment(R.layout.fragment_home) {
    private lateinit var hunterButton: Button
    private lateinit var noteButton: Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hunterButton = view.findViewById(R.id.hunterButton)
        noteButton = view.findViewById(R.id.noteButton)

        hunterButton.setOnClickListener {
            startActivity(Intent(getContext(),  HXH::class.java ))

        }
        noteButton.setOnClickListener {
            startActivity((Intent(getContext(), DN::class.java)))
        }


    }


}