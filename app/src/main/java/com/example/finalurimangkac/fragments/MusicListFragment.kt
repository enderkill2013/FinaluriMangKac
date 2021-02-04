package com.example.finalurimangkac.fragments


import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.finalurimangkac.R
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.storage.FirebaseStorage
import java.io.IOException


class MusicListFragment: Fragment (R.layout.fragment_musiclist) {


   private lateinit var playImageButton1: ImageButton
   private lateinit var pauseImageButton1: ImageButton
   private lateinit var playImageButton2: ImageButton
   private lateinit var pauseImageButton2: ImageButton
   private lateinit var playImageButton3: ImageButton
   private lateinit var pauseImageButton3: ImageButton
   private var counter: Int = 0
   private lateinit var playImageButton4: ImageButton
   private lateinit var pauseImageButton4: ImageButton
   private lateinit var chillMediaPlayer: MediaPlayer
   private lateinit var mmediaPlayer: MediaPlayer
   private lateinit var rainSound: MediaPlayer
   private lateinit var jpSound: MediaPlayer


   var jai = "gs://saboloogamocda.appspot.com/epicmusic.mp3"


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mmediaPlayer = MediaPlayer()
        var storage = FirebaseStorage.getInstance()

        chillMediaPlayer = MediaPlayer.create(context, R.raw.sleep)
        rainSound = MediaPlayer.create(context, R.raw.soundofrain)
        jpSound = MediaPlayer.create(context, R.raw.japanes)


        playImageButton1 = view.findViewById(R.id.playImageButton1)
        pauseImageButton1 = view.findViewById(R.id.pauseImageButton1)
        playImageButton2 = view.findViewById(R.id.playImageButton2)
        pauseImageButton2 = view.findViewById(R.id.pauseImageButton2)
        playImageButton3 = view.findViewById(R.id.playImageButton3)
        pauseImageButton3 = view.findViewById(R.id.pauseImageButton3)
        playImageButton4 = view.findViewById(R.id.playImageButton4)
        pauseImageButton4 = view.findViewById(R.id.pauseImageButton4)

        playImageButton1.setOnClickListener {
            chillMediaPlayer.start()

        }

        pauseImageButton1.setOnClickListener {
          chillMediaPlayer.pause()

        }

        playImageButton3.setOnClickListener {
            rainSound.start()

        }
        pauseImageButton3.setOnClickListener {
            rainSound.pause()
        }

        playImageButton4.setOnClickListener {
            jpSound.start()
        }
        pauseImageButton4.setOnClickListener {
            jpSound.pause()
        }


        playImageButton2.setOnClickListener {
            var storageRef = storage.getReferenceFromUrl("gs://saboloogamocda.appspot.com/epicmusic.mp3")
            counter = counter + 1
            storageRef.getDownloadUrl().addOnSuccessListener(OnSuccessListener<Any> { uri ->
                try {
                    // Download url of file
                    val url = uri.toString()
                    mmediaPlayer!!.setDataSource(url)
                    // wait for media player to get prepare
                    mmediaPlayer!!.setOnPreparedListener { player ->
                        if(counter % 2 == 1) {
                            player.start()
                        } else {
                            player.pause()
                        }
                    }
                    mmediaPlayer!!.prepare()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            })

        }

    }

}