package com.example.smartportfolio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
//import androidx.navigation.Navigation
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.example.smartportfolio.databinding.ActivityLyuHyeWonBinding


class LyuHyeWon : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var binding: ActivityLyuHyeWonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLyuHyeWonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Toolbar 설정
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //tab 메뉴 설정
        val tabLayout = binding.tabs
        val viewPager = binding.viewpager
        val tabTitleArray = arrayOf(
            "소개",
            "학교활동"
        )

        //좌우로 이동할 수 있도록 viewpager 설정
        viewPager.adapter = MyFragmentPagerAdapter(this)

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
class MyFragmentPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    val fragments: List<Fragment>
    init {
        fragments = listOf(IntroFragment(), ActiveFragment())
    }

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

}