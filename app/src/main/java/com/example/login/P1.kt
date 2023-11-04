package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageButton

class P1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p1)
        val initialButton = findViewById<ImageButton>(R.id.Initialbutton)

        initialButton.setOnClickListener {
            // Create an Intent to start the second activity (P2Activity)
            val intent = Intent(this, p2 ::class.java)

            // Start the second activity
            startActivity(intent)
        }
    }
}