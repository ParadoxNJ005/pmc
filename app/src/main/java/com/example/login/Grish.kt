package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.login.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


class Toolnav : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val toggle=ActionBarDrawerToggle(this,binding.drawerLayout,binding.toolbar, R.string.Nav_Open , R.string.Nav_Close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navigationDrawer.setNavigationItemSelectedListener(this)

        binding.bottomNavigation.background = null
        binding.bottomNavigation.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.BOTTOM_Home-> openFragment(Home_fragment())
                R.id.BOTTOM_Profile-> openFragment(Profile_fragment())
                R.id.BOTTOM_Message-> openFragment(Message_fragment())
                R.id.BOTTOM_Notification-> openFragment(Notification_fragment())

            }
            true
        }
        fragmentManager = supportFragmentManager
        openFragment(Home_fragment())

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_prime-> openFragment(Prime_fragment())
            R.id.nav_settings-> openFragment(Settings_fragment())
            R.id.nav_logout-> openFragment(Logout_fragment())
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }


    }
    private fun openFragment(fragment: Fragment){
        val fragmentTransaction: FragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }
}


