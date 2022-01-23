package com.fda.countrylist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fda.countrylist.data.base.BaseFragment
import com.fda.countrylist.data.common.data.Status
import com.fda.countrylist.data.common.utils.hideKeyboard
import com.fda.countrylist.data.model.business.Country
import com.fda.countrylist.databinding.FragmentCountryListBinding
import com.fda.countrylist.vm.CountryViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.fda.countrylist.R
import com.fda.countrylist.R.*
import com.fda.countrylist.data.common.data.Resource
import com.fda.countrylist.data.common.utils.queryCountryAndSortCountryListByAscending


@AndroidEntryPoint
class CountryListView : BaseFragment(), OnViewCountryDetails {

    private val countryViewModel: CountryViewModel by viewModels()

    private lateinit var binding: FragmentCountryListBinding

    private lateinit var countryListAdapter: CountryListAdapter

    private var originalCountryList: List<Country> = listOf()

    private var displayedCountryList: List<Country> = listOf()

    private var stringQuery: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_country_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
        setupObserver()
        setupSearchView()
    }

    private fun setupSearchView() {
        binding.countrySearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextChange(qString: String): Boolean {
                stringQuery = qString
                if (qString.isEmpty()) {
                    countryListAdapter.updateData(originalCountryList)
                } else {
                    displayedCountryList =
                        queryCountryAndSortCountryListByAscending(
                            qString,
                            originalCountryList
                        )
                    countryListAdapter.updateData(displayedCountryList)
                }
                return true
            }

            override fun onQueryTextSubmit(qString: String): Boolean {
                hideKeyboard()
                return true
            }
        })
    }

    private fun setupUi() {
        countryListAdapter =
            CountryListAdapter(
                listOf(),
                this,
                requireContext()
            )
        binding.run {
            clSomethingWentWrong.btnRetry.setOnClickListener { countryViewModel.fetchCountryList() }
            rvCountryList.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = countryListAdapter
            }
        }
    }

    private fun setupObserver() {
        countryViewModel.countryList.observe(viewLifecycleOwner, {
            it?.let {
                when (it.status) {
                    Status.SUCCESS -> {
                        displaySuccessState(it)
                    }
                    Status.LOADING -> {
                        displayLoadingState()
                    }
                    Status.GENERIC_ERROR, Status.NETWORK_ERROR, Status.IO_ERROR -> {
                        displayErrorState()
                    }
                }
            }
        })
    }

    private fun displaySuccessState(it: Resource<List<Country>>) {
        it.data?.let { data ->
            originalCountryList = data
        }
        displayedCountryList = if (stringQuery.isEmpty()) {
            originalCountryList
        } else {
            queryCountryAndSortCountryListByAscending(
                stringQuery,
                originalCountryList
            )
        }
        countryListAdapter.updateData(displayedCountryList)
        binding.apply {
            groupMain.visibility = View.VISIBLE
            lavLoading.visibility = View.GONE
            rvCountryList.visibility = View.VISIBLE
            clSomethingWentWrong.root.visibility = View.GONE
        }
    }

    private fun displayErrorState() {
        binding.apply {
            lavLoading.visibility = View.GONE
            lavLoading.pauseAnimation()
            groupMain.visibility = View.GONE
            clSomethingWentWrong.root.visibility = View.VISIBLE
        }
    }

    private fun displayLoadingState() {
        binding.apply {
            lavLoading.visibility = View.VISIBLE
            lavLoading.playAnimation()
            groupMain.visibility = View.GONE
            clSomethingWentWrong.root.visibility = View.GONE
        }
    }

    override fun onViewCountryDetails(country: Country) {
        val action =
            CountryListViewDirections.actionCountryListViewToCountryDetailsView(
                country
            )
        findNavController().navigate(action)
    }

}