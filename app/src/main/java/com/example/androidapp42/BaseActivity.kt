package com.example.androidapp42

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding

open class BaseActivity<T : ViewBinding>(private val bindingInflater: (LayoutInflater) -> T) :
    AppCompatActivity() {

    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingInflater(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    protected fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    protected fun showConfirmationDialog(context: Context, onConfirmed: () -> Unit) {
        AlertDialog.Builder(context).setTitle("Confirm Submission")
            .setMessage("Are you sure you want to submit your information?")
            .setPositiveButton("Yes") { dialog, _ ->
                onConfirmed() // Call your action here
                dialog.dismiss()
            }.setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }.setIcon(
                android.R.drawable.ic_dialog_info
            ).show()
    }

    protected fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        }
        startActivity(intent)
    }

    protected fun goToIndexActivity(){
        val intent=Intent(this, IndexActivity::class.java)
        startActivity(intent)
    }
}
