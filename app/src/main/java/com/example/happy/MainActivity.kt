package com.example.happy

import android.os.Bundle
import android.widget.*
import androidx.activity.ComponentActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bai1ngay31thang10)

        val m_userinput = findViewById<TextInputEditText>(R.id.abc)
        val m_buttonSoChan = findViewById<RadioButton>(R.id.radioButton1)
        val m_buttonSoLe = findViewById<RadioButton>(R.id.radioButton2)
        val m_buttonSoCP = findViewById<RadioButton>(R.id.radioButton3)
        val m_errorTextView = findViewById<TextView>(R.id.textView)
        val m_btnShow = findViewById<Button>(R.id.button)
        val m_listView = findViewById<ListView>(R.id.listViewShow)

        m_btnShow.setOnClickListener {
            val a = m_userinput.text.toString()
            val number = a.toInt()

            if (a.isEmpty() ||  number <= 0) {
                m_errorTextView.text = "Khong hop le"
                return@setOnClickListener
            }


            m_errorTextView.text = ""


            val res = when {
                m_buttonSoCP.isChecked -> showSoChinhPhuong(number)
                m_buttonSoLe.isChecked -> showSoLe(number)
                m_buttonSoChan.isChecked -> showSoChan(number)
                else -> {
                    m_errorTextView.text = "Vui lòng chọn loại số."
                    return@setOnClickListener
                }
            }


            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, res)
            m_listView.adapter = adapter
        }
    }

    private fun showSoChan(number: Int): List<Int> {
        return (0..number).filter { it % 2 == 0 }
    }

    private fun showSoLe(number: Int): List<Int> {
        return (0..number).filter { it % 2 != 0 }
    }

    private fun showSoChinhPhuong(number: Int): List<Int> {
        return (0..number).filter { isPerfectSquare(it) }
    }

    private fun isPerfectSquare(num: Int): Boolean {
        val sqrt = Math.sqrt(num.toDouble()).toInt()
        return sqrt * sqrt == num
    }
}
