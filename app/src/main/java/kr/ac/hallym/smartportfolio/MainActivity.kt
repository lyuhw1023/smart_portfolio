package kr.ac.hallym.smartportfolio

import android.content.Intent
import android.net.Uri
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
        binding = ActivityMainBinding.inflate(layoutInflater)
        //네비게이션 뷰 객체 설정
        binding.mainDrawerView.setNavigationItemSelectedListener(this)
        setContentView(binding.root)
        //Toolbar 설정
        setSupportActionBar(binding.toolbar)
        //Toolbar 좌측 상단에 있는 toggle(햄버거 버튼)
        toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened, R.string.drawer_closed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()
    }
    //toggle 클릭
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    //네비게이션메뉴 선택 시 이벤트
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            //id가 navi_home인 버튼 클릭 시 MainActivity화면으로 이동
            R.id.navi_home-> {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)

            }
            //id가 navi_project인 버튼 클릭 시 ProjectTest화면으로 이동
            R.id.navi_project-> {
                val intent = Intent(this,ProjectTest::class.java)
                startActivity(intent)

            }
            //id가 navi_lyuHyeWon인 버튼 클릭 시 LyuHyeWon화면으로 이동
            R.id.navi_lyuHyeWon-> {
                val intent = Intent(this,LyuHyeWon::class.java)
                startActivity(intent)

            }
            //id가 navi_class인 버튼 클릭 시 Class화면으로 이동
            R.id.navi_class-> {
                val intent = Intent(this,Class::class.java)
                startActivity(intent)

            }
            //id가 navi_github인 버튼 클릭 시 GitHub화면으로 이동
            R.id.navi_github-> {
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/lyuhw1023"))
                startActivity(intent)

            }
            //id가 navi_contact인 버튼 클릭 시 GitHub화면으로 이동
            R.id.navi_contact-> {
                val intent = Intent(this,ContactMe::class.java)
                startActivity(intent)

            }
            //id가 navi_logout인 버튼 클릭 시 login화면으로 이동
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
        //뒤로가기 버튼을 처음 눌렀거나 누른지 3초가 지났을 때 Toast 문구 설정
        if(System.currentTimeMillis() - initTime > 3000){
            Toast.makeText(this, "\t\t정말 종료하시겠습니까? \n종료하려면 한 번 더 누르세요!", Toast.LENGTH_SHORT).show()
            initTime = System.currentTimeMillis()
            return
        }
        //뒤로가기 버튼을 3초 이내로 눌렀을 때 애플맄이션 종료
        if(System.currentTimeMillis() <= initTime + 3000){
            finishAffinity()
        }
    }
}