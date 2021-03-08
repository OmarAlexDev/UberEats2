package com.example.ubereats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_resultado.*
import kotlin.random.Random

class Resultado : AppCompatActivity() {
    private lateinit var pedidoAdapter: PedidoAdapter
    private lateinit var compras: ArrayList<Compras>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        initRecycler()
    }
    fun initRecycler(){
        compras=ArrayList<Compras>()
        pedidoAdapter = PedidoAdapter(compras)
        recycler.layoutManager= LinearLayoutManager(this)
        recycler.adapter = pedidoAdapter
        for(i in 0..5){
            val total = String.format("%.2f", Random.nextDouble()*100).toDouble()
            //val id = String.format("%.2f", Random.nextInt()).toInt()
            val compra = Compras(0,0.0,0.0,0.0,0.0,total)
            compras.add(compra)
        }

    }
}