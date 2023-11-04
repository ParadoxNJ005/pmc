package com.example.login

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner


class Profile_fragment : Fragment() {
    private lateinit var upload_button:ImageView

    companion object {
       const  val PET_KEY = "pet"
        const val BREED_KEY = "breed"
        const val AGE_KEY = "age"
        const val GENDER_KEY = "gender"
        const val NAME_KEY = "name"
        const val CITY_KEY = "city"
        const val NUMBER_KEY = "number"
        const val EMAIL_KEY = "email"
        const val BIO_KEY = "bio"
        val Image_request_code=100
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile_fragment2, container, false)

        // Access data from arguments

        val pet = arguments?.getString(PET_KEY)
        val breed = arguments?.getString(BREED_KEY)
        val age = arguments?.getString(AGE_KEY)
        val gender = arguments?.getString(GENDER_KEY)
        val name = arguments?.getString(NAME_KEY)
        val city = arguments?.getString(CITY_KEY)
        val number = arguments?.getString(NUMBER_KEY)
        val email = arguments?.getString(EMAIL_KEY)
        val bio = arguments?.getString(BIO_KEY)

        // Update your UI with the received data
        upload_button=view.findViewById(R.id.plus)
        val petTextView = view.findViewById<TextView>(R.id.petTextView)
        val breedTextView = view.findViewById<TextView>(R.id.breedTextView)
        val ageTextView = view.findViewById<TextView>(R.id.ageTextView)
        val genderTextView = view.findViewById<TextView>(R.id.genderTextView)
        val nameTextView = view.findViewById<TextView>(R.id.nameTextView)
        val cityTextView = view.findViewById<TextView>(R.id.cityTextView)
        val numTextView = view.findViewById<TextView>(R.id.numTextView)
        val emailTextView = view.findViewById<TextView>(R.id.emailTextView)
        val bioTextView = view.findViewById<TextView>(R.id.bioTextView)
        // ... (similarly for other views)

        petTextView.text = pet
        breedTextView.text = breed
        ageTextView.text = age
        genderTextView.text = gender
        nameTextView.text = name
        cityTextView.text = city
        numTextView.text = number
        emailTextView.text = email
        bioTextView.text = bio
        // ... (similarly for other views)

        upload_button.setOnClickListener {
            pickImagegallery()
        }


        return view
    }

    private fun pickImagegallery(){
        val intent=Intent(Intent.ACTION_PICK)
        intent.type="image/*"
        startActivityForResult(intent, Image_request_code)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Image_request_code && resultCode == RESULT_OK) {
            upload_button.setImageURI(data?.data)
        }

    }
    }
}
