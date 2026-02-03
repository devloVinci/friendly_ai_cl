package com.example.friendlyai.model

data class AICommand(
    val action: String,
    val target: String? = null,
    val value: String? = null,
    val emotion: String? = null,
    val timestamp: Long = System.currentTimeMillis(),
    val steps: List<AICommand>? = null
)
