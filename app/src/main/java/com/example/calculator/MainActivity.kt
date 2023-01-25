package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    lateinit var button1: android.widget.Button
    lateinit var button2: android.widget.Button
    lateinit var button3: android.widget.Button
    lateinit var button4: android.widget.Button
    lateinit var button5: android.widget.Button
    lateinit var button6: android.widget.Button
    lateinit var button7: android.widget.Button
    lateinit var button8: android.widget.Button
    lateinit var button9: android.widget.Button
    lateinit var button0: android.widget.Button
    lateinit var button00: android.widget.Button
    lateinit var buttonEqual: android.widget.Button
    lateinit var buttonAdd: android.widget.Button
    lateinit var buttonSubtract: android.widget.Button
    lateinit var buttonMult: android.widget.Button
    lateinit var buttonDivide: android.widget.Button
    lateinit var buttonBackspace: android.widget.Button
    lateinit var buttonPercent: android.widget.Button
    lateinit var buttonDot: android.widget.Button
    lateinit var buttonClr: android.widget.Button
    lateinit var input: EditText
    lateinit var resoutput: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        buttonClr=findViewById(R.id.ButtonClr)
        button0=findViewById(R.id.Button0)
        button1=findViewById(R.id.button1)
        button2=findViewById(R.id.Button2)
        button3=findViewById(R.id.Button3)
        button4=findViewById(R.id.Button4)
        button5=findViewById(R.id.Button5)
        button6=findViewById(R.id.Button6)
        button7=findViewById(R.id.Button7)
        button8=findViewById(R.id.Button8)
        button9=findViewById(R.id.Button9)
        button00=findViewById(R.id.Button00)
        buttonEqual=findViewById(R.id.ButtonEqual)
        buttonAdd=findViewById(R.id.ButtonAdd)
        buttonSubtract=findViewById(R.id.ButtonSubtract)
        buttonMult=findViewById(R.id.ButtonMult)
        buttonDivide=findViewById(R.id.ButtonDivide)
        buttonDot=findViewById(R.id.ButtonDot)
        buttonBackspace=findViewById(R.id.ButtonBackspace)
        buttonPercent=findViewById(R.id.ButtonPercent)
        input=findViewById(R.id.input)
        resoutput=findViewById(R.id.resoutput)

        var text: String
        var check: Int
        check=0

        button0.setOnClickListener {
            text=input.text.toString()+"0"
            input.setText(text)
            result(text,check)
        }
        button00.setOnClickListener {
            text=input.text.toString()+"00"
            input.setText(text)
            result(text,check)
        }
        button1.setOnClickListener {
            text=input.text.toString()+"1"
            input.setText(text)
            result(text,check)
        }
        button2.setOnClickListener {
            text=input.text.toString()+"2"
            input.setText(text)
            result(text,check)
        }
        button3.setOnClickListener {
            text=input.text.toString()+"3"
            input.setText(text)
            result(text,check)
        }
        button4.setOnClickListener {
            text=input.text.toString()+"4"
            input.setText(text)
            result(text,check)
        }
        button5.setOnClickListener {
            text=input.text.toString()+"5"
            input.setText(text)
            result(text,check)
        }
        button6.setOnClickListener {
            text=input.text.toString()+"6"
            input.setText(text)
            result(text,check)
        }
        button7.setOnClickListener {
            text=input.text.toString()+"7"
            input.setText(text)
            result(text,check)
        }
        button8.setOnClickListener {
            text=input.text.toString()+"8"
            input.setText(text)
            result(text,check)
        }
        button9.setOnClickListener {
            text=input.text.toString()+"9"
            input.setText(text)
            result(text,check)
        }
        buttonDot.setOnClickListener {
            text=input.text.toString()+"."
            input.setText(text)
            result(text,check)
        }
        buttonAdd.setOnClickListener {
            text=input.text.toString()+"."
            input.setText(text)
            check += 1
        }
        buttonAdd.setOnClickListener {
            text=input.text.toString()+"+"
            input.setText(text)
            check += 1
        }
        buttonSubtract.setOnClickListener {
            text=input.text.toString()+"-"
            input.setText(text)
            check += 1
        }
        buttonMult.setOnClickListener {
            text=input.text.toString()+"*"
            input.setText(text)
            check += 1
        }
        buttonDivide.setOnClickListener {
            text=input.text.toString()+"÷"
            input.setText(text)
            check += 1
        }
        buttonPercent.setOnClickListener {
            text=input.text.toString()+"%"
            input.setText(text)
            check += 1
        }
        buttonEqual.setOnClickListener {
            text=resoutput.text.toString()
            input.setText(text)
            resoutput.setText(null)
        }
        buttonClr.setOnClickListener {
            input.setText(null)
            resoutput.setText(null)
        }

        buttonBackspace.setOnClickListener {
            var Backspace:String?=null
            if(input.text.length>0)
            {
                val stringBuilder:StringBuilder= StringBuilder(input.text)
                val find=input.text.toString()
                val find2=find.last()

                if(find2.equals('+')||find2.equals("-")||find2.equals("*")||find2.equals("÷")||find2.equals("%"))
                {
                    check=check-1
                }
                stringBuilder.deleteCharAt(input.text.length-1)
                Backspace=stringBuilder.toString()
                input.setText(Backspace)
                result(Backspace,check)
            }
        }

    }

    private fun result(text: String, check: Int) {
        val engine: ScriptEngine=ScriptEngineManager().getEngineByName("rhino")
        try {
            val result: Any = engine.eval(text)
            var mainr = result.toString()
            if (check == 0) {
                resoutput.setText(null)
            } else {
                resoutput.setText(mainr)
            }
        }
        catch (e: ScriptException)
        {
            Log.d("TAG","ERROR")
        }

    }
}