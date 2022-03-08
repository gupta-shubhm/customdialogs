package com.ifyinc.mycustomdialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.ifyinc.mycustomdialog.databinding.ActivityMainBinding
import com.ifyinc.mycustomdialog.databinding.Customdialog1Binding
import com.ifyinc.mycustomdialog.databinding.Customdialog2Binding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private val binding get() = mainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dialogOneButton.setOnClickListener {
            openDialogOne()
        }

        binding.dialogTwoButton.setOnClickListener {
            openDialogOne()
        }
    }

    private fun openDialogOne() {
        val view = LayoutInflater.from(this@MainActivity).inflate(R.layout.customdialog_2, null)
        val dialog = AlertDialog.Builder(this@MainActivity).setView(view)
        val dialogBinding = Customdialog2Binding.bind(view)

        dialog.create().apply {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setCancelable(false)
            show()
        }

        dialogBinding.confirmButton.setOnClickListener {
            Toast.makeText(applicationContext,"This is confirm button",Toast.LENGTH_SHORT).show()
        }

        dialogBinding.cancelButton.setOnClickListener {
            Toast.makeText(applicationContext,"This is cancel button",Toast.LENGTH_SHORT).show()
        }

    }
}