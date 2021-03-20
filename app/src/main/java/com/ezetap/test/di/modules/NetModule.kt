package com.ezetap.test.di.modules

import com.ezetap.test.BuildConfig
import com.ezetap.test.data.customUi.CustomUiApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Dagger module for network ops
 */
@Module
class NetModule {

    @Module
    companion object {

        /**
         * Provide logging interceptor
         */
        @JvmStatic
        @Singleton
        @Provides
        fun provideLoggingInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            }

        /**
         * Provide OkHttp
         */
        @JvmStatic
        @Singleton
        @Provides
        fun provideOkHttp(
            loggingInterceptor: HttpLoggingInterceptor
        ): OkHttpClient =
            OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build()

        /**
         * Provide Retrofit
         */
        @Singleton
        @JvmStatic
        @Provides
        fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_API_URL)
                .addConverterFactory(
                    MoshiConverterFactory.create(
                        Moshi.Builder()
                            .add(KotlinJsonAdapterFactory())
                            .build()
                    )
                )
                .client(okHttpClient)
                .build()


        /**
         * Create [CustomUiApi]
         */
        @JvmStatic
        @Provides
        fun provideCustomUiApi(retrofit: Retrofit): CustomUiApi = CustomUiApi.create(retrofit)

    }
}
