package cz.rimu.interestingflights.data.utils

import cz.rimu.interestingflights.data.constant.CONNECT_EXCEPTION
import cz.rimu.interestingflights.data.constant.GENERAL_ERROR
import cz.rimu.interestingflights.data.constant.NetworkStatus
import cz.rimu.interestingflights.data.constant.SOCKET_TIME_OUT_EXCEPTION
import cz.rimu.interestingflights.data.constant.UNKNOWN_HOST_EXCEPTION
import cz.rimu.interestingflights.data.constant.UNKNOWN_NETWORK_EXCEPTION
import retrofit2.HttpException
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): NetworkStatus<T> {
    try {
        val response = call.invoke()
        if (response.isSuccessful) {
            if (response.body() != null) {
                return NetworkStatus.Success(response.body())
            }
        }
        return NetworkStatus.Error(response.message())
    } catch (e: Exception) {
        return when (e) {
            is ConnectException -> {
                NetworkStatus.Error(CONNECT_EXCEPTION, e)
            }
            is UnknownHostException -> {
                NetworkStatus.Error(UNKNOWN_HOST_EXCEPTION, e)
            }
            is SocketTimeoutException -> {
                NetworkStatus.Error(SOCKET_TIME_OUT_EXCEPTION, e)
            }
            is HttpException -> {
                NetworkStatus.Error(UNKNOWN_NETWORK_EXCEPTION, e)
            }
            else -> {
                NetworkStatus.Error(GENERAL_ERROR, e)
            }
        }
    }
}
