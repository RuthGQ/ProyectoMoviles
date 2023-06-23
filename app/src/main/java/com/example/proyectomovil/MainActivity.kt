package com.example.proyectomovil

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.proyectomovil.databinding.ActivityMainBinding
import com.example.proyectomovil.ui.view.fragment.CartaFragment
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    /*private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Inicio", "Empezandooo")

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }}

        /*drawerLayout = findViewById(R.id.drawer_layout)


        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            findViewById(R.id.toolbar),
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)






        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item clicks here
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Handle home item click
                    Toast.makeText(applicationContext, "Home clicked", Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    return@setNavigationItemSelectedListener true

                    true
                }
                R.id.nav_profile -> {
                    // Handle profile item click
                    Toast.makeText(applicationContext, "Profile clicked", Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_settings -> {
                    // Handle settings item click
                    Toast.makeText(applicationContext, "Settings clicked", Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_logout -> {
                    // Handle logout item click
                    Toast.makeText(applicationContext, "Logout clicked", Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_contactus -> {
                    // Handle contact us item click
                    Toast.makeText(applicationContext, "Contact us clicked", Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_rate -> {
                    // Handle rate item click
                    Toast.makeText(applicationContext, "Rate clicked", Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_about -> {
                    // Handle about item click
                    Toast.makeText(applicationContext, "About clicked", Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                else -> false
            }
            true
        }

    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
*/

