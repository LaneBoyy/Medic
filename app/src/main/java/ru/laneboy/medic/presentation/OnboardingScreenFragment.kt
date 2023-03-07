package ru.laneboy.medic.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import ru.laneboy.medic.R
import ru.laneboy.medic.SignInFragment
import ru.laneboy.medic.data.OndoardingItem
import ru.laneboy.medic.databinding.FragmentOnboardingScreenBinding

class OnboardingScreenFragment : Fragment() {

    private var _binding: FragmentOnboardingScreenBinding? = null
    private val binding: FragmentOnboardingScreenBinding
        get() = _binding ?: throw RuntimeException("FragmentOnboardingScreenBinding == null")

    private lateinit var onboardingItemsAdapter: OnboardingItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnboardingItems()
        setupIndicators()
        finishOnboarding()
    }

    private fun finishOnboarding() {
        binding.buttonFinishOnBoarding.setOnClickListener {
            launchSignInFragment()
        }
    }

    private fun launchSignInFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SignInFragment.newInstance())
            .commit()
    }

    private fun setOnboardingItems() {
        onboardingItemsAdapter = OnboardingItemsAdapter(
            listOf(
                OndoardingItem(
                    getString(R.string.text_analyzes),
                    getString(R.string.text_analyzes_description),
                    R.drawable.ic_analyzes_picture
                ),
                OndoardingItem(
                    getString(R.string.text_notifications),
                    getString(R.string.text_notifications_description),
                    R.drawable.ic_notifications_picture
                ),
                OndoardingItem(
                    getString(R.string.text_monitoring),
                    getString(R.string.text_monitoring_description),
                    R.drawable.ic_monitoring_picture
                )
            )
        )
        setupAdapterAndScroll()
    }

    private fun setupAdapterAndScroll() {
        with(binding.onboardingViewPager) {
            adapter = onboardingItemsAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    setCurrentIndicators(position)
                }
            })
        }
        (binding.onboardingViewPager.getChildAt(0) as RecyclerView).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER
    }

    private fun setupIndicators() {
        val indicators = arrayOfNulls<ImageView>(onboardingItemsAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(12, 0, 12, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(requireContext().applicationContext)
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext().applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
                it.layoutParams = layoutParams
                binding.indicatorsContainer.addView(it)
            }
        }
    }

    private fun setCurrentIndicators(position: Int) {
        val childCount = binding.indicatorsContainer.childCount
        for (i in 0 until childCount) {
            val imageView = binding.indicatorsContainer.getChildAt(i) as ImageView
            if (i == position) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext().applicationContext,
                        R.drawable.indicator_active_background
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext().applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = OnboardingScreenFragment()
    }
}