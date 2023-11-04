package com.example.login.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.login.R
import com.example.login.databinding.ActivityP33Binding

class p33 : AppCompatActivity() {

    private lateinit var binding: ActivityP33Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p33)

        binding= ActivityP33Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.thirdbutton.setOnClickListener {
            // Create an Intent to start the second activity (P2Activity)
            val intent = Intent(this, sign_in ::class.java)

            // Start the second activity
            startActivity(intent)
        }

    }
}