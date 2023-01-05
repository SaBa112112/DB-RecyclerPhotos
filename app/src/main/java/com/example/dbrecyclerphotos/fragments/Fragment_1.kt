package com.example.dbrecyclerphotos.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.dbrecyclerphotos.LoginActivity
import com.example.dbrecyclerphotos.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Fragment_1: Fragment(R.layout.fragment_1) {
    private lateinit var editTextTextPersonName: EditText
    private lateinit var editTextUrl: EditText
    private lateinit var saveButton: Button
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var clearButton: Button
    private lateinit var logoutButton: Button

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("USER_INFO")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextTextPersonName = view.findViewById(R.id.editTextTextPersonName)
        editTextUrl = view.findViewById(R.id.editTextUrl)
        saveButton = view.findViewById(R.id.button2)
        imageView = view.findViewById(R.id.imageView2)
        textView = view.findViewById(R.id.textView1)
        clearButton = view.findViewById(R.id.button3)
        logoutButton = view.findViewById(R.id.button6)


        saveButton.setOnClickListener {

            val name = editTextTextPersonName.text.toString()
            val url = editTextUrl.text.toString()

            val personInfo = PersonInfo(name, url)

            db.child(auth.currentUser?.uid!!).setValue(personInfo)
        }


        db.child(auth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                val userInfo = snapshot.getValue(PersonInfo::class.java) ?: return

                textView.text = userInfo.name

                Glide.with(this@Fragment_1).load(userInfo.url).into(imageView);

//                Views(userInfo.name,userInfo.url)

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        clearButton.setOnClickListener {
            imageView.setImageDrawable(null)
            textView.text = ""
            editTextTextPersonName.text.clear()
            editTextUrl.text.clear()
//            PersonInfo(name = "", url = "")
            db.child(auth.currentUser?.uid!!).removeValue()
        }

        logoutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}