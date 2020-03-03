package com.example.projet

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.insciption.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class InscriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.insciption)
        inscrire_btn.setOnClickListener{

            if (num_sec_sociale_txt.text.toString().isEmpty() || nom_txt.text.toString().isEmpty()
                || prenom_txt.text.toString().isEmpty() || adresse_txt.text.toString().isEmpty()
                || tel_txt.text.toString().isEmpty()
            )
            {

                Toast.makeText(this, "Veuillez remplir tous les champs !", Toast.LENGTH_SHORT).show()
            }
            else{

                val nss = findViewById<EditText>(R.id.num_sec_sociale_txt).text.toString().toInt()
                val nom = findViewById<EditText>(R.id.nom_txt).text.toString()
                var prenom = findViewById<EditText>(R.id.prenom_txt).text.toString()
                var adresse = findViewById<EditText>(R.id.adresse_txt).text.toString()
                var phone = findViewById<EditText>(R.id.tel_txt).text.toString().toInt()






                val pat = Patient(nss,nom,prenom,adresse,phone,"AAA","AA")


                addpatient(Patient(nss,nom,prenom,adresse,phone,"AAA","AA"))
            }
        }

    }
    fun addpatient(p:Patient){
        val call = Retrofitservice.endpoint.addPatient(p)
        call.enqueue(object : Callback <String>{
            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                if(response?.isSuccessful!!){
                    val list = response?.body()!!

                        Toast.makeText(this@InscriptionActivity,p.Nom,Toast.LENGTH_SHORT).show()

                }
                else {
                    Toast.makeText(this@InscriptionActivity,"Erreur Client",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                Log.e("error retrofit",t.toString())
                Toast.makeText(this@InscriptionActivity,"Erreur Serveur",Toast.LENGTH_SHORT).show()

            }
        })


    }
}