package ru.laneboy.medic.presentation

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.laneboy.medic.R
import ru.laneboy.medic.databinding.FragmentEmailBinding
import java.util.*

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
        runTimer()
    }

    private fun setOnPinEnteredListener() {
        binding.txtPinEntry.setOnPinEnteredListener { str ->
            if (str.toString() == "1234") {
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
            .replace(R.id.fragment_container, CreatePasswordFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    private fun runTimer() {
        var seconds = SECONDS
        val handler = Handler()
        val textViewTimer = requireActivity().findViewById<TextView>(R.id.tv_timer)
        handler.post(object : Runnable {
            override fun run() {
                val secs = seconds
                val time = String.format(Locale.getDefault(), getString(R.string.text_timer), secs)
                textViewTimer.text = time
                seconds--
                if (seconds == 0) {
                    seconds = SECONDS
                }
                handler.postDelayed(this, 1000)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val SECONDS = 59

        fun newInstance() = EmailFragment()
    }
}