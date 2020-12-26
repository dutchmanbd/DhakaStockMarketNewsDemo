package com.zxdmjr.dhakastockmarketnewsdemo.di

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApplication(
        @ApplicationContext context: Context
    ) = context.applicationContext

    @Provides
    @Singleton
    fun provideGson() = Gson()
}