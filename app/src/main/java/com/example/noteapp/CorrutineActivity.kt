package com.example.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.noteapp.databinding.ActivityCorrutineBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.String
import kotlin.String as String1

class CorrutineActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityCorrutineBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            Log.d("MyTag", "Hello")
            GlobalScope.launch { Dispatchers.IO

             withContext(Dispatchers.Main){
                 var name = networkCall()
                 binding.myText.text = name
             }
            }
        }
    }

    suspend fun networkCall(): String {
        delay(1000L)
        return "Imran Hassan"
    }


}