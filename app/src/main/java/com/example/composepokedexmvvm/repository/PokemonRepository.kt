package com.example.composepokedexmvvm.repository

import com.example.composepokedexmvvm.data.remote.PokeApi
import com.example.composepokedexmvvm.data.remote.response.Pokemon
import com.example.composepokedexmvvm.data.remote.response.PokemonList
import com.example.composepokedexmvvm.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api : PokeApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int) : Resource<PokemonList> {
        val response = try{
            api.getPokemonList(limit = limit, offset = offset)
        }catch (ex: Exception) {
            return Resource.Error("Unknown error occurred ${ex.message}")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName : String) : Resource<Pokemon> {
        val response = try{
            api.getPokemonInfo(name = pokemonName)
        }catch (ex: Exception) {
            return Resource.Error("Unknown error occurred")
        }
        return Resource.Success(response)
    }
}