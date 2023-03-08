package ru.laneboy.medic.presentation

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import ru.laneboy.medic.R
import ru.laneboy.medic.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding: FragmentSignInBinding
        get() = _binding ?: throw RuntimeException("FragmentSignInBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etEmail.addTextChangedListener {
            binding.btnNext.isEnabled = it != null && it.toString().isEmailValid()
        }
        binding.btnNext.setOnClickListener {
            launchEmailFragment()
        }
    }

    private fun launchEmailFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, EmailFragment.newInstance())
            .addToBackStack(null)
            .commit()

    }

    private fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this)
                && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = SignInFragment()
    }
}
