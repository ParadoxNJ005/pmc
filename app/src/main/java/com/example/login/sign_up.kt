package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.login.databinding.ActivitySignInBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class Signup : AppCompatActivity() {

    lateinit var etEmail: EditText
    lateinit var etConfPass: EditText
    private lateinit var etPass: EditText
    private lateinit var btnSignUp: Button
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //bindings
        etEmail = findViewById(R.id.email)
        etConfPass = findViewById(R.id.password2)
        etPass = findViewById(R.id.password)
        btnSignUp = findViewById(R.id.resister)
//        tvRedirectLogin = findViewById(R.id.)


        // initialising Firebase auth object
        auth = Firebase.auth

        btnSignUp.setOnClickListener{
            signUpUser()
        }

        }

    private fun signUpUser()
    {
        val email = etEmail.text.toString()
        val pass = etPass.text.toString()
        val confirmpassword = etConfPass.text.toString()

        //check pass
        if(email.isBlank() || pass.isBlank() || confirmpassword.isBlank() )
        {
            Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }
        if (pass != confirmpassword) {
            Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_SHORT)
                .show()
            return
        }
        //if all credential are correct
        //we call create user with Email and password
        //using auth object and pass the
        //email and pass in it
        auth.createUserWithEmailAndPassword(email , pass).addOnCompleteListener(this){


            if(it.isSuccessful){
                Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this,"Singed up Failed",Toast.LENGTH_SHORT).show()
            }
        }



    }

    }
