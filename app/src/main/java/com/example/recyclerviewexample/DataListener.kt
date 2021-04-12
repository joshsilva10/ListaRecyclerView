package com.example.recyclerviewexample

data class DataListener (
        val user: String,
        val nation: String,
        val sex: String)

class testBuilder {
    var user: String = ""
    var nation: String = ""
    var sex: String = ""

    fun build(): DataListener = DataListener(user, nation, sex)
}

fun DataListener(block: testBuilder.() -> Unit): DataListener = testBuilder().apply(block).build()

fun testSend(): MutableList<DataListener> = mutableListOf(
        DataListener {
            user = "Alexandre de Andrade"
            nation = "BRASIL"
            sex = "MASCULINO"
        },
        DataListener {
            user = "Karen Diaz"
            nation = "ESPANHA"
            sex =  "FEMININO"
        },
        DataListener {
            user = "Philipp Eduard"
            nation = "EUA"
            sex = "MASCULINO"
        },
        DataListener {
            user = "Elizabeth Town"
            nation = "INGLATERRA"
            sex = "FEMININO"
        },
        DataListener {
            user = "Suzana Conceição"
            nation = "BRASIL"
            sex = "FEMININO"
        },
        DataListener {
            user = "Xin Zu Tsu"
            nation = "JAPÂO"
            sex = "MASCULINO"
        },
        DataListener {
            user = "Jean Paul"
            nation = "FRANÇA"
            sex = "MASCULINO"
        },
        DataListener {
            user = "Taarabt Harmen"
            nation = "MARROCOS"
            sex = "MASCULINO"
        },
        DataListener {
            user = "Papadopoulos Pondero"
            nation = "GRECIA"
            sex = "MASCULINO"
        },
        DataListener {
            user = "Raika Schneider"
            nation = "ALEMANHA"
            sex = "FEMININO"
        },
        DataListener {
            user = "Alessa Romanov"
            nation ="RUSSIA"
            sex = "FEMININO"
        }

)