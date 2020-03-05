package com.example.projet

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.list_traitants.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class listTraitantsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_traitants)

        var p = intent.getStringExtra("phonePat")
        val call = Retrofitservice.endpoint.getListeTraitant(p)
        call.enqueue(object: Callback<List<Medecin>> {
            override fun onResponse(call: Call<List<Medecin>>?, response:
            Response<List<Medecin>>?) {
                val adapter = Adapter_traitant(this@listTraitantsActivity, response?.body()!!)
                trait_listview.adapter = adapter



            }
            override fun onFailure(call: Call<List<Medecin>>?, t: Throwable?) {
                Toast.makeText(this@listTraitantsActivity, t!!.message, Toast.LENGTH_SHORT).show()
            }
        })

    }

}