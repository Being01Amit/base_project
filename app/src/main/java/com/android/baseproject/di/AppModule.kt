package com.android.baseproject.di

import com.android.baseproject.data.network.APIService
import com.android.baseproject.data.repository.AnimeListRepositoryImp
import com.android.baseproject.domain.repository.AnimeListRepository
import com.android.baseproject.domain.usecases.AllAnimeListUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUseCase(repository: AnimeListRepository): AllAnimeListUseCases {
        return AllAnimeListUseCases(repository)
    }

    @Provides
    @Singleton
    fun getRepository(apiService: APIService): AnimeListRepository {
        return AnimeListRepositoryImp(apiService)
    }

    @Provides
    @Singleton
    fun provideHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request: Request =
                chain.request().newBuilder()
                    .addHeader(
                        "x-rapidapi-key",
                        "7284b34b0emshef5d0902fb1e416p1ec4f1jsn4fc428df69a0"
                    )
                    .addHeader("x-rapidapi-host", "anime-db.p.rapidapi.com").build()
            chain.proceed(request)
        }
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return httpLoggingInterceptor
    }

    @Provides
    @Singleton
    fun getAPIService(
        provideHeaderInterceptor: Interceptor,
        provideHttpLoggingInterceptor: HttpLoggingInterceptor
    ): APIService {
        val client: OkHttpClient = OkHttpClient.Builder().readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES).connectTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(provideHeaderInterceptor)
            .addInterceptor(provideHttpLoggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://anime-db.p.rapidapi.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }
}