package com.example.kotlin1homework3.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.kotlin1homework3.R
import com.example.kotlin1homework3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_nav_host) as NavHostFragment
        navController = navHostFragment.navController

        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)

        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.charactersFragment,
            R.id.locationsFragment,
            R.id.episodesFragment

        ).build()

        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean{
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}