package com.example.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.login.MainActivity
import com.example.login.Ques_1
import com.example.login.R

class Notification_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_notification_fragment, container, false)

        // Find the startButton in the fragment's layout
        val startButton: Button = view.findViewById(R.id.start)

        // Set an OnClickListener for the startButton
        startButton.setOnClickListener {
            val intent = Intent(activity, Ques_1::class.java)
            intent.putExtra("percent", MainActivity.percent) // Access the percent value from your companion object
            startActivity(intent)
        }

        return view
    }
}
