package com.example.smartportfolio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class ProjectWebView4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_web_view4)

        //id webview4를 통해 해당 링크가 뜨는 웹뷰 설정
        var myWebView: WebView = findViewById(R.id.webview4)
        myWebView.webViewClient = WebViewClient()
        myWebView.loadUrl("https://github.com/lyuhw1023/we_with")
    }
}