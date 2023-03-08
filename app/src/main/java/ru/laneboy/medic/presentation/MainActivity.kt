package ru.laneboy.medic.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import ru.laneboy.medic.R
import ru.laneboy.medic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        removeStatusBar()

//        ВКЛЮЧИТЬ КОГДА БУДЕТ ГОТОВО
//        launchStartScreenFragment()

        launchCreatePatientFragment()
    }

    private fun removeStatusBar() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }

    private fun launchStartScreenFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, StartScreenFragment.newInstance())
            .commit()
    }

    private fun launchCreatePatientFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, CreatePatientChartFragment.newInstance())
            .commit()
    }
}