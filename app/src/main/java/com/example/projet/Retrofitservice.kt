package com.example.projet

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofitservice {

    var gson = GsonBuilder().setLenient().create()
    val endpoint :Endpoint by lazy {
        Retrofit.Builder().baseUrl("https://f7bb12e3.ngrok.io/").
            addConverterFactory(GsonConverterFactory.create(gson)).
            build().create(Endpoint::class.java)
    }

}