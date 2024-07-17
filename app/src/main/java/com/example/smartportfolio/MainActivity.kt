package com.example.smartportfolio

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.smartportfolio.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle
    var initTime = 0L

    companion object {
        private const val BACK_PRESS_INTERVAL = 3000L
        private const val EXIT_MESSAGE = "\t\t정말 종료하시겠습니까? \n종료하려면 한 번 더 누르세요!"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainDrawerView.setNavigationItemSelectedListener(this)

        setSupportActionBar(binding.toolbar)
        toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened, R.string.drawer_closed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (toggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navi_home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.navi_project -> {
                val intent = Intent(this, ProjectTest::class.java)
                startActivity(intent)
            }
            R.id.navi_lyuHyeWon -> {
                val intent = Intent(this, LyuHyeWon::class.java)
                startActivity(intent)
            }
            R.id.navi_class -> {
                val intent = Intent(this, Class::class.java)
                startActivity(intent)
            }
            R.id.navi_github -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/lyuhw1023"))
                startActivity(intent)
            }
            R.id.navi_contact -> {
                val intent = Intent(this, ContactMe::class.java)
                startActivity(intent)
            }
            R.id.navi_logout -> {
                val intent = Intent(this, login::class.java)
                startActivity(intent)
                finishAffinity()
            }
        }
        return false
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (System.currentTimeMillis() - initTime > BACK_PRESS_INTERVAL) {
            Toast.makeText(this, EXIT_MESSAGE, Toast.LENGTH_SHORT).show()
            initTime = System.currentTimeMillis()
        } else {
            finishAffinity()
        }
    }
}
