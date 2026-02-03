
package com.example.friendlyai.memory

import android.content.Context

class MemoryManager(context: Context) {

    private val prefs =
        context.getSharedPreferences("sam_memory", Context.MODE_PRIVATE)

    fun saveName(name: String) {
        prefs.edit()
            .putString("user_name", name)
            .putLong("last_interaction", System.currentTimeMillis())
            .apply()
    }

    fun getName(): String? {
        return prefs.getString("user_name", null)
    }

    fun savePreference(key: String, value: String) {
        prefs.edit()
            .putString("pref_$key", value)
            .apply()
    }

    fun getPreference(key: String): String? {
        return prefs.getString("pref_$key", null)
    }

    fun getLastInteraction(): Long {
        return prefs.getLong("last_interaction", 0L)
    }
}
