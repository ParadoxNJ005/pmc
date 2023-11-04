package com.example.login.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.login.databinding.ActivityP11Binding

class p11 : AppCompatActivity() {
    private lateinit var binding:ActivityP11Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityP11Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Initialbutton.setOnClickListener {
            // Create an Intent to start the second activity (P2Activity)
            val intent = Intent(this, p22 ::class.java)

            // Start the second activity
            startActivity(intent)
        }
        }
    }
