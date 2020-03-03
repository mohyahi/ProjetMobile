package com.example.projet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.list_medecin.*

class listMedecinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_medecin)
        val medecins = mutableListOf<Medecin>()
        medecins.add(Medecin("Zaknoune","Kamel","Neurologie","Bordj-El-Bahri","8h","17h","0542 14 92 69"))
        medecins.add(Medecin("Boussa","Lotfi","Neurologie","Rouiba","10h","17h","0798 25 14 89"))
        medecins.add(Medecin("Yahi","Moh","Neurologie","Oued-Smar","12h","20h","0551 23 51 41"))
        medecins.add(Medecin("Namani","Adel","Neurologie","Lmerdja","6h","16h","0668 41 97 81"))

        val Adapter = Adapter_medecin(this,medecins)
        medecin_listview.adapter = Adapter


    }
}