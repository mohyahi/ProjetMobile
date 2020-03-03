package com.example.projet

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.recherche_medecin.*

class RechercheMedecinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recherche_medecin)

        rechercher_medecin_btn.setOnClickListener {
            if (specialite_txt.text.toString().isEmpty() || commune_txt.text.toString().isEmpty())
            {
                Toast.makeText(this, "Veuiller remplir les deux champs !", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, listMedecinActivity::class.java)
                startActivity(intent)
            }
        }
    }
}