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
import com.google.firebase.auth.GoogleAuthCredential

class ResetActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var sendButton: Button
    private lateinit var goBackButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset)
        supportActionBar?.hide()
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)

        mAuth = FirebaseAuth.getInstance()

        emailEditText = findViewById(R.id.inputEmailEditText)
        sendButton = findViewById(R.id.sendInfoButton)
        goBackButton = findViewById(R.id.goBackButtonRes)

        goBackButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        sendButton.setOnClickListener{
            val email = emailEditText.text.toString()
            if(email.isEmpty()){
                Toast.makeText(this,"Enter correct Email!", Toast.LENGTH_SHORT).show()
            } else {
                mAuth.sendPasswordResetEmail(email).addOnCompleteListener{task->
                    if (task.isSuccessful){
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}