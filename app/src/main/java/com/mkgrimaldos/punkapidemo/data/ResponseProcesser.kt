package com.mkgrimaldos.punkapidemo.data

import com.mkgrimaldos.punkapidemo.domain.Result
import retrofit2.Response

class ResponseProcesser {
    companion object {
        suspend fun <T, U> processResponse(
            call: suspend () -> Response<T>,
            convert: suspend (T?) -> U
        ): Result<U> {
            return try {
                val response = call.invoke()
                Result.Success(convert(response.body()))
            } catch (throwable: Throwable) {
                throwable.printStackTrace()
                return manageThrowable(throwable)
            }
        }

        private fun <T> manageThrowable(throwable: Throwable): Result<T> {
            return Result.Error(throwable.message.toString())
        }
    }
}
