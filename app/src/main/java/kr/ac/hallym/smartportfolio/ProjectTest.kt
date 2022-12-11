package kr.ac.hallym.smartportfolio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kr.ac.hallym.smartportfolio.databinding.ActivityProjectTestBinding

class ProjectTest : AppCompatActivity() {
    lateinit var binding: ActivityProjectTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_project_main)
        binding = ActivityProjectTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.goToUrl1.setOnClickListener{
            val intent: Intent = Intent(this, ProjectOne::class.java)
            startActivity(intent)
        }
        binding.goToUrl2.setOnClickListener{
            val intent: Intent = Intent(this, ProjectTwo::class.java)
            startActivity(intent)
        }
        binding.goToUrl3.setOnClickListener{
            val intent: Intent = Intent(this, ProjectThree::class.java)
            startActivity(intent)
        }
        binding.goToUrl4.setOnClickListener{
            val intent: Intent = Intent(this, ProjectFour::class.java)
            startActivity(intent)
        }
        binding.goToUrl5.setOnClickListener{
            val intent: Intent = Intent(this, ProjectFive::class.java)
            startActivity(intent)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            R.id.menu_logout -> {
                val intent = Intent(this, login::class.java)
                startActivity(intent)
                finishAffinity()
            }

        }
        return super.onOptionsItemSelected(item)
    }
}