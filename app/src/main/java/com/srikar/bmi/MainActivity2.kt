package com.srikar.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.srikar.bmi.databinding.ActivityMain2Binding
import com.srikar.bmi.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.result.text = intent.getStringExtra("BMI")

        if(binding.result.text.toString().toFloat()<18.5){
            binding.answer.text = "UnderWeight"
        }
        else if(binding.result.text.toString().toFloat()>=18.5 && binding.result.text.toString().toFloat()<=24.9){
            binding.answer.text = "Healthy"
        }
        else if(binding.result.text.toString().toFloat()>=25 && binding.result.text.toString().toFloat()<=29.9){
            binding.answer.text = "OverWeight"
        }
        else if(binding.result.text.toString().toFloat()>=30){
            binding.answer.text = "Obese"
        }

    }
}