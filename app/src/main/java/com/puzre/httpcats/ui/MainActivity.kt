package com.puzre.httpcats.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.puzre.httpcats.R
import com.puzre.httpcats.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController =
            (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment).navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.allCatsFragment -> {
                    showNavBar()
                }

                R.id.pickCodeFragment -> {
                    showNavBar()
                }

                else -> {
                    hideNavBar()
                }
            }
        }

        binding
            .navigationBar
            .setupWithNavController(navController)

    }

    private fun showNavBar() {
        binding.navigationBar.visibility = View.VISIBLE
    }

    private fun hideNavBar() {
        binding.navigationBar.visibility = View.GONE
    }

}