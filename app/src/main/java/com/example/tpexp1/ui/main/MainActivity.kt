package com.example.tpexp1.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.tpexp1.data.model.Ringtone
import com.example.tpexp1.databinding.ActivityMainBinding
import com.example.tpexp1.ui.adapter.RingtoneAdapter
import com.example.tpexp1.ui.detail.DetailActivity
import dagger.android.support.DaggerAppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.ArrayList
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val ringtoneAdapter =
            RingtoneAdapter(this@MainActivity, object : RingtoneAdapter.IOnClickItem {
                override fun onClickDetailColection(position: Int, list: ArrayList<Ringtone>) {
                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    intent.putExtra(POSITION , position)
                    intent.putExtra(LIST,list)
                    startActivity(intent)
                }

            })

        binding.rcv.apply {
            lifecycleScope.launch {
                withContext(Dispatchers.Main) {
                    viewModel.getData().observe(this@MainActivity) {
                        it.data?.ringtones?.let { it1 -> ringtoneAdapter.setList(it1) }
                    }
                }
            }
            adapter = ringtoneAdapter
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    companion object{
        const val POSITION = "position"
        const val LIST = "list"
    }

}