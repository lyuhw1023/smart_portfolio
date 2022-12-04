package kr.ac.hallym.smartportfolio

import android.os.Build.VERSION_CODES.S
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kr.ac.hallym.smartportfolio.databinding.ActivityLyuhyewonBinding

class Lyuhyewon : AppCompatActivity() {
    lateinit var binding: ActivityLyuhyewonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_lyuhyewon)
        val binding = ActivityLyuhyewonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabLayout = binding.tabs
        val viewPager = binding.viewpager
        val tabTitleArray = arrayOf(
            "소개",
            "학교성적",
            "학교활동"
        )

        viewPager.adapter = MyFragmentPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()
    }
}

class MyFragmentPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity){
    val fragments: List<Fragment>
    init {
        fragments = listOf(IntroFragment(), ScoreFragment(), SchoolFragment())
    }

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

}