package lv.zabarovski.m.rtu_sample2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_chat_main.*
import kotlinx.android.synthetic.main.activity_chat_reply.*
import lv.zabarovski.m.rtu_sample2.chatMainActivity.Companion.EXTRA_REPLY
import lv.zabarovski.m.rtu_sample2.chatMainActivity.Companion.SEND_MESSAGE

class chatReplyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_reply)
        val message = intent.getStringExtra(SEND_MESSAGE)
        chatReplyReceivedMessage.text = message
        chatButtonReply.setOnClickListener {
            val replyMessage = chatReplyInput.text.toString()
            val result = Intent().apply {
                putExtra(EXTRA_REPLY, replyMessage)
            }
            setResult(Activity.RESULT_OK, result)
            finish()
        }
    }
}