package com.example.currencyconverter


import android.annotation.SuppressLint
import android.os.Bundle

import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.currencyconverter.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var inputCurrency = "Australian Dollar AUD"
    private var outputCurrency = "Australian Dollar AUD"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val datalist = listOf(
            "Australian Dollar AUD",
            "Bangladeshi Taka BDT",
            "Bhutanese ngultrum BTN",
            "Brazilian Real BRL",
            "British Pound GBP",
            "Canadian Dollar CAD",
            "Chinese Yuan CNY",
            "Egyptian Pound EGP",
            "Euro EUR",
            "Hong Kong Dollar HKD",
            "Indian Rupee INR",
            "Indonesian Rupiah IDR",
            "Iranian Rial IRR",
            "Iraqi Dinar IQD",
            "Israeli new shekel ILS",
            "Jamaican Dollar JMD",
            "Japanese Yen JPY",
            "Malaysian ringgit MYR",
            "Maldivian rufiyaa MVR",
            "Mexican Peso MXN",
            "Nepalese Rupee NPR",
            "New Taiwan Dollar TWD",
            "New Zealand Dollar NZD",
            "Pakistani Rupee PKR",
            "Russian Ruble RUB",
            "Saudi Riyal SAR",
            "Singapore Dollar SGD",
            "South African Rand ZAR",
            "South Korean won KRW",
            "Sri Lankan rupee LKR",
            "Swiss Franc CHF",
            "Turkish Lira TRY",
            "Ukrainian hryvnia UAH",
            "United Arab Emirates Dirham AED",
            "United States dollar USD"
        )

        val Adapter = ArrayAdapter(this, android.R.layout.simple_selectable_list_item, datalist)
        Adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked)

        binding.inputCurrency.adapter = Adapter
        binding.outputCurrency.adapter = Adapter

        binding.inputCurrency.onItemSelectedListener = (object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                inputCurrency = parent?.getItemAtPosition(position).toString()
                (parent?.getChildAt(0) as TextView).setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.greenYellow
                    )
                )
                (parent.getChildAt(0) as TextView).setTextSize(15F)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })

        binding.outputCurrency.onItemSelectedListener = (object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                outputCurrency = parent?.getItemAtPosition(position).toString()
                (parent?.getChildAt(0) as TextView).setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.saddle_brown
                    )
                )
                (parent.getChildAt(0) as TextView).setTextSize(15F)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })

        val AnyToUSD = hashMapOf(
            "Australian Dollar AUD" to 0.6633,
            "Bangladeshi Taka BDT" to 0.008511,
            "Bhutanese ngultrum BTN" to 0.01191,
            "Brazilian Real BRL" to 0.183241,
            "British Pound GBP" to 1.2861,
            "Canadian Dollar CAD" to 0.729,
            "Chinese Yuan CNY" to 0.139871,
            "Egyptian Pound EGP" to 0.020259,
            "Euro EUR" to 1.1007,
            "Hong Kong Dollar HKD" to 0.128355,
            "Indian Rupee INR" to 0.011912,
            "Indonesian Rupiah IDR" to 0.000064,
            "Iranian Rial IRR" to 0.000024,
            "Iraqi Dinar IQD" to 0.000763,
            "Israeli new shekel ILS" to 0.268962,
            "Jamaican Dollar JMD" to 0.006373,
            "Japanese Yen JPY" to 0.006794,
            "Malaysian ringgit MYR" to 0.22599,
            "Maldivian rufiyaa MVR" to 0.064683,
            "Mexican Peso MXN" to 0.052762,
            "Nepalese Rupee NPR" to 0.007445,
            "New Taiwan Dollar TWD" to 0.031016,
            "New Zealand Dollar NZD" to 0.6016,
            "Pakistani Rupee PKR" to 0.003589,
            "Russian Ruble RUB" to 0.010868,
            "Saudi Riyal SAR" to 0.266361,
            "Singapore Dollar SGD" to 0.7596,
            "South African Rand ZAR" to 0.05529,
            "South Korean won KRW" to 0.000738,
            "Sri Lankan rupee LKR" to 0.003342,
            "Swiss Franc CHF" to 1.1584,
            "Turkish Lira TRY" to 0.029813,
            "Ukrainian hryvnia UAH" to 0.024171,
            "United Arab Emirates Dirham AED" to 0.272257,
            "United States dollar USD" to 1
        )
        val USDtoAny = hashMapOf(
            "Australian Dollar AUD" to 1.5058,
            "Bangladeshi Taka BDT" to 117.5,
            "Bhutanese ngultrum BTN" to 83.96,
            "Brazilian Real BRL" to 5.4573,
            "British Pound GBP" to 0.7785,
            "Canadian Dollar CAD" to 1.3708,
            "Chinese Yuan CNY" to 7.1475,
            "Egyptian Pound EGP" to 49.45,
            "Euro EUR" to 0.908513,
            "Hong Kong Dollar HKD" to 7.7909,
            "Indian Rupee INR" to 83.9485,
            "Indonesian Rupiah IDR" to 15681,
            "Iranian Rial IRR" to 42002.5,
            "Iraqi Dinar IQD" to 1310,
            "Israeli new shekel ILS" to 3.718,
            "Jamaican Dollar JMD" to 156.91,
            "Japanese Yen JPY" to 147.2,
            "Malaysian ringgit MYR" to 4.425,
            "Maldivian rufiyaa MVR" to 15.46,
            "Mexican Peso MXN" to 18.953,
            "Nepalese Rupee NPR" to 134.27,
            "New Taiwan Dollar TWD" to 32.241,
            "New Zealand Dollar NZD" to 1.662234,
            "Pakistani Rupee PKR" to 278.63,
            "Russian Ruble RUB" to 92.01,
            "Saudi Riyal SAR" to 3.7543,
            "Singapore Dollar SGD" to 1.3166,
            "South African Rand ZAR" to 18.0864,
            "South Korean won KRW" to 1360.53,
            "Sri Lankan rupee LKR" to 299.1,
            "Swiss Franc CHF" to 0.8652,
            "Turkish Lira TRY" to 33.5503,
            "Ukrainian hryvnia UAH" to 41.25,
            "United Arab Emirates Dirham AED" to 3.673,
            "United States dollar USD" to 1
        )

        binding.showButton.setOnClickListener {
            // first convert the amount in inputCurrency to usd
            val inputAmountString = binding.inputCurrencyValue.text.toString()
            if (inputAmountString.isEmpty()) {
                Toast.makeText(this, "Empty Amount !!!", Toast.LENGTH_LONG).show()
            } else {
                val inputAmount = inputAmountString.toDouble()
                val amountInUSD = inputAmount * AnyToUSD[inputCurrency]!!.toDouble()

                // then convert this amount in usd to outputCurrency
                val outputAmount = amountInUSD * (USDtoAny[outputCurrency]!!.toDouble())

                binding.outputCurrencyValue.text = outputAmount.toBigDecimal().toString()
            }
        }
    }
}