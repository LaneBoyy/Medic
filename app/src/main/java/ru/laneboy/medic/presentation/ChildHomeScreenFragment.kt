package ru.laneboy.medic.presentation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import ru.laneboy.medic.R
import ru.laneboy.medic.databinding.FragmentChildHomeScreenBinding
import ru.laneboy.medic.databinding.FragmentOnboardingScreenBinding

class ChildHomeScreenFragment : Fragment() {

    private var _binding: FragmentChildHomeScreenBinding? = null
    private val binding: FragmentChildHomeScreenBinding
        get() = _binding ?: throw RuntimeException("FragmentChildHomeScreenBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChildHomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance() = ChildHomeScreenFragment()
    }
}