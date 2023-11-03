package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.content.Intent

class upload : AppCompatActivity() {
    private lateinit var breed_name: EditText
    private lateinit var yrs: EditText
    private lateinit var gender: EditText
    private lateinit var nameinput: EditText
    private lateinit var cityinput: EditText
    private lateinit var numberinput: EditText
    private lateinit var emailinput: EditText
    private lateinit var bio: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)

        breed_name = findViewById(R.id.breed_name)
        yrs = findViewById(R.id.yrs)
        gender = findViewById(R.id.gender)
        nameinput = findViewById(R.id.nameinput)
        cityinput = findViewById(R.id.cityinput)
        numberinput = findViewById(R.id.numberinput)
        emailinput = findViewById(R.id.emailinput)
        bio = findViewById(R.id.bio)


        val breed = breed_name.editableText.toString()
        val age = yrs.editableText.toString()
        val gender = gender.editableText.toString()
        val name = nameinput.editableText.toString()
        val city = cityinput.editableText.toString()
        val num = numberinput.editableText.toString()
        val email = emailinput.editableText.toString()
        val bio = bio.editableText.toString()

        val intent = Intent(this, Profile_fragment::class.java)
        intent.putExtra(Profile_fragment.BREED_KEY, breed)
        intent.putExtra(Profile_fragment.AGE_KEY, age)
        intent.putExtra(Profile_fragment.GENDER_KEY, gender)
        intent.putExtra(Profile_fragment.NAME_KEY, name)
        intent.putExtra(Profile_fragment.CITY_KEY, city)
        intent.putExtra(Profile_fragment.NUMBER_KEY, num)
        intent.putExtra(Profile_fragment.EMAIL_KEY, email)
        intent.putExtra(Profile_fragment.BIO_KEY, bio)
        startActivity(intent)

    }
}
