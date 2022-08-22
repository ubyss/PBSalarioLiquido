package com.example.pb_salrioliquido

class Calculo(){
    fun calculateInss(salarioBruto: Float): Float{
        var inssDiscount: Float = when {
            salarioBruto <= 1659.38 -> {
                (salarioBruto * 0.08).toFloat()
            }
            salarioBruto <= 2765.66 -> {
                ((salarioBruto * 0.09)).toFloat()
            }
            salarioBruto <= 5531.31 -> {
                ((salarioBruto * 0.11)).toFloat()
            }
            else -> {
                608.44F
            }
        }
        return inssDiscount
    }

    fun calculateIRPF(salarioBruto: Float): Float{
        var irpfDiscount: Float = when {
            salarioBruto <= 1903.98 -> {
                (salarioBruto * 0)
            }
            salarioBruto <= 2826.65 -> {
                ((salarioBruto * 0.075)).toFloat()
            }
            salarioBruto <= 3751.05 -> {
                ((salarioBruto * 0.15)).toFloat()
            }
            salarioBruto <= 4664.68 -> {
                ((salarioBruto * 0.225)).toFloat()
            }
            else -> {
                ((salarioBruto * 0.275)).toFloat()
            }
        }
        return irpfDiscount
    }

    fun calculateTotalSalary(salarioBruto: Float, depenentes: Int, pensao: Float): Float{
        val irpf = this.calculateIRPF(salarioBruto)
        val inss = this.calculateInss(salarioBruto)

        return (salarioBruto - inss - irpf - pensao - (depenentes * 189.59)).toFloat()
    }

    fun totalDiscount(pensao: Float, planoSaude: Float, descontos: Float): Float {
        return pensao + planoSaude + descontos
    }

    fun percentageDiscount(salarioBruto: Float, pensao: Float, planoSaude: Float, descontos: Float): Float {
        val discounts = this.totalDiscount(pensao, planoSaude, descontos)
        return (discounts * 100) / salarioBruto
    }

    fun checkNullOrEmpty(input: String?): String{
        return if(input.isNullOrEmpty()){
            0.toString()
        }else input

    }
}