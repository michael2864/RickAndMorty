package com.example.rickandmorty.characters.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.rickandmorty.BaseFragment
import com.example.rickandmorty.NavGraphDirections
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentCharacterDetailBinding

class CharacterDetailFragment : BaseFragment(R.layout.fragment_character_detail) {

    private var _binding: FragmentCharacterDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CharacterDetailViewModel by viewModels()
    private val safeArgs: CharacterDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCharacterDetailBinding.bind(view)

        val epoxyController = CharacterDetailsEpoxyController { episodeClickedId ->
            val navDirections = NavGraphDirections.actionGlobalToEpisodeDetailBottomSheetFragment(
                episodeId = episodeClickedId
            )
            findNavController().navigate(navDirections)
        }
        viewModel.characterByIdLiveData.observe(viewLifecycleOwner) { character ->

            epoxyController.character = character

            if (character == null) {
                Toast.makeText(
                    requireActivity(),
                    "Unsuccessful network call!",
                    Toast.LENGTH_SHORT
                ).show()
                findNavController().navigateUp()
                return@observe
            }
        }

        viewModel.fetchCharacter(characterId = safeArgs.characterId)

        binding.epoxyRecyclerView.setControllerAndBuildModels(epoxyController)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}