package com.example.friendlyai.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

// 🔑 ضع مفتاحك هنا
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= "sk-or-v1-ضع_مفتاحك_هنا"

interface OpenRouterService {

    @POST("chat/completions")
    suspend fun chat(
        @Header("Authorization") auth: String,
        @Body body: ChatRequest
    ): ChatResponse

    companion object {

        fun create(): OpenRouterService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://openrouter.ai/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(OpenRouterService::class.java)
        }

        // ✅ دالة جاهزة ترسل الطلب بالمفتاح مباشرة
        suspend fun sendChat(body: ChatRequest): ChatResponse {
            val service = create()
            return service.chat(
                auth = "Bearer $API_KEY",
                body = body
            )
        }
    }
}
