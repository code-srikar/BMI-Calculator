package com.srikar.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.srikar.bmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calc.setOnClickListener(){

            if(!TextUtils.isEmpty(binding.age.text) && !TextUtils.isEmpty(binding.height.text) && !TextUtils.isEmpty(binding.weight.text) && binding.age.text.toString().toFloat()>=20){
                val h = binding.height.text.toString().toFloat()/100
                val w = binding.weight.text.toString().toFloat()
                val a = binding.age.text.toString().toFloat()
                val bmi = w/(h*h)
                val intent = Intent(this,MainActivity2::class.java)
                intent.putExtra("BMI",bmi.toString())
                startActivity(intent)
            }
            else if(TextUtils.isEmpty(binding.age.text) || TextUtils.isEmpty(binding.height.text) || TextUtils.isEmpty(binding.weight.text)){
                Toast.makeText(this,"Enter the Details",Toast.LENGTH_SHORT).show()
            }
            else if(binding.age.text.toString().toFloat()<20){
                Toast.makeText(this,"Age is below 20",Toast.LENGTH_SHORT).show()
            }

        }

    }
}