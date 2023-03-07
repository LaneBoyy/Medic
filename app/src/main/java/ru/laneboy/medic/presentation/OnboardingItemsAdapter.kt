package ru.laneboy.medic.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.laneboy.medic.data.OndoardingItem
import ru.laneboy.medic.databinding.OnboardingItemContainerBinding

class OnboardingItemsAdapter(private val ondoardingItems: List<OndoardingItem>) :
    RecyclerView.Adapter<OnboardingItemsAdapter.OnboardingItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingItemViewHolder {
        val binding = OnboardingItemContainerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OnboardingItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OnboardingItemViewHolder, position: Int) {
        val onboardingItem = ondoardingItems[position]
        val binding = holder.binding
        binding.ivPictureOnBoarding.setImageResource(onboardingItem.image)
        binding.tvDescription.text = onboardingItem.description
        binding.tvTitle.text = onboardingItem.title
    }

    override fun getItemCount(): Int {
        return ondoardingItems.size
    }

    inner class OnboardingItemViewHolder(val binding: OnboardingItemContainerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindViews(ondoardingItem: OndoardingItem) {
            binding.ivPictureOnBoarding.setImageResource(ondoardingItem.image)
            binding.tvDescription.text = ondoardingItem.description
            binding.tvTitle.text = ondoardingItem.title
        }
    }
}