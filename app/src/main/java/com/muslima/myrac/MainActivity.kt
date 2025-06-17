package com.muslima.myrac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muslima.myrac.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.areaBtn.setOnClickListener {
            val lengthStr = binding.lengthEt.text.toString().trim()
            val weightStr = binding.weightEt.text.toString().trim()
            if (lengthStr.isEmpty()) {
                binding.lengthEt.error = "Enter the length"
            } else if (weightStr.isEmpty()) {
                binding.weightEt.error = "Enter the weight"
            } else {
                val length = lengthStr.toInt()
                val weight = weightStr.toInt()
                rectangleArea(length, weight)
            }
        }
    }

    private fun rectangleArea(length: Int, weight: Int) {
        val area = length * weight
        binding.areaTv.text = "The area of rectangle is $area M^2"
    }
}