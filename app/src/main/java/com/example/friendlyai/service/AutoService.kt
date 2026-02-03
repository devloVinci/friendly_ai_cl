package com.example.friendlyai.service

import android.accessibilityservice.AccessibilityService
import com.example.friendlyai.model.AICommand
import com.example.friendlyai.voice.VoiceSpeaker
import com.example.friendlyai.memory.MemoryManager

class AutoService : AccessibilityService() {

    private lateinit var speaker: VoiceSpeaker

    override fun onServiceConnected() {
        speaker = VoiceSpeaker(this)
    }

    fun execute(cmd: AICommand) {
        when (cmd.action) {
            "speak" -> speaker.speak(cmd.value ?: "")
            "sequence" -> cmd.steps?.forEach { execute(it) }
        }
    }

    override fun onAccessibilityEvent(event: android.view.accessibility.AccessibilityEvent?) {}
    override fun onInterrupt() {}
}
