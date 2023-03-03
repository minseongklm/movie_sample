package com.minseongkim.movie_sample.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.minseongkim.movie_sample.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * Activity for movie flow
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * setup jetpack navigation toolbar.
         */
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        findViewById<Toolbar>(R.id.toolbar)
            .setupWithNavController(navController, appBarConfiguration)


        /**
         * Navigation set custom icon.
         */
        navController.addOnDestinationChangedListener { _, _, _ ->
            findViewById<Toolbar>(
                R.id.toolbar
            ).setNavigationIcon(R.drawable.logo_wanted_24)
        }
    }
}