package org.d3if0008.hitungvolumeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object{
        private const val RESULT_STATE = "result_state"
    }

    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_heigth)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener { calculateInput() }

        if (savedInstanceState != null){
            val getResult = savedInstanceState.getString(RESULT_STATE)
            tvResult.text = getResult
        }
    }

    private fun calculateInput(){

        var isEmptyFields = false

        val width = edtWidth.text.toString()
        if (width.isEmpty()){
           isEmptyFields = true
           edtWidth.error = " Width Field cannot empty"
        }

        val length = edtLength.text.toString()
        if (length.isEmpty()){
            isEmptyFields = true
            edtLength.error = "Length Field cannot empty"
        }

        val height = edtHeight.text.toString()
        if (height.isEmpty()){
            isEmptyFields = true
            edtHeight.error = " Height Field cannot empty"
        }

        if (!isEmptyFields){
            val result = width.toDouble() * length.toDouble() * height.toDouble()
            tvResult.text = result.toString()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(RESULT_STATE, tvResult.text.toString())
    }
}