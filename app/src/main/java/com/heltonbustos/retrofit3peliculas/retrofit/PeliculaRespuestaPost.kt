package com.heltonbustos.retrofit3peliculas.retrofit

import com.google.gson.annotations.SerializedName

class PeliculaRespuestaPost(
    @SerializedName("name")
    val name: String
)