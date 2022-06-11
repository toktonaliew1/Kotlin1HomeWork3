package com.example.kotlin1homework3.ui.fragments.character

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.kotlin1homework3.databinding.FragmentCharacterBinding
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin1homework3.R
import com.example.kotlin1homework3.ui.adapters.CharacterAdapter

class CharacterFragment : Fragment(R.layout.fragment_character) {

    private val binding by viewBinding(FragmentCharacterBinding::bind)
    private val viewModel : CharacterSharedViewModel by activityViewModels()

    private val characterAdapter = CharacterAdapter(
        this::onItemClick
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setupObserve()
    }

    private fun init() = with(binding.characterRecView) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = characterAdapter
    }

    private fun setupObserve() {
        viewModel.fetchCharacters().observe(viewLifecycleOwner) { character ->
            characterAdapter.submitList(character.results)
        }
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(
            CharacterFragmentDirections.actionCharactersFragmentToCharacterDetailsFragment(
                position = id
            )
        )
    }
}
