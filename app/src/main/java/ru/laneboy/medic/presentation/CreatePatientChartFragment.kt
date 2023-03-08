package ru.laneboy.medic.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ru.laneboy.medic.R
import ru.laneboy.medic.databinding.FragmentCreatePatientChartBinding

class CreatePatientChartFragment : Fragment() {

    private var _binding: FragmentCreatePatientChartBinding? = null
    private val binding: FragmentCreatePatientChartBinding
        get() = _binding ?: throw RuntimeException("FragmentCreatePatientChartBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreatePatientChartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickOnButtonCreate()
        clickOnButtonSkip()
    }

    private fun editTextValidation() {
        if (
            binding.etName.text.isEmpty() &&
            binding.etSecondName.text.isEmpty() &&
            binding.etSurname.text.isEmpty() &&
            binding.etDateOfBth.text.isEmpty() &&
            binding.etMale.text.isEmpty()
        ) {
            Toast.makeText(activity, "Все поля должны быть заполнены", Toast.LENGTH_SHORT)
                .show()
        } else {
            launchAnalyzesMainScreenFragment()
        }
    }

    private fun clickOnButtonCreate() {
        binding.btnCreate.setOnClickListener {
            editTextValidation()
        }
    }

    private fun clickOnButtonSkip() {
        binding.btnSkip.setOnClickListener {
            launchAnalyzesMainScreenFragment()
        }
    }

    private fun launchAnalyzesMainScreenFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, AnalyzesMainScreenFragment.newInstance())
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance() = CreatePatientChartFragment()
    }
}