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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegActivity : AppCompatActivity() {
    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var registerButton: Button
    private lateinit var yourFirstName: EditText
    private lateinit var age: EditText
    private lateinit var yourLastName: EditText
    private lateinit var goBackButton: Button

    private lateinit var mAuth: FirebaseAuth
    private lateinit var dataBase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
        supportActionBar?.hide()
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)

        mAuth = FirebaseAuth.getInstance()
        dataBase = FirebaseDatabase.getInstance().getReference("UserInfo")


        inputEmail = findViewById(R.id.signUpEmailEditText)
        inputPassword = findViewById(R.id.signUpPasswordEditText)
        registerButton = findViewById(R.id.signUpButton)
        yourFirstName = findViewById(R.id.yourFirstNameEditText)
        yourLastName = findViewById(R.id.yourLastNameEditText)
        age = findViewById(R.id.ageEditText)
        goBackButton = findViewById(R.id.goBackButton)

        goBackButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java ))
            finish()

        }

        registerButton.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()
            val name = yourFirstName.text.toString()
            val ageY = age.text.toString().toInt()
            val ageYY = age.text.toString()
            val lastName = yourLastName.text.toString()


            if(email.isEmpty() || password.isEmpty() || name.isEmpty() || lastName.isEmpty() || age.text.toString().isEmpty()){
                Toast.makeText(this,"Your input is EMPTY! Please try again!", Toast.LENGTH_SHORT).show()
            } else {
                if(ageY<=12 || ageY>=89){
                    Toast.makeText(this,"Your age is invalid!", Toast.LENGTH_SHORT).show()
                } else {
                    mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener{ task->
                            if (task.isSuccessful){
                                val pr = InformationPerson(name, lastName, ageYY)

                                if(mAuth.currentUser?.uid != null) {

                                    dataBase.child(mAuth.currentUser?.uid!!).setValue(pr).addOnCompleteListener { task ->
                                        if(task.isSuccessful){
                                            Toast.makeText(this, "Success add information!", Toast.LENGTH_LONG).show()

                                        } else {
                                            Toast.makeText(this, "Information doesnt add!", Toast.LENGTH_LONG).show()
                                        }

                                    }

                                }
                                val intent = Intent(this, PerActivity::class.java)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(this, "Error!", Toast.LENGTH_LONG).show()
                            }

                        }

                }

            }

        }

    }

}