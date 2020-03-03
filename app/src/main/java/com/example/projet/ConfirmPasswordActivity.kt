package com.example.projet

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.confirm_password.*

class ConfirmPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirm_password)

        valider_btn.setOnClickListener {
            if (password_txt.text.toString().isEmpty() || confirmPassword_txt.text.toString().isEmpty()){
                Toast.makeText(this, "Veuiller remplir les deux champs !", Toast.LENGTH_SHORT).show()
            }
            else{
                if (password_txt.text.toString() == confirmPassword_txt.text.toString()) {
                    Toast.makeText(this, "Mot de passe enregistré", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Erreur dans la confirmation du mot de passe", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}