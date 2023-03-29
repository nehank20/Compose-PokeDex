package com.example.composepokedexmvvm.di

import android.app.Application
import com.example.composepokedexmvvm.data.remote.PokeApi
import com.example.composepokedexmvvm.repository.PokemonRepository
import com.example.composepokedexmvvm.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule : Application() {

    @Singleton
    @Provides
    fun providePokemonRepository(
        api : PokeApi
    )  = PokemonRepository(api)


    @Singleton
    @Provides
    fun providePokeApi() : PokeApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(PokeApi::class.java)
    }

}