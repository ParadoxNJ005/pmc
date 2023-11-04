package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.ads.mediationtestsuite.activities.HomeActivity
import com.google.firebase.auth.FirebaseAuth

class Sign_in : AppCompatActivity() {

    private lateinit var tvredirectsignup: TextView
    private lateinit var etpass: EditText
    lateinit var etEmail: EditText
    lateinit var btnLogin: Button

    //create firebaseauth object
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        //view Binding
        tvredirectsignup = findViewById(R.id.signup)
        btnLogin = findViewById(R.id.submit)
        etEmail = findViewById(R.id.email)
        etpass = findViewById(R.id.password)

        //initialising Firebase auth object
        auth = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener() {
            login()
        }

        tvredirectsignup.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
            //using finish() to end the activity
            finish()
        }
    }

    private fun login() {
        val email = etEmail.text.toString()
        val pass = etpass.text.toString()

        //calling signInWithEmailAndPassword(email,pass)
        //function using firebase auth object
        //on successful response display a toast
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish() // Optional: Finish the current activity to prevent going back to the login screen
            } else {
                Toast.makeText(this, "Log In failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
