package com.example.projet

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.ajout_medecin_trait.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class AjoutTraitantActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ajout_medecin_trait)
        ajouter_trait_btn.setOnClickListener {
            if (phone_trait_txt.text.toString().isEmpty()){
                Toast.makeText(this, "Veuillez remplir le champ !", Toast.LENGTH_SHORT).show()
            }
            else{
                val phoneP = intent.getStringExtra("phonePat")
                val date: String = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
                val medecin = findViewById<EditText>(R.id.phone_trait_txt).text.toString()
                val status = "pending"
                val demande = Demandeajout(date,1,medecin,phoneP,status)
                addTrait(demande)
                //Toast.makeText(this, "Votre demande a été enregisté! " +
                       // "Vous devez attendre la réponse du médecin", Toast.LENGTH_SHORT).show()

            }

        }

    }

    fun addTrait(d:Demandeajout){
        val call = Retrofitservice.endpoint.addTrait(d)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                if(response?.isSuccessful!!){
                    val list = response?.body()!!

                    Toast.makeText(this@AjoutTraitantActivity,"Votre demande a été enregisté, " +
                            "Veuillez attendre l'acceptation du medecin",Toast.LENGTH_SHORT).show()


                }
                else {
                    Toast.makeText(this@AjoutTraitantActivity,"Erreur Client",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                Log.e("error retrofit",t.toString())
                Toast.makeText(this@AjoutTraitantActivity,"Erreur Serveur",Toast.LENGTH_SHORT).show()

            }
        })


    }
}