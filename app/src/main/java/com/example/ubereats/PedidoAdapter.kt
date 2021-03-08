package com.example.ubereats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PedidoAdapter (private val compras: List<Compras>):RecyclerView.Adapter<PedidoAdapter.PedidoViewHolder>(){
    inner class PedidoViewHolder(renglon: View): RecyclerView.ViewHolder(renglon){
        var total  = renglon.findViewById<TextView>(R.id.total)
        var pedido  = renglon.findViewById<TextView>(R.id.numOrden)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PedidoViewHolder {
        val inflater =LayoutInflater.from(parent.context)
        val renglon_layout = inflater.inflate(R.layout.renglon_layout,parent,false)
        return PedidoViewHolder(renglon_layout)
    }

    override fun onBindViewHolder(holder: PedidoViewHolder, position: Int) {
        val dato  = compras[position]
        val total=dato.total
        val pedido = dato.id
        holder.pedido.text = dato.id.toString()
        holder.total.text= dato.total.toString()
    }

    override fun getItemCount(): Int {
        return compras.size
    }
}
