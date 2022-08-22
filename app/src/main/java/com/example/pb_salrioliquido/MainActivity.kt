package com.example.pb_salrioliquido

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener {
            var salary = editSalario.text.toString()
            var dependentes: String? = editDependents?.text.toString()
            var pensao: String? = editPensao?.text.toString()
            var planoSaude: String? = editHealth?.text.toString()
            var descontos: String? = editDiscounts?.text.toString()

            if(salary.isNullOrEmpty()){
                Toast.makeText(this, "O campo de salário é obrigatório", Toast.LENGTH_SHORT).show()
            } else{

            val result = Calculo().calculateTotalSalary(
                salary.toFloat(),
                Calculo().checkNullOrEmpty(dependentes).toInt(),
                Calculo().checkNullOrEmpty(pensao).toInt().toFloat(),
            )
            val totalDiscount = Calculo().totalDiscount(
                Calculo().checkNullOrEmpty(pensao).toFloat(),
                Calculo().checkNullOrEmpty(planoSaude).toFloat(),
                Calculo().checkNullOrEmpty(descontos).toFloat())

            val percentageDiscount = Calculo().percentageDiscount(
                salary.toFloat(),
                Calculo().checkNullOrEmpty(pensao).toFloat(),
                Calculo().checkNullOrEmpty(planoSaude).toFloat(),
                Calculo().checkNullOrEmpty(descontos).toFloat())

            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            intent.putExtra("result", result.toString())
            intent.putExtra("disconts", totalDiscount.toString())
            intent.putExtra("percentage", percentageDiscount.toString())
            intent.putExtra("dependents", Calculo().checkNullOrEmpty(dependentes))
            intent.putExtra("pensao", Calculo().checkNullOrEmpty(pensao))
            intent.putExtra("planoSaude", Calculo().checkNullOrEmpty(planoSaude))
            intent.putExtra("descontos", Calculo().checkNullOrEmpty(descontos))



                startActivity(intent)
            }
        }
    }



}