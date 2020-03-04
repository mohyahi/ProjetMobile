package com.example.projet

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.list_medecin.*
import kotlinx.android.synthetic.main.recherche_medecin.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class listMedecinActivity() : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_medecin)
        //val p = commune_txt.text.toString()
        var commune = intent.getStringExtra("commune_new")
        var specialite = intent.getStringExtra("specialite_new")

        val call = Retrofitservice.endpoint.getMedecin(commune,specialite)
        call.enqueue(object: Callback<List<Medecin>> {
            override fun onResponse(call: Call<List<Medecin>>?, response:
            Response<List<Medecin>>?) {
                val adapter = Adapter_medecin(this@listMedecinActivity, response?.body()!!)
                medecin_listview.adapter = adapter
            }
            override fun onFailure(call: Call<List<Medecin>>?, t: Throwable?) {
                Toast.makeText(this@listMedecinActivity, t!!.message, Toast.LENGTH_SHORT).show()
            }
        })


    }
}