package com.example.ubereats

data class Compras(var id: Int, var subtotal: Double, var forder: Double, var fservice: Double, var fdelivery: Double, var total: Double){
    override fun toString(): String = "$id : $total"
}