package kr.ac.hallym.smartportfolio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
import kr.ac.hallym.smartportfolio.databinding.ActivityMainBinding
import kr.ac.hallym.smartportfolio.databinding.MainTextBinding


class MainActivity : AppCompatActivity(), OnNavigationItemSelectedListener {
    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle
    var initTime= 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //네비게이션 뷰 객체 설정
        binding.mainDrawerView.setNavigationItemSelectedListener(this)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened, R.string.drawer_closed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()
        /*binding.mainDrawerView.setNavigationItemSelectedListener {
            Log.d("lyu", "navigation item is clicked: ${it.title}")
            true
        }*/
        binding.lyu.setOnClickListener{
            val intent: Intent = Intent(this, LyuHyeWon::class.java)
            startActivity(intent)
        }
        binding.project.setOnClickListener{
            val intent: Intent = Intent(this, ProjectMain::class.java)
            startActivity(intent)
        }
        binding.projectTest.setOnClickListener{
            val intent: Intent = Intent(this, ProjectTest::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.navi_home-> {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)

            }
            R.id.navi_project-> {
                val intent = Intent(this,ProjectMain::class.java)
                startActivity(intent)

            }
            R.id.navi_lyuHyeWon-> {
                val intent = Intent(this,LyuHyeWon::class.java)
                startActivity(intent)

            }
            R.id.navi_setting-> Toast.makeText(this,"setting clicked",Toast.LENGTH_SHORT).show()
            R.id.navi_logout-> {
                val intent = Intent(this,login::class.java)
                startActivity(intent)
                finishAffinity()

            }
        }
        return false

    }
    //뒤로가기 버튼 이벤트 핸들러
    override fun onBackPressed() {
        //뒤로가기 버튼을 처음 눌렀거나 누른지 3초가 지났을 때
        if(System.currentTimeMillis() - initTime > 3000){
            Toast.makeText(this, "\t\t정말 종료하시겠습니까? \n종료하려면 한 번 더 누르세요!", Toast.LENGTH_SHORT).show()
            initTime = System.currentTimeMillis()
            return
        }
        if(System.currentTimeMillis() <= initTime + 3000){
            finishAffinity()
        }
    }
}