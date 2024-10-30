package com.example.happy

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import android.widget.*
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
import com.google.android.material.navigation.NavigationBarView

class MainActivity : ComponentActivity() {

    lateinit var tvDisPlay: TextView;
    var cInput : String = "";//
    var op : String? = null;// toan tu
    var op1 : Int? = null;// toan hang 1
    var op2 : Int? = null;// toan hang 2





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.doitien)

        val vietnam = mapOf("US" to 1/25641f, "Viet Nam" to 1.0/1f, "Japan" to 1.0/166f, "Korea" to 1.0/18f)
        val korea = mapOf("US" to 72.0/100f, "Viet Nam" to 18/1f, "Japan" to 1.0/9f, "Korea" to 1f)
        val us = mapOf("US" to 1f, "Viet Nam" to 25353f, "Japan" to 152.955f, "Korea" to 1384.25f)
        val japan = mapOf("US" to 654/100000f, "Viet Nam" to 165.744f, "Japan" to 1f, "Korea" to 9.046f)


        val change = mapOf("Viet Nam" to vietnam, "Korea" to korea, "US" to us, "Japan" to japan)
        var type1 = ""
        var type2 = ""

        val listItem = arrayOf("Viet Nam", "US", "Japan", "Korea")

        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            listItem
        )

        val spinner1: Spinner = findViewById(R.id.spinner1)
        val spinner2: Spinner = findViewById(R.id.spinner2)

        spinner1.adapter = adapter
        spinner2.adapter = adapter

        val inputText1: EditText = findViewById(R.id.input1)
        val inputText2: EditText = findViewById(R.id.input2)

        spinner1.onItemSelectedListener = object : NavigationBarView.OnItemSelectedListener, AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                type1 = listItem[p2]
                inputText1.setText("")
                inputText2.setText("0")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                type1 = listItem[0]
            }

            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                TODO("Not yet implemented")
            }
        }

        spinner2.onItemSelectedListener = object : NavigationBarView.OnItemSelectedListener, AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                type2 = listItem[p2]
                inputText2.setText("")
                inputText1.setText("0")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                type2 = listItem[0]
            }

            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                TODO("Not yet implemented")
            }
        }

        inputText1.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                // Khi editText1 được focus
                inputText1.setText("")
                inputText2.setText("0")
            }
        }

        inputText2.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                // Khi editText1 được focus
                inputText2.setText("")
                inputText1.setText("0")
            }
        }

        inputText1.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                if (inputText1.isFocused) {
                    if (p0 != null) {
                        if (p0.isNotEmpty()) {
                            var input1 = p0.toString().toInt()
                            var rate = change[type1]?.get(type2)?.toFloat()
                            var num2 = input1 * rate!!
                            inputText2.setText("$num2")
                        }
                    }
                }
            }

        })

        inputText2.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                if (inputText2.isFocused) {
                    if (p0 != null) {
                        if (p0.isNotEmpty()) {
                            var input2 = p0.toString().toFloat()
                            var rate = change[type2]?.get(type1)?.toFloat()
                            var num1 = input2 * rate!!
                            inputText1.setText("$num1")
                        }
                    }
                }
            }

        })
    }


}