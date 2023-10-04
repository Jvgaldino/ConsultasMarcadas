package com.example.consultasmarcadas.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.consultasmarcadas.R
import com.example.consultasmarcadas.adapter.ServicosAdapter
import com.example.consultasmarcadas.databinding.ActivityHomeBinding
import com.example.consultasmarcadas.model.Servicos

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var servicosAdapter: ServicosAdapter
    private val listaServicos: MutableList<Servicos> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val nome = intent.extras?.getString("nome")

        binding.txtNomeUsuario.text = "Bem Vindos(a),$nome"
        val recyclerViewServicos = binding.recyclerViewServicos
        recyclerViewServicos.layoutManager = GridLayoutManager(this,2)
        servicosAdapter = ServicosAdapter(this,listaServicos)
        recyclerViewServicos.setHasFixedSize(true)
        recyclerViewServicos.adapter = servicosAdapter
        getServicos()

        binding.btAgendar.setOnClickListener{
            val intent = Intent()
        }


    }

    private fun getServicos(){
        val Servico1 = Servicos(R.drawable.iconeclinicogeral,"Pedriatra")
        listaServicos.add(Servico1)

        val Servico2 = Servicos(R.drawable.iconedentista,"Dentista")
        listaServicos.add(Servico2)

        val Servico3 = Servicos(R.drawable.iconemedicos,"Clinico Geral")
        listaServicos.add(Servico3)

        val Servico4 = Servicos(R.drawable.iconeclinicogeral,"Ortopédia")
        listaServicos.add(Servico4)
    }
}