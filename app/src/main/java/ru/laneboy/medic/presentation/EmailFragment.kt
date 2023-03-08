package ru.laneboy.medic.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.laneboy.medic.R
import ru.laneboy.medic.databinding.FragmentEmailBinding

class EmailFragment : Fragment() {

    private var _binding: FragmentEmailBinding? = null
    private val binding: FragmentEmailBinding
        get() = _binding ?: throw RuntimeException("FragmentEmailBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnPinEnteredListener()

        lifecycleScope.launch(Dispatchers.Main) {
            runTimer()
        }
    }

    private fun setOnPinEnteredListener() {
        binding.txtPinEntry.setOnPinEnteredListener { str ->
            if (str.toString() == "1111") {
                launchCreatePasswordFragment()
            } else {
                Toast.makeText(requireContext(), "Введен неверный код", Toast.LENGTH_SHORT)
                    .show()
                binding.txtPinEntry.text = null
            }
        }
    }

    private fun launchCreatePasswordFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, CreatePatientChartFragment.newInstance())
            .commit()
    }

    private suspend fun runTimer() {
        for (i in SECONDS downTo 1) {
            binding.tvTimer.text = String.format(getString(R.string.text_timer), i)
            delay(1000)
        }
        binding.tvTimer.text = SECONDS.toString()
        runTimer()
    }

    override fun onDetach() {
        super.onDetach()
        _binding = null
    }

    companion object {

        const val SECONDS = 59

        fun newInstance() = EmailFragment()
    }
}