package lv.zabarovski.m.rtu_sample2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_chat_main.*

class chatMainActivity : AppCompatActivity() {
    companion object {
        const val SEND_MESSAGE = "lv.zabarovski.m.rtu_sample2.MESSAGE"
        const val DETAIL_REQUEST = 1000
        const val EXTRA_REPLY = "lv.zabarovski.m.rtu_sample2.REPLY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_main)
        chatButtonSend.setOnClickListener {
            val message = chatMainInput.text.toString()
            val reply = Intent(this, chatReplyActivity::class.java).apply {
                putExtra(SEND_MESSAGE, message)
            }
            startActivityForResult(reply, 1000)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000 && resultCode == Activity.RESULT_OK) {
            data?.let {
                val replyMessage = data.getStringExtra(EXTRA_REPLY)
                chatMainTextLabel.text = getString(R.string.receivedMessageLabel)
                chatMainReplay.text = replyMessage

            }
        }
    }
}