package com.example.showrandomimage

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import coil.load
import com.example.showrandomimage.databinding.ActivityMainBinding
import com.example.showrandomimage.utils.Status
import com.example.showrandomimage.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgRefresh.setOnClickListener {
            getImage()
        }
    }

    private fun getImage() {
        mainViewModel.getRandomImage().observe(this, Observer {
            it.let { resource ->
                when (resource.status) {

                    Status.SUCCESS -> {
                        binding.pbDog.visibility = View.GONE

                        if (resource.data?.isSuccessful == true){
                            binding.imgDog.load(resource.data.body()?.message)
                        }
                        println("data===== ${resource.data}")
                    }

                    Status.ERROR -> {
                        binding.pbDog.visibility = View.GONE
                        println("ERROR===== ${it.message}")
                    }

                    Status.LOADING -> {
                        binding.pbDog.visibility = View.VISIBLE
                    }
                }
            }
        })
    }
}