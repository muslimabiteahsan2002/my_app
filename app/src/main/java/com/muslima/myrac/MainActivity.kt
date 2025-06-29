package com.muslima.myrac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muslima.myrac.amimal.AllAnimals
import com.muslima.myrac.amimal.AnimalAdapter
import com.muslima.myrac.amimal.*
import com.muslima.myrac.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var animalAdapter: AnimalAdapter
    private val animal = listOf(
        AllAnimals(name1, bio1, img1),
        AllAnimals(name2, bio2, img2),
        AllAnimals(name3, bio3, img3)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        animalAdapter = AnimalAdapter(this)
        animalAdapter.submitList(animal)
        binding.allDataRcv.adapter=animalAdapter
    }
}