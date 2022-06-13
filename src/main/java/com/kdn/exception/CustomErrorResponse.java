package com.kdn.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomErrorResponse {

	private String error;
	private int errCode;
	private int httpStatus;
	private String uri;
	private LocalDateTime timestamp;

}
