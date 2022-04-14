package com.heltonbustos.retrofit3peliculas.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface PeliculaAPIService {
    @POST("bd.json")
    fun agregarPelicula(@Body pelicula: Pelicula): Call<PeliculaRespuestaPost>
}