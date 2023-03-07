package ru.laneboy.medic.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.laneboy.medic.R
import ru.laneboy.medic.data.OndoardingItem

class OnboardingItemsAdapter(private val ondoardingItems: List<OndoardingItem>) :
    RecyclerView.Adapter<OnboardingItemsAdapter.OnboardingItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingItemViewHolder {
        return OnboardingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.onboarding_item_container,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnboardingItemViewHolder, position: Int) {
        holder.bindViews(ondoardingItems[position])
    }

    override fun getItemCount(): Int {
        return ondoardingItems.size
    }

    inner class OnboardingItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val textViewTitle = view.findViewById<TextView>(R.id.tv_title)
        private val textViewDescription = view.findViewById<TextView>(R.id.tv_description)
        private val imageViewPicture = view.findViewById<ImageView>(R.id.iv_picture_onBoarding)

        fun bindViews(ondoardingItem: OndoardingItem) {
            textViewTitle.text = ondoardingItem.title
            textViewDescription.text = ondoardingItem.description
            imageViewPicture.setImageResource(ondoardingItem.image)
        }
    }
}