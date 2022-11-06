package cz.rimu.interestingflights.data.utils

import cz.rimu.interestingflights.data.constant.Constants.CONNECT_EXCEPTION
import cz.rimu.interestingflights.data.constant.Constants.GENERAL_ERROR
import cz.rimu.interestingflights.data.constant.Constants.SOCKET_TIME_OUT_EXCEPTION
import cz.rimu.interestingflights.data.constant.Constants.UNKNOWN_HOST_EXCEPTION
import cz.rimu.interestingflights.data.constant.Constants.UNKNOWN_NETWORK_EXCEPTION
import retrofit2.HttpException
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): cz.rimu.interestingflights.data.constant.NetworkStatus<T> {
    try {
        val response = call.invoke()
        if (response.isSuccessful) {
            if (response.body() != null) {
                return cz.rimu.interestingflights.data.constant.NetworkStatus.Success(response.body())
            }
        }
        return cz.rimu.interestingflights.data.constant.NetworkStatus.Error(response.message())
    } catch (e: Exception) {
        return when (e) {
            is ConnectException -> {
                cz.rimu.interestingflights.data.constant.NetworkStatus.Error(CONNECT_EXCEPTION, e)
            }
            is UnknownHostException -> {
                cz.rimu.interestingflights.data.constant.NetworkStatus.Error(UNKNOWN_HOST_EXCEPTION, e)
            }
            is SocketTimeoutException -> {
                cz.rimu.interestingflights.data.constant.NetworkStatus.Error(SOCKET_TIME_OUT_EXCEPTION, e)
            }
            is HttpException -> {
                cz.rimu.interestingflights.data.constant.NetworkStatus.Error(UNKNOWN_NETWORK_EXCEPTION, e)
            }
            else -> {
                cz.rimu.interestingflights.data.constant.NetworkStatus.Error(GENERAL_ERROR, e)
            }
        }
    }
}
