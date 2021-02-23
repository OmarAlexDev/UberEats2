package com.example.ubereats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val subtotal = 200
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var orderFee = subtotal*0.02
        var serviceFee = subtotal*0.05
        var deliveryFee = subtotal*0.1
        var tip = 0.0
        textViewSubId.text = subtotal.toDouble().toString()
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
    fun calcTotal(orderFee: Double, serviceFee:Double, deliveryFee:Double,tip:Double){
        var total = subtotal + orderFee + serviceFee +deliveryFee + tip
        compraButton.text = "Pagar $" + total.toString()
    }

}