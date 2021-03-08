package com.example.ubereats

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.Validators.not
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var subtotal = 0.0
    var compras = mutableListOf<Compras>()
    var orderFee = 0.0
    var serviceFee = 0.0
    var deliveryFee = 0.0
    var tip = 0.0
    var id = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init(){
        precioUsuario.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(!TextUtils.isEmpty(precioUsuario.text.toString())){
                    subtotal = precioUsuario.text.toString().toDouble()
                    orderFee = subtotal*0.02
                    serviceFee = subtotal*0.05
                    deliveryFee = subtotal*0.1
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
                        tip = 0.0
                        calcTotal(orderFee,serviceFee,deliveryFee,tip)
                    }
                }
            }
        })
    }

    fun calcTotal(orderFee: Double, serviceFee:Double, deliveryFee:Double,tip:Double): Double {
        var total = subtotal + orderFee + serviceFee + deliveryFee + tip
        compraButon.text = "Pagar $" + total.toString()
        return total
    }
    fun guarda(view: View){
        var total = calcTotal(orderFee,serviceFee,deliveryFee,tip)
        val compra = Compras(id, subtotal, orderFee, serviceFee, deliveryFee, total)
        id += 1
        ordenId.text = "Orden # " + id.toString()
        compras.add(compra)

            val intento = Intent(this, Resultado::class.java)
            intento.putExtra("id",id)
            intento.putExtra("subtotal",subtotal)
            intento.putExtra("orderFee",orderFee)
            intento.putExtra("serviceFee",serviceFee)
            intento.putExtra("deliveryFee",deliveryFee)
            intento.putExtra("total",total)
            startActivity(intento)

        precioUsuario.text.clear()
        OrderFeeId.text = "$0.00"
        ServiceFeeId.text = "$0.00"
        DeliveryFeeId.text = "$0.00"
        compraButon.text = "Pagar"
        subtotal = 0.0
        orderFee = 0.0
        serviceFee = 0.0
        deliveryFee = 0.0
        Log.i("com.example.ubereats.Hola", compras.toString())
    }

}