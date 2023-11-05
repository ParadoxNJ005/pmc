package com.example.login.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.login.databinding.ActivityGrishBinding
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.example.login.R
import com.example.login.fragment.Homefragment
import com.example.login.fragment.Logout_fragment
import com.example.login.fragment.Message_fragment

import com.example.login.fragment.Prime_fragment
import com.example.login.fragment.Profile_fragment
import com.example.login.fragment.Settings_fragment
import com.example.login.fragment.Upload_fragment
import com.example.login.fragment.test
import com.google.android.material.bottomnavigation.BottomNavigationView


val ActivityGrishBinding.toolbar: Toolbar
    get() = this.toolbar

// Extension property for DrawerLayout
val ActivityGrishBinding.drawerLayout: DrawerLayout
    get() = this.drawerLayout
val ActivityGrishBinding.bottomNavigation: BottomNavigationView
    get() = this.bottomNavigation

// Extension property for NavigationView
val ActivityGrishBinding.navigationDrawer: NavigationView
    get() = this.navigationDrawer

class homeScreen : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityGrishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityGrishBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val toggle=ActionBarDrawerToggle(this,binding.drawerLayout,binding.toolbar,
            R.string.Nav_Open,
            R.string.Nav_Close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navigationDrawer.setNavigationItemSelectedListener(this)

        binding.bottomNavigation.background = null
        binding.bottomNavigation.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.BOTTOM_Home -> openFragment(Homefragment())
                R.id.BOTTOM_Profile -> openFragment(Profile_fragment())
                R.id.nav_adopt -> openFragment(Adopt_page())
                R.id.BOTTOM_Upload -> openFragment(Upload_fragment())
                R.id.BOTTOM -> openFragment(test())

            }
            true
        }
        fragmentManager = supportFragmentManager
        openFragment(Homefragment())

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){


            R.id.nav_adopt -> openFragment(Adopt_page())
            R.id.nav_logout -> openFragment(Logout_fragment())

            R.id.nav_RateUs -> openFragment(Rate())
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


