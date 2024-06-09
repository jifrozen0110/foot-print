package com.foot.stamp.error.code

import com.foot.stamp.error.dto.ErrorData

enum class GlobalErrorCode(private val httpStatus: Int, private val code: Int, private val errorMessage: String) :
    ErrorCode {
    INTERNAL_SERVER_ERROR(500, 10000, "서버 내부 오류"),
    ;

    override val errorData: ErrorData
        get() = ErrorData.of(code, errorMessage, httpStatus)
}
