package com.example.finalurimangkac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class PerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_per)
        supportActionBar?.hide()
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)

        val navView : BottomNavigationView = findViewById(R.id.nav_control)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfig = AppBarConfiguration(setOf(
            R.id.navigationHomeFragment, R.id.navigationMusicListFragment, R.id.navigationProfileInfoFragment
        ))

        setupActionBarWithNavController(navController, appBarConfig)
        navView.setupWithNavController(navController)

    }
}