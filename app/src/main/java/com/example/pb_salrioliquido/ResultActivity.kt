package com.example.pb_salrioliquido

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*
import java.io.*
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        txtTotalSalary.text = intent.getStringExtra("result").toString()
        txtTotalDiscounts.text = intent.getStringExtra("disconts").toString()
        txtDiscountPorcent.text = "${intent.getStringExtra("percentage").toString()}%"
        val sdf = SimpleDateFormat("dd/M/yyyy")
        val sdh = SimpleDateFormat("hh:mm")
        val currentHour = sdh.format(Date())
        val currentDate = sdf.format(Date())

        btnSalvar.setOnClickListener {
            val fileOutputStream:FileOutputStream
            try {
                fileOutputStream = openFileOutput("resultados.txt", Context.MODE_PRIVATE)

                fileOutputStream.write((
                        "$currentDate \n" +
                        "$currentHour \n"  +
                        "${intent.getStringExtra("dependents").toString()} \n" +
                        "${intent.getStringExtra("pensao").toString()} \n" +
                        "${intent.getStringExtra("planoSaude").toString()} \n" +
                        "${intent.getStringExtra("descontos").toString()} \n" +
                        "${intent.getStringExtra("result").toString()} \n" +
                        "${intent.getStringExtra("disconts").toString()} \n" +
                        "${intent.getStringExtra("percentage").toString()} \n"


                        ).toByteArray())
            } catch (e: FileNotFoundException){
                e.printStackTrace()
            }catch (e: NumberFormatException){
                e.printStackTrace()
            }catch (e: IOException){
                e.printStackTrace()
            }catch (e: Exception){
                e.printStackTrace()
            }
            Toast.makeText(applicationContext,"Arquivo salvo",Toast.LENGTH_LONG).show()
        }

        btnApagar.setOnClickListener {
            try {
                deleteFile("resultados.txt")
            }catch (e: Exception){
                e.printStackTrace()
            }
            Toast.makeText(applicationContext,"Arquivo deletado",Toast.LENGTH_LONG).show()

        }

    }
}