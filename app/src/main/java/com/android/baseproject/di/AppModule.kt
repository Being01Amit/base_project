package com.android.baseproject.di

import com.android.baseproject.data.datasource.GetAnimeListSource
import com.android.baseproject.data.network.APIService
import com.android.baseproject.data.repository.AnimeListRepositoryImp
import com.android.baseproject.domain.repository.AnimeListRepository
import com.android.baseproject.domain.usecases.AllAnimeListUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUseCase(repository: AnimeListRepository) : AllAnimeListUseCases {
        return AllAnimeListUseCases(repository)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(apiService: APIService) : GetAnimeListSource {
        return GetAnimeListSource(apiService)
    }

    @Provides
    @Singleton
    fun getRepository(getAnimeListSource: GetAnimeListSource):AnimeListRepository{
        return AnimeListRepositoryImp(getAnimeListSource)
    }

    @Provides
    @Singleton
    fun getAPIService(): APIService {
        val client: OkHttpClient = OkHttpClient.Builder().readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES).connectTimeout(1, TimeUnit.MINUTES)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://anime-db.p.rapidapi.com")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }

}