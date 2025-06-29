package com.muslima.myrac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.muslima.myrac.databinding.ActivityFullBinding

class FullActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFullBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val nameAnimal = intent.getStringExtra(name)
        val imgAnimal = intent.getStringExtra(img)
        val bioAnimal = intent.getStringExtra(bio)
        binding.title.text = nameAnimal
        binding.description.text = bioAnimal
        Glide.with(this).load(imgAnimal).into(binding.image)
    }

    companion object {
        const val img = "img"
        const val name = "name"
        const val bio = "bio"
    }
}