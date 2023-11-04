package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageButton
class p2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p2)
        val secondbutton = findViewById<ImageButton>(R.id.secondbutton)

        secondbutton.setOnClickListener {
            // Create an Intent to start the second activity (P2Activity)
            val intent = Intent(this, p3 ::class.java)

            // Start the second activity
            startActivity(intent)
        }
    }
}