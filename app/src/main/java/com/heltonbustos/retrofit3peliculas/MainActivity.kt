package com.heltonbustos.retrofit3peliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.heltonbustos.retrofit3peliculas.databinding.ActivityMainBinding
import com.heltonbustos.retrofit3peliculas.retrofit.Pelicula
import com.heltonbustos.retrofit3peliculas.retrofit.PeliculaAPIService
import com.heltonbustos.retrofit3peliculas.retrofit.PeliculaRespuestaPost
import com.heltonbustos.retrofit3peliculas.retrofit.RestEngine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGuardar.setOnClickListener {
            if( binding.txtAvaluo.text.toString() == "" ||
                binding.txtFechaLanzamiento.text.toString() == "" ||
                binding.txtLugarEstreno.text.toString() == "" ||
                binding.txtNombre.text.toString() == ""){
                Toast.makeText(applicationContext,"Complete todos los campos",
                    Toast.LENGTH_SHORT).show()
            }
            else{
                binding.progressBar.visibility = View.VISIBLE
                var pelicula = Pelicula(
                    binding.txtAvaluo.text.toString(),
                    binding.txtFechaLanzamiento.text.toString(),
                    binding.txtLugarEstreno.text.toString(),
                    binding.txtNombre.text.toString()
                )
                guardarPelicula(pelicula)
            }

        }
    }

    private fun guardarPelicula(pelicula: Pelicula) {
        CoroutineScope(Dispatchers.IO).launch {
            val llamada: PeliculaAPIService =
                RestEngine.getRestEngine().create(PeliculaAPIService::class.java)
            val resultado: Call<PeliculaRespuestaPost> = llamada.agregarPelicula(pelicula)
            val p:PeliculaRespuestaPost? = resultado.execute().body()

            if (p != null){
                runOnUiThread {
                    binding.txtId.text = "Id agregado: ${p.name}"
                    binding.progressBar.visibility = View.GONE
                }
            }
        }
    }
}