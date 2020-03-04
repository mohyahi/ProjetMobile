package com.example.projet

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "patient")
data class Patient (
    var NSS : Int,
    var Nom : String,
    var prenom : String,
    var adresse : String,
    @PrimaryKey
    var phone : String,
    var password : String,
    var newpassword: String
    )