package com.example.finalurimangkac.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.finalurimangkac.InformationPerson
import com.example.finalurimangkac.MainActivity
import com.example.finalurimangkac.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ProfileInfoFragment: Fragment(R.layout.fragment_profileinfo) {
    private lateinit var logoutButton: Button
    private lateinit var changePassButton: Button
    private lateinit var firstName: TextView
    private lateinit var lastName: TextView
    private lateinit var age: TextView
    private lateinit var urlSet: EditText
    private lateinit var addImage: Button
    private lateinit var imageView: ImageView

    private lateinit var mAuth: FirebaseAuth
    private lateinit var dataBase: DatabaseReference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAuth = FirebaseAuth.getInstance()
        dataBase = FirebaseDatabase.getInstance().getReference("UserInfo")

        logoutButton = view.findViewById(R.id.logoutButton)
        changePassButton = view.findViewById(R.id.passwordChangeButton)
        firstName = view.findViewById(R.id.personInfoTextView)
        lastName = view.findViewById(R.id.personInfoTextView2)
        age = view.findViewById(R.id.personInfoTextView3)
        urlSet = view.findViewById(R.id.urlInfoTextView)
        addImage = view.findViewById(R.id.addImageButton)
        imageView = view.findViewById(R.id.imageViewProfile)

        if(mAuth.currentUser?.uid != null){
            dataBase.child(mAuth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {
                    val p = snapshot.getValue(InformationPerson::class.java)

                    if(p != null){
                        firstName.text = p.name
                        lastName.text = p.lastName
                        age.text = p.age
                        Glide.with(this@ProfileInfoFragment)
                                .load(p.imageUrl)
                                .centerCrop()
                                .into(imageView)

                    }


                }

                override fun onCancelled(error: DatabaseError) {

                }

            })

        }

        addImage.setOnClickListener {
            if(urlSet.text.toString().isEmpty()){
                Toast.makeText(context, "Url is empty!!", Toast.LENGTH_SHORT).show()
            } else {
                val pr = InformationPerson(
                    firstName.text.toString(),
                    lastName.text.toString(),
                    age.text.toString(),
                    urlSet.text.toString()
                )
                dataBase.child(mAuth.currentUser?.uid!!).setValue(pr)
                    .addOnCompleteListener { task ->

                    }

                if (mAuth.currentUser?.uid != null) {
                    dataBase.child(mAuth.currentUser?.uid!!)
                        .addValueEventListener(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                val per = snapshot.getValue(InformationPerson::class.java)
                                if (per != null) {
                                    Glide.with(this@ProfileInfoFragment)
                                        .load(per.imageUrl)
                                        .centerCrop()
                                        .into(imageView)

                                }

                            }

                            override fun onCancelled(error: DatabaseError) {

                            }
                        })
                }
            }

        }

        logoutButton.setOnClickListener {
            startActivity(Intent(getContext(), MainActivity::class.java ))
            getActivity()?.finish()
            mAuth.signOut()
        }

        changePassButton.setOnClickListener {



        }
    }
}