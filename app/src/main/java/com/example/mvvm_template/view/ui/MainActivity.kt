package com.example.mvvm_template.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.Dimension
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import com.example.mvvm_template.R
import com.example.mvvm_template.databinding.ActivityMainBinding
import com.example.mvvm_template.databinding.ActivityMainBindingImpl
import com.example.mvvm_template.util.EventObserver
import com.example.mvvm_template.view.adapter.PersonListAdapter
import com.example.mvvm_template.viewModel.MyViewModel
import kotlinx.android.synthetic.main.test.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val myViewModel: MyViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    private val personListAdapter: PersonListAdapter by lazy {
        PersonListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
            .apply {
                viewModel = myViewModel
                lifecycleOwner = this@MainActivity
            }

        binding.recyclerView.apply {
            adapter = personListAdapter
            setHasFixedSize(true)
        }
        initObserver()
    }

    private fun initObserver() {
        myViewModel.error.observe(this, EventObserver{
            if(it == "network"){
                Toast.makeText(this, "네트워크 에러 발생", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "서버 에러 발생", Toast.LENGTH_LONG).show()
            }
        })
    }
}