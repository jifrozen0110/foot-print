package com.foot.stamp.error.dto

data class ErrorData(
    var code: Int,
    var errorMessage: String,
    var httpStatus: Int,
) {
    companion object {
        fun of(
            code: Int,
            errorMessage: String,
            httpStatus: Int,
        ): ErrorData = ErrorData(code, errorMessage, httpStatus)
    }
}
