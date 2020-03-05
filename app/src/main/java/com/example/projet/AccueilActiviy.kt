package com.example.projet

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.accueil.*

class AccueilActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.accueil)
        recherche_btn.setOnClickListener{
            val intent = Intent(this, RechercheMedecinActivity::class.java)
            startActivity(intent)
        }
        ajout_traitant_btn.setOnClickListener {
            val intent2 = Intent(this, AjoutTraitantActivity::class.java)
            startActivity(intent2)
        }
    }
}