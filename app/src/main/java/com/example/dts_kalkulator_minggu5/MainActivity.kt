package com.example.dts_kalkulator_minggu5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var hasil : TextView

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_kali = findViewById<Button>(R.id.btn_kali)
        var btn_bagi = findViewById<Button>(R.id.btn_bagi)
        var btn_tambah = findViewById<Button>(R.id.btn_tambah)
        var btn_kurang = findViewById<Button>(R.id.btn_kurang)

        hasil = findViewById(R.id.hasil)
        editText1 = findViewById(R.id.input_pertama)
        editText2 = findViewById(R.id.input_kedua)

        btn_kali.setOnClickListener { v ->
            operasi("kali")
        }
        btn_bagi.setOnClickListener { v ->
            operasi("bagi")
        }
        btn_tambah.setOnClickListener { v ->
            operasi("tambah")
        }
        btn_kurang.setOnClickListener { v ->
            operasi("kurang")
        }

        var btn_reset = findViewById<Button>(R.id.btn_reset)
        btn_reset.setOnClickListener { v ->
            editText1.text.clear()
            editText2.text.clear()
            hasil.text = "0"
        }

    }

    private fun operasi(operator : String) {
        if(editText1.text.isEmpty()) {
            editText1.error = "Angka pertama tidak boleh kosong !"
            editText1.isFocused
            return
        }
        else if(editText2.text.isEmpty()){
            editText2.error = "Angka kedua tidak boleh kosong !"
            editText2.isFocused
            return
        }

        var num1 = editText1.text.toString().toInt()
        var num2 = editText2.text.toString().toInt()

        when(operator){
            "kali" -> {
                hasil.text = ( num1 * num2 ).toString()
            }
            "bagi" -> {
                hasil.text = (num1 / num2).toString()
            }
            "tambah" -> {
                hasil.text = (num1 + num2).toString()
            }
            "kurang" -> {
                hasil.text = (num1 - num2).toString()
            }
        }
    }
}