package ru.laneboy.medic.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.laneboy.medic.data.OnboardingItem
import ru.laneboy.medic.databinding.OnboardingItemContainerBinding

class OnboardingItemsAdapter(private val onboardingItems: List<OnboardingItem>) :
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
        val onboardingItem = onboardingItems[position]
        val binding = holder.binding
        binding.ivPictureOnBoarding.setImageResource(onboardingItem.image)
        binding.tvDescription.text = onboardingItem.description
        binding.tvTitle.text = onboardingItem.title
    }

    override fun getItemCount(): Int {
        return onboardingItems.size
    }

    inner class OnboardingItemViewHolder(val binding: OnboardingItemContainerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindViews(onboardingItem: OnboardingItem) {
            binding.ivPictureOnBoarding.setImageResource(onboardingItem.image)
            binding.tvDescription.text = onboardingItem.description
            binding.tvTitle.text = onboardingItem.title
        }
    }
}