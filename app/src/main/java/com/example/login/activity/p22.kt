
package com.example.login.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.login.databinding.ActivityP22Binding

class p22 : AppCompatActivity() {

    private lateinit var binding: ActivityP22Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityP22Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.secondbutton.setOnClickListener {
            // Create an Intent to start the second activity (P2Activity)
            val intent = Intent(this, p33 ::class.java)

            // Start the second activity
            startActivity(intent)
        }
    }
}