package com.heltonbustos.retrofit3peliculas.retrofit

import com.google.gson.annotations.SerializedName

data class Pelicula(
    @SerializedName("avaluo")
    val avaluo: String,
    @SerializedName("fechalanzamiento")
    val fechalanzamiento: String,
    @SerializedName("lugarestreno")
    val lugarestreno: String,
    @SerializedName("nombre")
    val nombre: String
)