package com.example.finalurimangkac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button
    private lateinit var resetButton: Button


    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAuth = FirebaseAuth.getInstance()//am cvlads mivanichet firebase da shegvidzlia am saxelit mivmartot

        if(mAuth.currentUser != null ){
            startActivity(Intent(this, PerActivity::class.java))
            finish()
        }

        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)

        inputEmail = findViewById(R.id.signInEmailEditText)
        inputPassword = findViewById(R.id.signInPasswordEditText)
        loginButton = findViewById(R.id.signInButton)
        registerButton = findViewById(R.id.regButton)
        resetButton = findViewById(R.id.resetPasswordButton)

        loginButton.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()
            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"Empty!", Toast.LENGTH_SHORT).show()
            } else {
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task->
                            if(task.isSuccessful){
                                startActivity(Intent(this, PerActivity::class.java ))
                                finish()
                            } else {
                                Toast.makeText(this,"Your Email or Password is incorrect", Toast.LENGTH_SHORT).show()
                            }

                        }

            }

        }

        registerButton.setOnClickListener {
            startActivity(Intent(this, RegActivity::class.java))
        }

        resetButton.setOnClickListener {
            startActivity(Intent(this, ResetActivity::class.java))
        }

    }
}