package com.example.projet

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

import retrofit2.http.POST
import retrofit2.http.Path



interface Endpoint {

@POST("addPatient")
fun addPatient(@Body patient: Patient): Call<String>

@GET("getMedecin/{commune}/{specialite}")
fun getMedecin(@Path ("commune") isbn:String,@Path("specialite") isn: String): Call<List<Medecin>>

@GET("getPatientPhone/{phone}/{password}")
fun getPatientPhone(@Path ("phone") isbn: String, @Path("password") isn:String) : Call<List<Patient>>

@POST("setPwd/{phone}/{password}")
fun setPwd(@Path("phone") isbn: String,@Path("password") isn:String):Call<String>

@POST("sendSMS")
fun sendSMS(@Body patient: Patient) : Call<String>

    @POST("addTrait")
    fun addTrait(@Body demande: Demandeajout): Call<String>
}