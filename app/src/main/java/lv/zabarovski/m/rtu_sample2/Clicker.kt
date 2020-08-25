package lv.zabarovski.m.rtu_sample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_clicker.*
import kotlinx.android.synthetic.main.activity_main.*

class Clicker : AppCompatActivity() {
    private var clicks = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clicker)
        clickerClickText.text = "$clicks"
        clickerButtonCounter.setOnClickListener {
            Toast.makeText(this, "Added one click", Toast.LENGTH_LONG).show()
            clicks = clicks + 1
            clickerClickText.text = "$clicks"
        }
        clickerButtonExit.setOnClickListener { finish() }
    }
}