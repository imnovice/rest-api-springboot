package com.kdn.exception;

public class ErrorCode {

	public static final int GENERIC_ERROR = 1000;
	public static final int DATA_ERROR = 1001;
	public static final int DUPLICATE_DATA_ERROR = 1002;
	public static final int FAILED_TO_PROCESS_ERROR = 1003;
	public static final int DATA_CONVERSION_ERROR = 1003;
	public static final int MANDATORY_PARAMETER_MISSING_ERROR = 1004;
	public static final int DATA_INVALID_FORMAT_ERROR = 1005;
	public static final int SERVER_BUSY = 1007;
	public static final int RECORD_NOT_FOUND_ERROR = 1008;

	private ErrorCode() {
	}

}
