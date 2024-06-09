package com.foot.stamp.error.exception

import com.foot.stamp.error.code.ErrorCode
import com.foot.stamp.error.dto.ErrorData

class CustomException(
    val errorCode: ErrorCode,
) : RuntimeException() {
    fun getErrorData(): ErrorData {
        return errorCode.errorData
    }
}
