package com.example.calculatorkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var value : Int = 0

        var clear : Boolean = false

        var calc : Boolean = false

        var operator : String? = null

        val buttonZero : Button = findViewById(R.id.zero)
        val buttonOne : Button = findViewById(R.id.one)
        val buttonTwo : Button = findViewById(R.id.two)
        val buttonThree : Button = findViewById(R.id.three)
        val buttonFour :Button = findViewById(R.id.four)
        val buttonFive : Button = findViewById(R.id.five)
        val buttonSix : Button = findViewById(R.id.six)
        val buttonSeven : Button = findViewById(R.id.seven)
        val buttonEight : Button = findViewById(R.id.eight)
        val buttonNine : Button = findViewById(R.id.nine)

        val buttonAdd : Button = findViewById(R.id.add)
        val buttonMul : Button = findViewById(R.id.mul)
        val buttonSub : Button = findViewById(R.id.sub)
        val buttonDiv : Button = findViewById(R.id.div)
        val buttonEqual : Button = findViewById(R.id.equal)
        val buttonClear : Button = findViewById(R.id.clear)

        val textArea : TextView = findViewById(R.id.display)

        fun numButtonAction(num : String) {
            if(textArea.text.toString() != "0" && clear == false) {
                textArea.text = textArea.text.toString() + num
            } else {
                clear = false
                textArea.text = num
            }
            calc = true
        }

        buttonClear.setOnClickListener {
            textArea.text = "0"
            value = 0
            operator = null
            clear = false
            calc = false
        }

        buttonZero.setOnClickListener {
            numButtonAction("0")
        }

        buttonOne.setOnClickListener {
            numButtonAction("1")
        }

        buttonTwo.setOnClickListener {
            numButtonAction("2")
        }

        buttonThree.setOnClickListener {
            numButtonAction("3")
        }

        buttonFour.setOnClickListener {
            numButtonAction("4")
        }

        buttonFive.setOnClickListener {
            numButtonAction("5")
        }

        buttonSix.setOnClickListener {
            numButtonAction("6")
        }

        buttonSeven.setOnClickListener {
            numButtonAction("7")
        }

        buttonEight.setOnClickListener {
            numButtonAction("8")
        }

        buttonNine.setOnClickListener {
            numButtonAction("9")
        }

        fun calculation(op : String?) :Int {
            return if (op == "+") {
                value + textArea.text.toString().toInt()
            } else if (op == "-") {
                value - textArea.text.toString().toInt()
            } else if (op == "*") {
                value * textArea.text.toString().toInt()
            } else if (op == "/") {
                value / textArea.text.toString().toInt()
            } else {
                textArea.text.toString().toInt()
            }
        }

        fun calcButtonAction(op : String?) {
            if (calc == true) {
                value = calculation(operator)
                clear = true
                calc =false
                textArea.text = value.toString()
            }
            operator = op
        }

        buttonAdd.setOnClickListener {
            calcButtonAction("+")
        }

        buttonMul.setOnClickListener {
            calcButtonAction("*")
        }

        buttonSub.setOnClickListener {
            calcButtonAction("-")
        }

        buttonDiv.setOnClickListener {
            calcButtonAction("/")
        }

        buttonEqual.setOnClickListener {
            if (calc == true) {
                value = calculation(operator)
                calc = false
                clear = true
                textArea.text = value.toString()
                operator = null
            }
        }

    }
}
