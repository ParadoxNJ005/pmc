package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageButton


class p3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p3)
        val thirdbutton = findViewById<ImageButton>(R.id.thirdbutton)

        thirdbutton.setOnClickListener {
            // Create an Intent to start the second activity (P2Activity)
            val intent = Intent(this, Sign_in::class.java)

            // Start the second activity
            startActivity(intent)
        }

    }
}