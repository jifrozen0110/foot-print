package com.foot.stamp.config.exception
import com.foot.stamp.error.code.GlobalErrorCode
import com.foot.stamp.error.dto.ErrorResponse
import com.foot.stamp.error.exception.CustomException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(value = [Exception::class])
    fun handleException(e: Exception): ResponseEntity<ErrorResponse> {
        val errorData = GlobalErrorCode.INTERNAL_SERVER_ERROR.errorData
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
            ErrorResponse.of(errorData),
        )
    }

    @ExceptionHandler(value = [CustomException::class])
    fun handleCustomException(e: CustomException): ResponseEntity<ErrorResponse> {
        val errorData = e.getErrorData()

        return ResponseEntity.status(errorData.httpStatus).body(
            ErrorResponse.of(
                errorData,
            ),
        )
    }
}
