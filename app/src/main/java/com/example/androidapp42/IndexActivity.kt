package com.example.androidapp42

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidapp42.databinding.ActivityIndexBinding
import com.example.androidapp42.databinding.ActivityMainBinding
import com.example.androidapp42.databinding.ActivityMainBinding.inflate

class IndexActivity : BaseActivity<ActivityIndexBinding>(ActivityIndexBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.buttonBack.setOnClickListener {
            goToMainActivity()
        }
    }
}