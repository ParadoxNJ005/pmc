package com.example.login.fragment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.login.R
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class Upload_fragment : Fragment() {

    private lateinit var button: Button
    private lateinit var image: ImageView
    private lateinit var storageReference: StorageReference

    private var imageUri : Uri? = null

    private val selectImage = registerForActivityResult(ActivityResultContracts.GetContent()){
        imageUri = it
        image.setImageURI(imageUri)
    }

    companion object {
        const val Image_request_code = 100
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_upload_fragment, container, false)

        button = view.findViewById(R.id.upload_img)
        image = view.findViewById(R.id.userImage)
        storageReference = FirebaseStorage.getInstance().reference

        button.setOnClickListener {
            uploadImage()
        }

        image.setOnClickListener {
            selectImage.launch("image/*")
        }

        return view
    }

    private fun uploadImage() {
        if (imageUri != null) {
            val fileName = "user_image.jpg"
            val imageRef = storageReference.child(fileName)
            val uploadTask = imageRef.putFile(imageUri!!)

            uploadTask.addOnSuccessListener {
                // Image uploaded successfully
            }.addOnFailureListener {
                // Handle error
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Image_request_code && resultCode == RESULT_OK) {
            imageUri = data?.data
            image.setImageURI(imageUri)
        }
    }
}
