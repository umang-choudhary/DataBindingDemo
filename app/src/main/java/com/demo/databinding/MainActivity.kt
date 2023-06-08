package com.demo.databinding

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.demo.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var employee: Employee

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
        employee = provideEmployee()
        binding.employee = employee

        val clickHandlers = ClickHandlers(employee)
        binding.clickHandlers = clickHandlers
    }

    private fun provideEmployee(): Employee {
        return Employee().apply {
            name = "Umang"
            email = "Umang@gmail.com"
        }
    }

    class ClickHandlers(private val employee: Employee) {
        fun onClickChangeData(view: View) {
            employee.name = "Bhavish"
            employee.email = "Bhavish@gmail.com"
        }
    }
}