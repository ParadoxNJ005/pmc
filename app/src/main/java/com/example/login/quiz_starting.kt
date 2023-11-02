package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
class quiz : AppCompatActivity() {
    companion object{
        val precent:Int=0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton:Button=findViewById(R.id.start)
        startButton.setOnClickListener {
            val intent= Intent(this, ques1::class.java)
            intent.putExtra("percent", precent)
            startActivity(intent)

        }

    }
}