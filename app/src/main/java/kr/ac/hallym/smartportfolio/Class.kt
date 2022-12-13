package kr.ac.hallym.smartportfolio

import android.content.Intent
import android.os.Build.VERSION_CODES.S
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
//import androidx.navigation.Navigation
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kr.ac.hallym.smartportfolio.databinding.ActivityClassBinding
import kr.ac.hallym.smartportfolio.databinding.ActivityLyuhyewonBinding


class Class : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var binding: ActivityClassBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityClassBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Toolbar 설정
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //tab 메뉴 설정
        val tabLayout = binding.tabs
        val viewPager = binding.viewpager
        val tabTitleArray = arrayOf(
            "수업",
            "성적"
        )

        //좌우로 이동할 수 있도록 viewpager 설정
        viewPager.adapter = ClassFragmentPagerAdapter(this)

        //tab 설정
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()

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

//해당 Fragment로 이동하는 이벤트 설정
class ClassFragmentPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    val fragments: List<Fragment>
    init {
        fragments = listOf(ClassesFragment(), ScoreFragment())
    }

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

}

