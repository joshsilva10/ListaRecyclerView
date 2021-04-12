package com.example.recyclerviewexample

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.inflate
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.Switch
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.recyclerviewexample.DataListener

class MainActivity : AppCompatActivity() {

    private var titleList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()
    private var data = testSend()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btOpen: FloatingActionButton = findViewById(R.id.bt_add)
         btOpen.setOnClickListener {
             val window = DialogCustome()
             window.show(supportFragmentManager,"customDialog")


         }


        Listar()


        val rv : RecyclerView = findViewById(R.id.rv_recycler)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = RecyclerAdapter(titleList,descList,imagesList)
    }

    fun ListAdd(title:String, nation:String,sex:String, select:Int){
        data.add(DataListener(title,nation,sex))
        titleList.add(title)
        descList.add(nation)
        imagesList.add(select)


    }
     fun addToList( tittle: String,  desc: String, img: Int, sex: String){

        titleList.add(tittle)
        descList.add(desc)
        imagesList.add(img)
    }


    fun Listar(){
        val tamanho = data.lastIndex
        for (n:Int in 0..tamanho){
            val sex=data[n].sex

           when(sex){
               "MASCULINO"-> addToList(data[n].user, data[n].nation,R.mipmap.ic_launcher_male,sex)
               else -> addToList(data[n].user, data[n].nation,R.mipmap.ic_launcher_female,sex)

           }


        }
    }


}
