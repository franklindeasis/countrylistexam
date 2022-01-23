package com.fda.countrylist.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fda.countrylist.R
import com.fda.countrylist.data.model.business.Country
import com.fda.countrylist.databinding.ItemCountryBinding

class CountryListAdapter(
    private var countryList: List<Country>,
    private val onViewCountryDetails: OnViewCountryDetails,
    private val context: Context
) :
    RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    inner class CountryViewHolder(val binding: ItemCountryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Country) {
            with(binding) {
                tvCountryName.text = item.commonName
                Glide.with(context)
                    .load(item.flagPngUrl)
                    .apply(RequestOptions().error(R.drawable.flag_not_found))
                    .placeholder(R.drawable.ic_image_loading)
                    .into(binding.ivCountryFlag)
            }
            binding.root.setOnClickListener {
                onViewCountryDetails.onViewCountryDetails(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCountryBinding.inflate(layoutInflater, parent, false)

        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) =
        holder.bind(countryList.get(position))

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun updateData(countryList: List<Country>) {
        countryList.let {
            this.countryList = it
        }
        notifyDataSetChanged()
    }

}