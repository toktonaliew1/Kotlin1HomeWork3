package com.example.kotlin1homework3.ui.fragments.location

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin1homework3.R
import com.example.kotlin1homework3.databinding.FragmentLocationBinding
import com.example.kotlin1homework3.ui.adapters.LocationAdapter
import kotlinx.coroutines.launch

class LocationFragment : Fragment(R.layout.fragment_location) {

    private val binding by viewBinding(FragmentLocationBinding::bind)
    private val viewModel by viewModels<LocationViewModel>()
    private val locationAdapter = LocationAdapter(
        this::onItemClick
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setupObserve()
    }

    private fun init() = with(binding.locationRecView) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = locationAdapter
    }

    private fun setupObserve() {

        viewModel.fetchLocations().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                locationAdapter.submitData(it)
            }
        }
    }

    private fun isNetwork(): Boolean {
        val connectivityManager: ConnectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected

    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(
            LocationFragmentDirections.actionLocationsFragmentToLocationDetailFragment(
                position = id
            )
        )
    }
}