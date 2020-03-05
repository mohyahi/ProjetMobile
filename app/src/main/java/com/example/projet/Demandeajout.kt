package com.example.projet

import androidx.room.Entity

@Entity(tableName = "demandeajout")
data class Demandeajout (
    val date : String,
    val id : Int,
    val medecin : String,
    val patient : String,
    val status : String
)