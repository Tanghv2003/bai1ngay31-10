package com.example.happy

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.happy.ui.theme.HappyTheme

class MainActivity : ComponentActivity() {

    lateinit var tvDisPlay: TextView;
    var cInput : String = "";//
    var op : String? = null;// toan tu
    var op1 : Int? = null;// toan hang 1
    var op2 : Int? = null;// toan hang 2




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main1)  // Sets the content view to main.xml

        tvDisPlay = findViewById(R.id.tvDisplay);
        val btnAdd : Button = findViewById(R.id.buttonAdd);
        val btnDiv : Button = findViewById(R.id.buttonDiv);
        val btnMul : Button = findViewById(R.id.buttonMul);
        val btnSub : Button = findViewById(R.id.buttonSub);

        val btnC : Button = findViewById(R.id.buttonC);
        val btnCE : Button = findViewById(R.id.buttonCE);
        val btnBS : Button = findViewById(R.id.buttonBS);
        val btnEqual: Button = findViewById(R.id.buttonEqual);

        val btnDot : Button = findViewById(R.id.buttonDot);
        val btnPlusMinus : Button = findViewById(R.id.buttonSign);

        val btn1 : Button = findViewById(R.id.button1);
        val btn2 : Button = findViewById(R.id.button2);
        val btn3 : Button = findViewById(R.id.button3);
        val btn4 : Button = findViewById(R.id.button4);
        val btn5 : Button = findViewById(R.id.button5);
        val btn6 : Button = findViewById(R.id.button6);
        val btn7 : Button = findViewById(R.id.button7);
        val btn8 : Button = findViewById(R.id.button8);
        val btn9 : Button = findViewById(R.id.button9);
        val btn0 : Button = findViewById(R.id.button0);

        val inputs = listOf(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0);
        for(input in inputs ){
            input.setOnClickListener{
                onNumberInput(input.text.toString());
            }
        }
        val opera = listOf(btnAdd, btnDiv, btnMul, btnSub);
        for(input in opera){
            input.setOnClickListener{
                onOperaInput(input.text.toString());
            }
        }


        btnCE.setOnClickListener{
            cInput = "";
            op1 = null;
            op = null;
            tvDisPlay.text ="";
        }
        btnC.setOnClickListener{
            cInput = "";
            tvDisPlay.text = "";
        }
        btnEqual.setOnClickListener{process()};

    }

    private fun onOperaInput(opp : String) {
        if(cInput.isNotEmpty()){
            op1 = cInput.toInt();
            cInput = "";
            op = opp;
        }
        tvDisPlay.text = tvDisPlay.text.toString() + op;
    }

    private fun onNumberInput(number: String) {
        cInput = cInput + number;
        tvDisPlay.text = tvDisPlay.text.toString() + cInput;
    }
    private fun process(){
        if(op1 != null && op != null && cInput.isNotEmpty()){
            op2 = cInput.toInt();
            var rs : Int? = null;
            while(true){
                if(op == "+"){
                    rs = op1!! + op2!!;
                    break;
                }
                if(op == "-"){
                    rs = op1!! - op2!!;
                    break;
                }
                if(op == "*"){
                    rs = op1!! * op2!!;
                    break;
                }
                if(op == "/"){
                    if(op2 != 0){
                        rs = op1!!/ op2!!;
                        break;
                    }else{
                        tvDisPlay.text = "Syntax Error";
                        break;
                    }
                }
            }

            if(rs != null){
                tvDisPlay.text = rs.toString();
                cInput = rs.toString();
                op1 = null;
                op = null;
            }



        }
    }


}
