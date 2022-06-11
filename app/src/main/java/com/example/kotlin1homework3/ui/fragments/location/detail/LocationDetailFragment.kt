package com.example.kotlin1homework3.ui.fragments.location.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin1homework3.R
import com.example.kotlin1homework3.databinding.FragmentLocationDetailBinding
import com.example.kotlin1homework3.ui.fragments.location.LocationSharedViewModel

class LocationDetailFragment : Fragment(R.layout.fragment_location_detail) {

    private val binding by viewBinding(FragmentLocationDetailBinding::bind)
    private val viewModel : LocationSharedViewModel by activityViewModels()
    private val args: LocationDetailFragmentArgs by navArgs()

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() {
        viewModel.fetchLocationId(args.position).observe(viewLifecycleOwner) { locationDetails ->
            binding.name.text = locationDetails.name
            binding.direction.text = locationDetails.dimension
        }
    }
}