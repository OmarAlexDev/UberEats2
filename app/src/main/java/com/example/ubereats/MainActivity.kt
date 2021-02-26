package com.example.ubereats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var subtotal = 200.0
    var compras = mutableListOf<Compras>()
    var orderFee = 0.0
    var serviceFee = 0.0
    var deliveryFee = 0.0
    var tip = 0.0
    var id = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //subtotal = precioUsuario.text.toString().toDouble()
        orderFee = subtotal*0.02
        serviceFee = subtotal*0.05
        deliveryFee = subtotal*0.1
        textView10Id.text = "$" + (subtotal*0.1).toDouble().toString()
        textView15Id.text = "$" + (subtotal*0.15).toDouble().toString()
        textView20Id.text = "$" + (subtotal*0.2).toDouble().toString()
        textView25Id.text = "$" + (subtotal*0.25).toDouble().toString()
        OrderFeeId.text = "$" + orderFee.toDouble().toString()
        ServiceFeeId.text = "$" + serviceFee.toDouble().toString()
        DeliveryFeeId.text = "$" + deliveryFee.toDouble().toString()
        calcTotal(orderFee,serviceFee,deliveryFee,tip)

        button10Id.setOnClickListener(){
            tip = subtotal*0.1
            calcTotal(orderFee,serviceFee,deliveryFee,tip)
        }
        button15Id.setOnClickListener(){
            tip = subtotal*0.15
            calcTotal(orderFee,serviceFee,deliveryFee,tip)
        }
        button20Id.setOnClickListener(){
            tip = subtotal*0.2
            calcTotal(orderFee,serviceFee,deliveryFee,tip)
        }
        button25Id.setOnClickListener(){
            tip = subtotal*0.25
            calcTotal(orderFee,serviceFee,deliveryFee,tip)
        }
        button0Id.setOnClickListener(){
            tip = subtotal*0.0
            calcTotal(orderFee,serviceFee,deliveryFee,tip)
        }

    }
    fun calcTotal(orderFee: Double, serviceFee:Double, deliveryFee:Double,tip:Double): Double {
        var total = subtotal + orderFee + serviceFee +deliveryFee + tip
        compraButon.text = "Pagar $" + total.toString()
        return total
    }

    fun guarda(view: View){
        compraButon.setOnClickListener(){
            id += 1
            ordenId.text = "Orden # " + id.toString()
        }
        var total = calcTotal(orderFee,serviceFee,deliveryFee,tip)
        val compra = Compras(id, subtotal, orderFee, serviceFee, deliveryFee, total)
        compras.add(compra)
        Log.i("com.example.ubereats.Hola", compras.toString())
    }

}