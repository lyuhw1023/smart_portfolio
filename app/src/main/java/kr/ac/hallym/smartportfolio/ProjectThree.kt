package kr.ac.hallym.smartportfolio

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import kr.ac.hallym.smartportfolio.databinding.ActivityProjectThreeBinding

class ProjectThree : AppCompatActivity() {
    lateinit var binding: ActivityProjectThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_project_one)
        binding = ActivityProjectThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val eventHandler = object: DialogInterface.OnClickListener{
            override fun onClick(p0: DialogInterface?, p1: Int) {
                if(p1 == DialogInterface.BUTTON_POSITIVE){
                    var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/lyuhw1023/healing_blog"))
                    startActivity(intent)
                }else if (p1 == DialogInterface.BUTTON_NEGATIVE){
                    var intent = Intent(this@ProjectThree, ProjectWebView3::class.java)
                    startActivity(intent)
                }
            }
        }

        binding.GitHub3.setOnClickListener{
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