package com.example.smartportfolio

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import com.example.smartportfolio.databinding.ActivityProjectFourBinding

class ProjectFour : AppCompatActivity() {
    lateinit var binding: ActivityProjectFourBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectFourBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Toolbar 설정
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //버튼 눌렀을 때 발생하는 이벤트 핸들러 설정
        val eventHandler = object: DialogInterface.OnClickListener{
            override fun onClick(p0: DialogInterface?, p1: Int) {
                if(p1 == DialogInterface.BUTTON_POSITIVE){
                    var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/lyuhw1023/we_with"))
                    startActivity(intent)
                }else if (p1 == DialogInterface.BUTTON_NEGATIVE){
                    var intent = Intent(this@ProjectFour, ProjectWebView4::class.java)
                    startActivity(intent)
                }
            }
        }

        //GitHub버튼 눌렀을 때 발생하는 이벤트
        binding.GitHub4.setOnClickListener{
            AlertDialog.Builder(this).run {
                setTitle("GITHUB 보러가기")
                setIcon(android.R.drawable.ic_dialog_info)
                setMessage("어떤 브라우저로 연결할까요?")
                setPositiveButton("Chrome", eventHandler)
                setNegativeButton("내부 브라우저", eventHandler)
                show()
            }
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