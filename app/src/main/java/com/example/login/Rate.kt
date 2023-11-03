package com.example.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

class Rate : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_rate, container, false)

        val btnClickMe = view.findViewById<Button>(R.id.btnfeedback)

        btnClickMe.setOnClickListener{
            Toast.makeText(requireContext(), "Woah! Thanks Man", Toast.LENGTH_LONG).show()
        }

        return view
    }
}

