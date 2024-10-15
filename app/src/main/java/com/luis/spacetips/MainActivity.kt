package com.luis.spacetips

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.luis.spacetips.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.mainButton.setOnClickListener {


            val tipTemp = binding.etMsTip.text
            val billTemp = binding.etMsBill.text



            if(tipTemp.isNotEmpty() && billTemp.isNotEmpty() ) {

                val tipStr: String = binding.etMsTip.text.toString()
                val billStr: String = binding.etMsBill.text.toString()

                val tipValue = tipStr.toFloat()
                val billValue = billStr.toFloat()

                val percentage = tipValue / 100
                val tipAmount = billValue * percentage

                binding.tipResult.text = tipAmount.toString() + " $"
                binding.percentResult.text = tipTemp.toString() + " %"

            } else if(tipTemp.isEmpty() && billTemp.isNotEmpty()) {
                Snackbar.make(binding.root, "Tip cannot be empty", Snackbar.LENGTH_SHORT).show()

            } else if(billTemp.isEmpty() && tipTemp.isNotEmpty()) {
                Snackbar.make(binding.root, "Bill cannot be empty", Snackbar.LENGTH_SHORT).show()

            } else if(billTemp.isEmpty() && tipTemp.isEmpty()) {
                Snackbar.make(binding.root, "Tip and Bill cannot be empty", Snackbar.LENGTH_SHORT).show()
            }

        }

        binding.cleanButton.setOnClickListener {
            binding.tipResult.text = ""
            binding.percentResult.text = ""
            binding.etMsTip.setText("")
            binding.etMsBill.setText("")


        }
    }
}