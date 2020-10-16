package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //numbers
        bt1.setOnClickListener{appendOnExpression("1",true)}
        bt2.setOnClickListener{ appendOnExpression ("2",true)}
        bt3.setOnClickListener{appendOnExpression("3",true)}
        bt4.setOnClickListener{appendOnExpression("4",true)}
        bt5.setOnClickListener{appendOnExpression("5",true)}
        bt6.setOnClickListener{appendOnExpression("6",true)}
        bt7.setOnClickListener{appendOnExpression("7",true)}
        bt8.setOnClickListener{appendOnExpression("8",true)}
        bt9.setOnClickListener{appendOnExpression("9",true)}
        bt0.setOnClickListener{appendOnExpression("0",true)}
        btdot.setOnClickListener{appendOnExpression(".",true)}

        //operators

        btplus.setOnClickListener{appendOnExpression("+", false)}
        btminus.setOnClickListener{appendOnExpression("-", false)}
        btmult.setOnClickListener{appendOnExpression("*", false)}
        btdiv.setOnClickListener{appendOnExpression("/", false)}
        btopen.setOnClickListener{appendOnExpression("(", false)}
        btclose.setOnClickListener{appendOnExpression(")", false)}

        btclear.setOnClickListener{
            txtinput.text=""
            txtresult.text=""
        }
        btback.setOnClickListener{
            val string =txtinput.text.toString()
            if(string.isNotEmpty()){
                txtinput.text=string.substring(0,string.length-1)
            }
            txtresult.text=""
        }
        btequal.setOnClickListener{
            try{
                val expression= ExpressionBuilder(txtinput.text.toString()).build()
                val result =expression.evaluate()
                val longResult =result.toLong()
                if(result == longResult.toDouble())
                    txtresult.text = longResult.toString()
                else
                    txtresult.text=result.toString()
            }catch (e:Exception){
                Log.d("Exception", "message:" +e.message)
            }

        }
    }

    private fun appendOnExpression(s: String, b: Boolean) {
        if(txtresult.text.isNotEmpty())
        {
            txtinput.text=""
        }

        if(b)
        {
            txtresult.text=""
            txtinput.append(s)
        }
        else
        {
            txtinput.append(txtresult.text)
            txtinput.append(s)
            txtresult.text=""
        }
    }


}

