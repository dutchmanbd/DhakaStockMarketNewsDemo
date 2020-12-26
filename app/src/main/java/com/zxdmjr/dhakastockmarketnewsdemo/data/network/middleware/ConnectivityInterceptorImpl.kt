package com.zxdmjr.dhakastockmarketnewsdemo.data.network.middleware

import android.content.Context
import com.zxdmjr.dhakastockmarketnewsdemo.internal.ConnectivityException
import com.zxdmjr.dhakastockmarketnewsdemo.internal.NetworkUtils.isOnline
import okhttp3.Interceptor
import okhttp3.Response

class ConnectivityInterceptorImpl(
    context: Context
) : ConnectivityInterceptor {
    private val appContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isOnline(appContext))
            throw ConnectivityException("Please connect wifi or data")
        return chain.proceed(chain.request())
    }

}