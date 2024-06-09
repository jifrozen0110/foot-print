package com.foot.stamp.error.dto

import java.time.LocalDateTime

data class ErrorResponse(
    var code: Int? = 1000,
    var errorMessage: String? = "서버 내부 오류",
    var httpStatus: Int? = 500,
    var timeStamp: LocalDateTime? = LocalDateTime.now(),
) {
    companion object {
        fun of(errorData: ErrorData?): ErrorResponse {
            return ErrorResponse(
                code = errorData?.code,
                errorMessage = errorData?.errorMessage,
                httpStatus = errorData?.httpStatus,
                timeStamp = LocalDateTime.now(),
            )
        }
    }
}
