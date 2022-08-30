package cz.arokip.publicholiday.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import cz.arokip.publicholiday.common.Constants
import cz.arokip.publicholiday.data.remote.PublicHolidaysApi
import cz.arokip.publicholiday.data.repository.PublicHolidaysRepositoryImpl
import cz.arokip.publicholiday.domain.repository.PublicHolidaysRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun providePublicHolidaysApi(): PublicHolidaysApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(PublicHolidaysApi::class.java)
    }

    @Provides
    @Singleton
    fun providePublicHolidayRepository(api: PublicHolidaysApi): PublicHolidaysRepository {
        return PublicHolidaysRepositoryImpl(api)
    }
}