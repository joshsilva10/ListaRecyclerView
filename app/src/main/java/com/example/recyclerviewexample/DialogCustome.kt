package com.example.recyclerviewexample

import android.os.Bundle
import android.telephony.RadioAccessSpecifier
import android.view.*
import android.widget.*
import android.widget.Toast.*
import androidx.appcompat.view.menu.ShowableListMenu
import androidx.fragment.app.DialogFragment
import com.example.recyclerviewexample.MainActivity
import com.example.recyclerviewexample.testSend
import com.example.recyclerviewexample.RecyclerAdapter

class DialogCustome : DialogFragment() {
    private var test = MainActivity()
    private var sender = testSend()


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView: View = inflater.inflate(R.layout.popup_window, container, false)
        val btcancel:Button = rootView.findViewById(R.id.btCanc)
        val btSubmit:Button = rootView.findViewById(R.id.btAdc)
        val orientacao:TextView = rootView.findViewById(R.id.textSex)
        registerForContextMenu(orientacao)




        orientacao.setOnClickListener {

        }
        btcancel.setOnClickListener{
            dismiss()
        }
        btSubmit.setOnClickListener {
            val  nome = rootView.findViewById<EditText>(R.id.editNome)
            val nation =rootView.findViewById<EditText>(R.id.editNacao)
            val sexo = rootView.findViewById<RadioGroup>(R.id.RG_radio)
            val select = sexo.checkedRadioButtonId
            val sexf = rootView.findViewById<RadioButton>(R.id.radioFemale)
            //val sexm = rootView.findViewById<RadioButton>(R.id.radioMale)
            var selecao:Int= 0
            var sex:String = ""
            if (select.toString() == sexf.text){
                selecao = R.mipmap.ic_launcher_female
                sex="FEMININO"
            }else{
                selecao = R.mipmap.ic_launcher_male
                sex="MASCULINO"
            }

            test.ListAdd(nome.toString(),nation.toString(),sex,selecao)

            sender.add(DataListener(nome.toString(),nation.toString(),sex))

            dismiss()
        }

        return rootView
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
       val t= MenuInflater(context).inflate(R.menu.mymenu, menu)


    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_masc->{ Toast.makeText(context,"MASCULINO", Toast.LENGTH_LONG).show()
                return true}
            R.id.item_fem ->{ Toast.makeText(context,"FEMININO", Toast.LENGTH_LONG).show()
                return true}
            else-> return super.onContextItemSelected(item)

        }

    }

}