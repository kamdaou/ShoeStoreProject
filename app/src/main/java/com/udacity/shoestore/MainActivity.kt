package com.udacity.shoestore


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        //menu configuration
        setSupportActionBar(binding.toolbar)
        drawerLayout = binding.drawerLayout

        val navHostFragment =  supportFragmentManager.findFragmentById(R.id.myNavHostFragment)
        val navController = navHostFragment?.findNavController()

        if (navController != null) {
            NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this, R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

}
