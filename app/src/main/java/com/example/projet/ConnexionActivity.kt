package com.example.projet

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.connexion.*

class ConnexionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.connexion)

        connexion_btn.setOnClickListener {
            if(num_tel_txt.text.toString().isEmpty() || password_txt.text.toString().isEmpty())
            {
                Toast.makeText(this, "Veuiller remplir les deux champs !", Toast.LENGTH_SHORT).show()
            }
        }
    }
}