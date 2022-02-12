package com.reece.address.book.common;

public class ApiErrorBuilder {
	public static ApiError buildErrorResponse(ApiError errorResponse) {
		return ApiError.builder().errorId(errorResponse.getErrorId()).httpStatus(errorResponse.getHttpStatus())
				.message(errorResponse.getMessage()).build();
	}
}
