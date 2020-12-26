package com.zxdmjr.dhakastockmarketnewsdemo.di

import android.content.Context
import com.zxdmjr.dhakastockmarketnewsdemo.data.network.middleware.ConnectivityInterceptor
import com.zxdmjr.dhakastockmarketnewsdemo.data.network.middleware.ConnectivityInterceptorImpl
import com.zxdmjr.dhakastockmarketnewsdemo.data.network.model.NewsDtoMapper
import com.zxdmjr.dhakastockmarketnewsdemo.data.network.retrofit.NewsApiService
import com.zxdmjr.dhakastockmarketnewsdemo.data.network.source.NewsDataSource
import com.zxdmjr.dhakastockmarketnewsdemo.data.network.source.NewsDataSourceImpl
import com.zxdmjr.dhakastockmarketnewsdemo.data.repositories.NewsRepository
import com.zxdmjr.dhakastockmarketnewsdemo.data.repositories.NewsRepositoryImpl
import com.zxdmjr.dhakastockmarketnewsdemo.internal.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideConnectivityInterceptor(
        @ApplicationContext context: Context
    ): ConnectivityInterceptor = ConnectivityInterceptorImpl(context)

    @Provides
    @Singleton
    fun provideRequestInterceptor(): Interceptor = Interceptor{ chain ->
        val url = chain.request()
            .url()
            .newBuilder()
            .build()
        val request = chain.request()
            .newBuilder()
            .url(url)
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .build()
        return@Interceptor chain.proceed(request)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        connectivityInterceptor: ConnectivityInterceptor,
        requestInterceptor: Interceptor
    ) = OkHttpClient.Builder()
        .addInterceptor(requestInterceptor)
        .addInterceptor(connectivityInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideNewsApiService(
        okHttpClient: OkHttpClient
    ) = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NewsApiService::class.java)

    @Provides
    @Singleton
    fun provideNewsDataSource(
        apiService: NewsApiService
    ): NewsDataSource = NewsDataSourceImpl(apiService)

    @Provides
    @Singleton
    fun provideNewsRepository(
        dataSource: NewsDataSource,
        newsDtoMapper: NewsDtoMapper
    ): NewsRepository = NewsRepositoryImpl(dataSource, newsDtoMapper)


}