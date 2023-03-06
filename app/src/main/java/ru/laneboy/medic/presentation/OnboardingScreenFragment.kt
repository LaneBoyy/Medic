package ru.laneboy.medic.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import ru.laneboy.medic.R
import ru.laneboy.medic.data.OndoardingItem

class OnboardingScreenFragment : Fragment() {

    private lateinit var onboardingItemsAdapter: OnboardingItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnboardingItems()
    }

    private fun setOnboardingItems() {
        onboardingItemsAdapter = OnboardingItemsAdapter(
            listOf(
                OndoardingItem(
                    getString(R.string.text_analyzes),
                    getString(R.string.text_analyzes_description)
                ),
                OndoardingItem(
                    getString(R.string.text_notifications),
                    getString(R.string.text_notifications_description)
                ),
                OndoardingItem(
                    getString(R.string.text_monitoring),
                    getString(R.string.text_monitoring_description)
                )
            )
        )
        val onboardingViewPager = requireActivity().findViewById<ViewPager2>(R.id.onboardingViewPager)
        onboardingViewPager.adapter = onboardingItemsAdapter
    }

    companion object {
        fun newInstance() = OnboardingScreenFragment()
    }
}