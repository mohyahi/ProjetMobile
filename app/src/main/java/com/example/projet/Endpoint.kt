package com.example.projet

import retrofit2.Call
import retrofit2.http.Body

import retrofit2.http.POST
import java.util.*


interface Endpoint {

@POST("addPatient")
fun addPatient(@Body patient: Patient): Call<String>
}