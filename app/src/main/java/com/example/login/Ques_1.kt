package com.example.login

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Ques_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ques1)

        val startButton: Button =findViewById(R.id.n1)
        startButton.setOnClickListener {
            val intent= Intent(this, Ques_2::class.java)
            startActivity(intent)
        }
        val o1:Button=findViewById(R.id.q1o1)
        val o2:Button=findViewById(R.id.q1o2)
        val o3:Button=findViewById(R.id.q1o3)
        val o4:Button=findViewById(R.id.startbutton)

        o1.setOnClickListener {
            o1.setBackgroundColor(Color.parseColor("#008000"))
            o2.setBackgroundColor(Color.parseColor("#000080"))
            o3.setBackgroundColor(Color.parseColor("#000080"))
            o4.setBackgroundColor(Color.parseColor("#000080"))


        }
        o2.setOnClickListener {
            o2.setBackgroundColor(Color.parseColor("#008000"))
            o1.setBackgroundColor(Color.parseColor("#000080"))
            o3.setBackgroundColor(Color.parseColor("#000080"))
            o4.setBackgroundColor(Color.parseColor("#000080"))
        }
        o3.setOnClickListener {
            o3.setBackgroundColor(Color.parseColor("#008000"))
            o2.setBackgroundColor(Color.parseColor("#000080"))
            o1.setBackgroundColor(Color.parseColor("#000080"))
            o4.setBackgroundColor(Color.parseColor("#000080"))
        }
        o4.setOnClickListener {
            o4.setBackgroundColor(Color.parseColor("#008000"))
            o2.setBackgroundColor(Color.parseColor("#000080"))
            o3.setBackgroundColor(Color.parseColor("#000080"))
            o1.setBackgroundColor(Color.parseColor("#000080"))
        }

    }
}