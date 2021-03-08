package com.example.ubereats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_resultado.*
import kotlin.random.Random


class Resultado : AppCompatActivity() {
    private lateinit var pedidoAdapter: PedidoAdapter
    var compras = mutableListOf<Compras>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        initRecycler()
    }
    fun initRecycler(){
        pedidoAdapter = PedidoAdapter(compras)
        recycler.layoutManager= LinearLayoutManager(this)
        recycler.adapter = pedidoAdapter
        for(i in 0..20){
            val total = String.format("%.2f", Random.nextDouble()*1000).toDouble()
            val compra = Compras(i+1,0.0,0.0,0.0,0.0, total)
            compras.add(compra)
        }


    }
}