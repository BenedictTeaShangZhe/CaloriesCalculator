package com.example.caloriescalculator

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.spinnerAge)
        val tvresult: TextView = findViewById(R.id.tvCalories)
        val calculateButton : Button = findViewById(R.id.btnCalculate)
        val rbMale : RadioButton = findViewById(R.id.rbMale)
        val rbFemale : RadioButton = findViewById(R.id.rbFemale)
        val rgGender : RadioGroup = findViewById(R.id.rgGender)
        val calculation : Button = findViewById(R.id.btnCalculate)
        var rbSelectedisFemale : Boolean = false

        val ages = arrayOf("19-30 years","31-59 years","60+ years")
        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,ages)
        spinner.adapter=adapter

        spinner.setSelection(0)

        rgGender.setOnCheckedChangeListener { rgGender, checkId ->
            if(checkId == R.id.rbFemale)
                rbSelectedisFemale = true
            if(checkId == R.id.rbMale)
                rbSelectedisFemale = false
        }

        calculation.setOnClickListener()
        {
            tvresult.text = when(rbSelectedisFemale){
                true-> when(spinner.selectedItemPosition){
                    0-> "2000 - 2400 calories"
                    1-> "1800 - 2200 calories"
                    2-> "1600 - 2000 calories"
                    else->"Error"
                }
                else->when(spinner.selectedItemPosition){
                    0-> "2400 - 3000 calories"
                    1-> "2200 - 3000 calories"
                    2-> "2000 - 2600 calories"
                    else->"Error"
                }
            }
        }



        /*btn.clearresult.setonclick{
            radoigroup.clearcheck
            spinner.setSelection(0)
            tvresult.text->""
        }*/
    }


}

