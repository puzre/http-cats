package com.puzre.httpcats.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        binding
            .navigationBar
            .setupWithNavController(
                (supportFragmentManager
                    .findFragmentById(R.id.fragmentContainerView) as NavHostFragment)
                    .navController
            )

    }


}