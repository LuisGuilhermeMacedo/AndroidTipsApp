package com.luis.spacetips

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.luis.spacetips.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.mainButton.setOnClickListener {


            val tipTemp = binding.etMsTip.text
            val billTemp = binding.etMsBill.text
            val personsTemp = binding.etMsPersons.text



            if(tipTemp.isNotEmpty() && billTemp.isNotEmpty() && personsTemp.isNotEmpty()) {

                val tipStr: String = binding.etMsTip.text.toString()
                val billStr: String = binding.etMsBill.text.toString()
                val personsStr: String = binding.etMsPersons.text.toString()

                val tipValue = tipStr.toFloat()
                val billValue = billStr.toFloat()
                val personValue = personsStr.toInt()

                val percentage = tipValue / 100
                val tipAmount = billValue * percentage
                val billWithTips = tipAmount + billValue
                val billPerPerson = billWithTips / personValue

                val tipPercentage: Int = tipTemp.toString().toInt()



                val intent = Intent(this, SummaryActivity::class.java)
                intent.apply {
                    putExtra("billWithTips", billWithTips)
                    putExtra("tipTemp", tipPercentage)
                    putExtra("billValue", billValue)
                    putExtra("personAmount", personValue)
                    putExtra("billPerPerson", billPerPerson)


                }
                startActivity(intent)

            } else if(tipTemp.isEmpty() && billTemp.isNotEmpty() && personsTemp.isNotEmpty()) {
                Snackbar.make(binding.root, "Tip cannot be empty", Snackbar.LENGTH_SHORT).show()
            } else if(billTemp.isNotEmpty() && tipTemp.isNotEmpty() && personsTemp.isEmpty()) {
                Snackbar.make(binding.root, "Persons cannot be empty", Snackbar.LENGTH_SHORT).show()
            }else if(billTemp.isEmpty() && tipTemp.isNotEmpty() && personsTemp.isNotEmpty()) {
                Snackbar.make(binding.root, "Bill cannot be empty", Snackbar.LENGTH_SHORT).show()


            } else if(billTemp.isEmpty() && tipTemp.isEmpty() && personsTemp.isNotEmpty()) {
                Snackbar.make(binding.root, "Tip and Bill cannot be empty", Snackbar.LENGTH_SHORT).show()
            } else if(billTemp.isEmpty() && tipTemp.isNotEmpty() && personsTemp.isEmpty()) {
                Snackbar.make(binding.root, "Bill and Persons cannot be empty", Snackbar.LENGTH_SHORT).show()
            } else if(billTemp.isNotEmpty() && tipTemp.isEmpty() && personsTemp.isEmpty()) {
                Snackbar.make(binding.root, "Tip and Persons cannot be empty", Snackbar.LENGTH_SHORT).show()
            } else if(billTemp.isNotEmpty() && tipTemp.isNotEmpty() && personsTemp.isEmpty()) {
                Snackbar.make(binding.root, "Persons cannot be empty", Snackbar.LENGTH_SHORT).show()
            }

        }

        binding.cleanButton.setOnClickListener {
            binding.etMsTip.setText("")
            binding.etMsBill.setText("")
            binding.etMsPersons.setText("")


        }
    }
}