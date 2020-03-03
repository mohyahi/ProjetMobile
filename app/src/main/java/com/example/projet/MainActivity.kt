package com.example.projet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inscription_btn.setOnClickListener {

            val intent = Intent(this, InscriptionActivity::class.java)
            startActivity(intent)
        }

        connect_btn.setOnClickListener {

            val intent2 = Intent(this, ConnexionActivity::class.java)
            startActivity(intent2)
        }
        recherche_btn.setOnClickListener {
            val intent3 = Intent(this, RechercheMedecinActivity::class.java)
            startActivity(intent3)
        }
    }
}
