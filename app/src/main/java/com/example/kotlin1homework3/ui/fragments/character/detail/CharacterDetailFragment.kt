package com.example.kotlin1homework3.ui.fragments.character.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.kotlin1homework3.R
import com.example.kotlin1homework3.databinding.FragmentCharacterDetailBinding
import com.example.kotlin1homework3.ui.fragments.character.CharacterViewModel

class CharacterDetailFragment : Fragment(R.layout.fragment_character_detail) {

    private val binding by viewBinding(FragmentCharacterDetailBinding::bind)
    private val viewModel by viewModels<CharacterViewModel>()
    private val args: CharacterDetailFragmentArgs by navArgs()

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() {
        viewModel.fetchCharacterId(args.position).observe(viewLifecycleOwner) { characterDetail ->
            Glide.with(binding.image)
                .load(characterDetail.image)
                .into(binding.image)
            binding.name.text = characterDetail.name
        }
    }
}