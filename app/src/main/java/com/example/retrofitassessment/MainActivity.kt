package com.example.retrofitassessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitassessment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var itemadapter: Adapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        itemadapter = Adapter((listOf()))
        binding.recyclerView.adapter = itemadapter


        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.apply {
            getAllItems()
            model.observe(this@MainActivity, { items ->
                itemadapter.list = items
                itemadapter.notifyDataSetChanged()

            })

        }

        binding.btn.setOnClickListener {
            viewModel.apply {
                addStudent()
            }
        }

    }
}
