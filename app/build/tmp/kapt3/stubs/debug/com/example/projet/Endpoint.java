package com.example.projet;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\b\u001a\u00020\tH\'J(\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00032\b\b\u0001\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\u0004H\'J(\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b0\u00032\b\b\u0001\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\u0004H\'J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\u0004H\'\u00a8\u0006\u0012"}, d2 = {"Lcom/example/projet/Endpoint;", "", "addPatient", "Lretrofit2/Call;", "", "patient", "Lcom/example/projet/Patient;", "addTrait", "demande", "Lcom/example/projet/Demandeajout;", "getMedecin", "", "Lcom/example/projet/Medecin;", "isbn", "isn", "getPatientPhone", "sendSMS", "setPwd", "app_debug"})
public abstract interface Endpoint {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "addPatient")
    public abstract retrofit2.Call<java.lang.String> addPatient(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.projet.Patient patient);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "getMedecin/{commune}/{specialite}")
    public abstract retrofit2.Call<java.util.List<com.example.projet.Medecin>> getMedecin(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "commune")
    java.lang.String isbn, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "specialite")
    java.lang.String isn);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "getPatientPhone/{phone}/{password}")
    public abstract retrofit2.Call<java.util.List<com.example.projet.Patient>> getPatientPhone(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "phone")
    java.lang.String isbn, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "password")
    java.lang.String isn);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "setPwd/{phone}/{password}")
    public abstract retrofit2.Call<java.lang.String> setPwd(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "phone")
    java.lang.String isbn, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "password")
    java.lang.String isn);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "sendSMS")
    public abstract retrofit2.Call<java.lang.String> sendSMS(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.projet.Patient patient);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "addTrait")
    public abstract retrofit2.Call<java.lang.String> addTrait(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.projet.Demandeajout demande);
}