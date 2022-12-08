package kr.ac.hallym.smartportfolio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.smartportfolio.databinding.ActivityProjectMainBinding

class ProjectMain : AppCompatActivity() {
    lateinit var binding: ActivityProjectMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_project_main)
        binding = ActivityProjectMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contents1 = mutableListOf<String>("SmartPortfolio", "자리있나요?", "Healing Blog", "위로", "자동뷔페용기")
        val contents2 = mutableListOf<Int>(R.drawable.project1, R.drawable.project2, R.drawable.project3 , R.drawable.project4, R.drawable.project5)
        val contents3 = mutableListOf<String>("안드로이드 스튜디오를 사용해 개발한 스마트 포트폴리오 애플리케이션입니다.\n"+
            "코틀린을 사용해 전체적으로 애플리케이션을 개발하였습니다.",
            "”자리있나요?” 는 한림대학교 공학관 북카페의 좌석을 실시간으로 조회할 수 있는 시스템입니다. " +
                    "저는 이 프로젝트에서 웹 페이지의 Front-End를 맡아 개발하였습니다.",
            "HTML, CSS, JavaScript를 이용해 개발한 웹 블로그입니다. HealingStory, CodingStory, Calendar 등을 포함해 저에게 힐링이 되는 모든것을 기록하였습니다.",
            "”위로”는 정신 건강 관리 웹 서비스 입니다. 워드프레스를 통해 웹사이트를 개발하였습니다.\n" +
                    "저는 이 프로젝트에서 심리검사와 판매페이지를 맡아 개발하였습니다.",
            "아두이노를 활용해 제작한 자동 뷔페 용기입니다. \n사용자가 일정 거리 이상 다가오게 되면 자동으로 뷔페의 용기가 열리도록 제작하였습니다.")

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = ProjectAdapter(contents1, contents2, contents3)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )

    }
}