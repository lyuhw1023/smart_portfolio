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
        binding = ActivityProjectTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Toolbar 설정
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //goToUrl 버튼 클릭시 해당 액티비티로 이동
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

    //메뉴 설정
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //Toolbar 이벤트 설정
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            //뒤로가기 버튼 클릭 시 home화면으로 이동
            android.R.id.home -> {
                finish()
                return true
            }
            //logout 버튼 클릭 시 Login화면으로 이동
            R.id.menu_logout -> {
                val intent = Intent(this, login::class.java)
                startActivity(intent)
                finishAffinity()
            }

        }
        return super.onOptionsItemSelected(item)
    }
}