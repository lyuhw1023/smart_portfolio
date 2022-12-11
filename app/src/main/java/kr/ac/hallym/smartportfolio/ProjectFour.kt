package kr.ac.hallym.smartportfolio

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kr.ac.hallym.smartportfolio.databinding.ActivityProjectFourBinding

class ProjectFour : AppCompatActivity() {
    lateinit var binding: ActivityProjectFourBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_project_one)
        binding = ActivityProjectFourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.GitHub4.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/lyuhw1023"))
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