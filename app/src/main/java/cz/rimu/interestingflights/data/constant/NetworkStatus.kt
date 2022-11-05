package cz.rimu.interestingflights.data.constant

sealed class NetworkStatus<T>(
    val data: T? = null,
    val errorMessage: String? = null,
    val error: Throwable? = null
) {
    class Success<T>(data: T?) : NetworkStatus<T>(data)
    class Error<T>(errorMessage: String?, error: Throwable? = null) :
        NetworkStatus<T>(errorMessage = errorMessage, error = error)
}