package com.example.kotlin1homework3.ui.fragments.episode

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
import com.example.kotlin1homework3.databinding.FragmentEpisodeBinding
import com.example.kotlin1homework3.ui.adapters.EpisodeAdapter
import kotlinx.coroutines.launch

class EpisodeFragment : Fragment(R.layout.fragment_episode) {

    private val binding by viewBinding(FragmentEpisodeBinding::bind)
    private val viewModel by viewModels<EpisodeViewModel> ()
    private val episodeAdapter = EpisodeAdapter(
        this::onItemClick
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setupObserve()
    }

    private fun init() = with(binding.episodeRecView) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = episodeAdapter
    }

    private fun setupObserve() {
            viewModel.fetchEpisodes().observe(viewLifecycleOwner) {
                lifecycleScope.launch {
                    episodeAdapter.submitData(it)
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
            EpisodeFragmentDirections.actionEpisodesFragmentToEpisodeDetailFragment(
                position = id
            )
        )
    }
}