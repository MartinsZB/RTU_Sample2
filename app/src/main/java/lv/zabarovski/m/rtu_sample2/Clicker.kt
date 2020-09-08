package lv.zabarovski.m.rtu_sample2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_clicker.*
import kotlinx.android.synthetic.main.activity_main.*

class Clicker : AppCompatActivity() {
    companion object{
        const val CLICKS_EXTRA = "lv.zabarovski.m.rtu_sample2.CLICKS_EXTRA"
    }
    private var clicks = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clicker)
        //clicks = savedInstanceState?.getInt(CLICKS_EXTRA) ?: 0
        clicks = getPreferences(Context.MODE_PRIVATE)
            .getInt(CLICKS_EXTRA,0)
        clickerClickText.text = "$clicks"
        clickerButtonCounter.setOnClickListener {
            //Toast.makeText(this, "Added one click", Toast.LENGTH_LONG).show()
            clicks = clicks + 1
            getPreferences(Context.MODE_PRIVATE)
                .edit()
                .putInt(CLICKS_EXTRA, clicks)
                .apply()

            clickerClickText.text = "$clicks"
        }
        clickerButtonExit.setOnClickListener { finish() }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(CLICKS_EXTRA, clicks)
    }
}