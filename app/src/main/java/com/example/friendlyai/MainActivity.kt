
package com.example.friendlyai

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.friendlyai.voice.VoiceListener
import com.example.friendlyai.voice.VoiceSpeaker

class MainActivity : AppCompatActivity() {

    private lateinit var listener: VoiceListener
    private lateinit var speaker: VoiceSpeaker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listener = VoiceListener(this)
        speaker = VoiceSpeaker(this)

        findViewById<android.widget.Button>(R.id.btnTalk).setOnClickListener {
            speaker.speak("أنا سام، أسمعك الآن 🤍")
            listener.startListening()
        }
    }
}
