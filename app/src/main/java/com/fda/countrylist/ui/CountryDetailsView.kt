package com.fda.countrylist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fda.countrylist.R
import com.fda.countrylist.data.base.BaseFragment
import com.fda.countrylist.data.model.business.Country
import com.fda.countrylist.databinding.FragmentCountryDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.format
import java.lang.Exception
import java.text.DecimalFormat

@AndroidEntryPoint
class CountryDetailsView : BaseFragment() {

    private lateinit var binding: FragmentCountryDetailsBinding

    private val args: CountryDetailsViewArgs by navArgs()

    private lateinit var country: Country

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_country_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        country = args.country
        setupCountryDetailsUi(country)
    }

    private fun setupCountryDetailsUi(country: Country) {
        binding.apply {
            ivBack.setOnClickListener { activity?.onBackPressed() }
            tvCountryName.text = country.commonName
            Glide.with(requireContext())
                .load(country.flagPngUrl)
                .apply(RequestOptions().error(R.drawable.flag_not_found))
                .placeholder(R.drawable.ic_image_loading)
                .into(ivCountryFlag)
            Glide.with(requireContext())
                .load(country.coatOfArmsPngUrl)
                .apply(RequestOptions().error(R.drawable.flag_not_found))
                .placeholder(R.drawable.ic_image_loading)
                .into(ivCoatOfArms)
            tvIndependentStatusValue.text = when (country.isIndependent) {
                true -> getString(R.string.independent)
                false -> getString(R.string.not_independent)
                else -> ""
            }
            tvStatusValue.text = country.status
            tvCapitalValue.text = country.capital?.joinToString(separator = ",") { it }
            tvRegionValue.text = country.region
            tvSubregionValue.text = country.subregion
            tvLatlngValue.text = country.latlng.toString()
            tvAreaValue.text = country.area.toString()
            val formatter = DecimalFormat("#,###")
            try {
                tvPopulationValue.text = formatter.format(country.population).toString()
            } catch (e: Exception) {
                tvPopulationValue.text = ""
            }
        }
    }
}