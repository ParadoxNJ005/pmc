package com.example.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.login.databinding.FragmentHomeFragmentBinding


class Homefragment : Fragment() {

     private lateinit var binding: FragmentHomeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeFragmentBinding.inflate(layoutInflater)

        getData()
//        return inflater.inflate(R.layout.fragment_home_fragment, container, false)
        return binding.root
    }

    private fun getData(){
        FirebaseDatabase.getInstance().getReference("users")
            .addValueEventListener(object : ValueEventListener)
    }


}