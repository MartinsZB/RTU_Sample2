package lv.zabarovski.m.rtu_sample2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainButtonClicker.setOnClickListener {
            val clickerStart = Intent(this, Clicker::class.java)
            startActivity(clickerStart)
        }
        mainButtonChat.setOnClickListener {
            val chatStart = Intent(this,chatMainActivity::class.java)
            startActivity(chatStart)
        }
    }
}