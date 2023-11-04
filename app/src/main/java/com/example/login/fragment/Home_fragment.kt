package com.example.login.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import com.example.login.adapter.DatingAdapter
import com.example.login.data_class.UserModelClass
import com.example.login.databinding.FragmentHomeFragmentBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction


class Homefragment : Fragment() {

    private lateinit var databaseReference: DatabaseReference
    private lateinit var binding: FragmentHomeFragmentBinding
    private lateinit var manager: CardStackLayoutManager
    private lateinit var listel: ArrayList<UserModelClass>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeFragmentBinding.inflate(layoutInflater)


        databaseReference = FirebaseDatabase.getInstance().getReference("users")
        getData()
//        return inflater.inflate(R.layout.fragment_home_fragment, container, false)
        return binding.root
    }

    private fun init() {
        manager = CardStackLayoutManager(requireContext(), object : CardStackListener {
            override fun onCardDragging(direction: Direction?, ratio: Float) {
                TODO("Not yet implemented")
            }

            override fun onCardSwiped(direction: Direction?) {

                if (manager.topPosition == list.size) {
                    Toast.makeText(requireContext(), "this is last card", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCardRewound() {
                TODO("Not yet implemented")
            }

            override fun onCardCanceled() {
                TODO("Not yet implemented")
            }

            override fun onCardAppeared(view: View?, position: Int) {
                TODO("Not yet implemented")
            }

            override fun onCardDisappeared(view: View?, position: Int) {
                TODO("Not yet implemented")
            }

        })


        manager.setVisibleCount(3)
        manager.setTranslationInterval(0.6f)
        manager.setScaleInterval(0.8f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(Direction.HORIZONTAL)

    }

    private lateinit var list: ArrayList<UserModelClass>

    private fun getData() {
        FirebaseDatabase.getInstance().getReference("users")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    Log.d("SHUBH", "onDataChange: ${snapshot.toString()}")
                    if (snapshot.exists()) {
                        list = ArrayList<UserModelClass>()
                        for (data in snapshot.children) {
                            val model = data.getValue(UserModelClass::class.java)
                            list.add(model!!)
                        }
                        list.shuffle()
                        init()

                        binding.cardStackView.layoutManager = manager
                        binding.cardStackView.itemAnimator = DefaultItemAnimator()
                        binding.cardStackView.adapter = DatingAdapter(requireContext(), list)

                    } else {
                        Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(requireContext(), error.message, Toast.LENGTH_SHORT).show()
                }
            })
    }
}
