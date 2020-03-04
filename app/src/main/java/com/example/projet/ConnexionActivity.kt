package com.example.projet

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.connexion.*
import kotlinx.android.synthetic.main.list_medecin.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.*
import java.lang.NullPointerException

class ConnexionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.connexion)

        connexion_btn.setOnClickListener {
            if (num_tel_txt.text.toString().isEmpty() || password_txt.text.toString().isEmpty()) {
                Toast.makeText(this, "Veuiller remplir les deux champs !", Toast.LENGTH_SHORT)
                    .show()
            } else {
                getPatientPhone(num_tel_txt.text.toString(), password_txt.text.toString())
            }
        }
    }

    fun   getPatientPhone(tlfn:String, pwd : String) {
        val intent = Intent(this, ConfirmPasswordActivity::class.java)
        val call = Retrofitservice.endpoint.getPatientPhone(tlfn,pwd)
        call.enqueue(object : Callback<List<Patient>> {
            override fun onResponse(
                call: Call<List<Patient>>?, response:
                Response<List<Patient>>?
            ) {
                if(response?.body().isNullOrEmpty()){
                    Toast.makeText(this@ConnexionActivity, "Veuillez verifier vos information", Toast.LENGTH_SHORT).show()

                }
                else {
                    if (response?.body()!![0].newpassword=="0"){
                        var phonePat = response?.body()!![0].phone
                        intent.putExtra("phonePat",phonePat)
                    startActivity(intent)}
                    else {
                        Toast.makeText(this@ConnexionActivity, "Accueil", Toast.LENGTH_SHORT).show()
                        //On met l'interface du patient
                    }
                }

            }

            override fun onFailure(call: Call<List<Patient>>?, t: Throwable?) {
                Toast.makeText(this@ConnexionActivity, "Veuillez verifier vos information", Toast.LENGTH_SHORT).show()
            }
        })

        }

}

/*
 var v: Int = 0
            call.enqueue(object : Callback<List<Patient>> {
                override fun onResponse(
                    call: Call<List<Patient>>?, response:
                    Response<List<Patient>>?
                ) {
                    if (response?.body()!![0].newpassword == "0") {
                        v = 0
                    } else {
                        v = 1
                    }

                }

                override fun onFailure(call: Call<List<Patient>>?, t: Throwable?) {
                    Log.e("error retrofit", t.toString())
                    Toast.makeText(this@ConnexionActivity, t.toString(), Toast.LENGTH_SHORT).show()
                }
            })
 */