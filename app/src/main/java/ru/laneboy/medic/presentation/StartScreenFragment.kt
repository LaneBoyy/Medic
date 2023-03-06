package ru.laneboy.medic.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.laneboy.medic.R

class StartScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start_screen, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            launchOnboardingScreenFragment()
        }
    }

    private suspend fun launchOnboardingScreenFragment() {
        delay(2000)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, OnboardingScreenFragment.newInstance())
            .commit()
    }

    companion object {
        fun newInstance() = StartScreenFragment()
    }
}