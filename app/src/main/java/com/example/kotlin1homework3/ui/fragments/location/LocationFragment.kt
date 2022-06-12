package com.example.kotlin1homework3.ui.fragments.location

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin1homework3.R
import com.example.kotlin1homework3.databinding.FragmentLocationBinding
import com.example.kotlin1homework3.ui.adapters.LocationAdapter

class LocationFragment : Fragment(R.layout.fragment_location) {

    private val binding by viewBinding(FragmentLocationBinding::bind)
    private val viewModel by viewModels<LocationSharedViewModel>()
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
        viewModel.fetchLocation().observe(viewLifecycleOwner){ character ->
            locationAdapter.submitList(character.results)
        }
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(
            LocationFragmentDirections.actionLocationsFragmentToLocationDetailFragment(
                position = id
            )
        )
    }
}