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

class Upload_fragment : Fragment() {


    private lateinit var button: Button
    private lateinit var image: ImageView

    companion object{
         val Image_request_code=100
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_upload_fragment, container, false)

        button = view.findViewById(R.id.upload_img)
//        image = view.findViewById(R.id.imageView)

        button.setOnClickListener {
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
        if(requestCode== Image_request_code && resultCode== RESULT_OK){
            image.setImageURI(data?.data)
        }
    }



}

//package com.example.imageupload
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import android.widget.ImageView
//
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var button:Button
//    private lateinit var image:ImageView
//
//    companion object{
//        val Image_request_code=100
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        button=findViewById(R.id.button)
//        image=findViewById(R.id.imageView)
//
//        button.setOnClickListener {
//            pickImagegallery()
//        }
//
//    }
//
//    private fun pickImagegallery(){
//        val intent=Intent(Intent.ACTION_PICK)
//        intent.type="image/*"
//        startActivityForResult(intent, Image_request_code)
//
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(requestCode== Image_request_code && resultCode== RESULT_OK){
//            image.setImageURI(data?.data)
//        }
//    }
//
//}