package com.zxdmjr.dhakastockmarketnewsdemo.internal

import com.zxdmjr.material_utils.Resource
import org.json.JSONException
import retrofit2.Response

abstract class SafeApiRequest {

    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): Resource<T> {
        return try {
            val response = call.invoke()
            if (response.isSuccessful) {
                if (response.body() != null) {
                    Resource.Success(response.body()!!)
                } else {
                    Resource.Failed(null, Constant.ERROR_UNKNOWN)
                }
            } else {
                val errorBody = response.errorBody()
                if(errorBody != null){
                    Resource.Failed(errorBody, "")
                } else{
                    Resource.Failed(null, response.message())
                }
            }
        } catch (e: JSONException){
            Resource.Failed(null, e.message ?: Constant.ERROR_UNKNOWN)
        } catch (e: Exception){
            Resource.Failed(null, e.message ?: Constant.ERROR_UNKNOWN)
        } catch (e: ConnectivityException){
            Resource.Failed(null, e.message ?: Constant.ERROR_UNKNOWN)
        }

    }
}