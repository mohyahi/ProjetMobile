package com.example.projet

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.confirm_password.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConfirmPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val phoneP = intent.getStringExtra("phonePat")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirm_password)



        valider_btn.setOnClickListener {


            if (password_txt.text.toString().isEmpty() || confirmPassword_txt.text.toString().isEmpty()){
                Toast.makeText(this, "Veuiller remplir les deux champs !", Toast.LENGTH_SHORT).show()
            }
            else{
                if (password_txt.text.toString() == confirmPassword_txt.text.toString()) {
                    setPwd(phoneP,password_txt.text.toString())


                } else {
                    Toast.makeText(this, "Erreur dans la confirmation du mot de passe", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
    fun setPwd(iis :String,i:String){
        val call = Retrofitservice.endpoint.setPwd(iis,i)
        val phoneP = intent.getStringExtra("phonePat")
        val intent2 = Intent(this@ConfirmPasswordActivity, AccueilActivity::class.java)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                Toast.makeText(this@ConfirmPasswordActivity,"Mot de passe modifié",Toast.LENGTH_SHORT).show()
                intent2.putExtra("phonePat",phoneP)
                startActivity(intent2)

            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                Log.e("error retrofit",t.toString())
                Toast.makeText(this@ConfirmPasswordActivity,"Erreur Serveur",Toast.LENGTH_SHORT).show()

            }
        })
    }
}