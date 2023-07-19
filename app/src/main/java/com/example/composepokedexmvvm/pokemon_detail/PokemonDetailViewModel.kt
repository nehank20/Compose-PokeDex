package com.example.composepokedexmvvm.pokemon_detail

import androidx.lifecycle.ViewModel
import com.example.composepokedexmvvm.data.remote.response.Pokemon
import com.example.composepokedexmvvm.repository.PokemonRepository
import com.example.composepokedexmvvm.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repo: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repo.getPokemonInfo(pokemonName)
    }

}