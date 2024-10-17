package com.luis.spacetips

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.luis.spacetips.databinding.ActivityMainBinding
import com.luis.spacetips.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val billWithTips = intent.getFloatExtra("billWithTips", 0.0f)
        val tipPercentage = intent.getIntExtra("tipTemp", 0)
        val personAmount = intent.getIntExtra("personAmount", 0)
        val billWithoudTips = intent.getFloatExtra("billValue", 0.0f)
        val billPerPerson = intent.getFloatExtra("billPerPerson", 0.0f)

        binding.tvBillWithouttips.setText(billWithoudTips.toString() + "$")
        binding.tvBillperperson.setText(billPerPerson.toString())
        binding.tvBillWithtips.setText(billWithTips.toString())
        binding.tvTipPercentage.setText(tipPercentage.toString() + "%")
        binding.tvPersonsAmount.setText(personAmount.toString())


        binding.refreshBtn.setOnClickListener {
            finish()

        }



    }
}