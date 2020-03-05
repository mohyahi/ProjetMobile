package com.example.projet

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.accueil.*

class AccueilActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.accueil)
        val p = intent.getStringExtra("phonePat")
        recherche_btn.setOnClickListener{
            val intent = Intent(this@AccueilActivity, RechercheMedecinActivity::class.java)
            startActivity(intent)
        }
        ajout_traitant_btn.setOnClickListener {

            val intent2 = Intent(this@AccueilActivity, AjoutTraitantActivity::class.java)
            intent2.putExtra("phonePat",p)
            startActivity(intent2)
        }
        affich_trait_btn.setOnClickListener {
            val intent3 = Intent(this@AccueilActivity, listTraitantsActivity::class.java)
            intent3.putExtra("phonePat",p)
            startActivity(intent3)
        }
    }
}