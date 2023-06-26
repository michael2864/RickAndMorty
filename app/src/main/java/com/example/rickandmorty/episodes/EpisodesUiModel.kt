package com.example.rickandmorty.episodes

import com.example.rickandmorty.domain.models.Episode

sealed class EpisodesUiModel {
    class Item(val episode: Episode): EpisodesUiModel()
    class Header(val text: String): EpisodesUiModel()
}