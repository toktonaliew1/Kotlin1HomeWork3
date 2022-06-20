package com.example.kotlin1homework3.ui.fragments.episode.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin1homework3.R
import com.example.kotlin1homework3.databinding.FragmentEpisodeDetailBinding
import com.example.kotlin1homework3.ui.fragments.episode.EpisodeViewModel

class EpisodeDetailFragment : Fragment(R.layout.fragment_episode_detail) {

    private val binding by viewBinding(FragmentEpisodeDetailBinding::bind)
    private val viewModel by viewModels<EpisodeViewModel> ()
    private val args: EpisodeDetailFragmentArgs by navArgs()

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() {
        viewModel.fetchEpisodeId(args.position).observe(viewLifecycleOwner) { episodeDetail ->
            binding.name.text = episodeDetail.name
            binding.airDate.text = episodeDetail.air_date
            binding.episode.text = episodeDetail.air_date
        }
    }
}