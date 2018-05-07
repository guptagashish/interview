package com.ubs.opsit.interviews.utils;

public interface ApplicationConstants {

	Integer TIME_PARTS_COUNT = 3;
    
	String NEW_LINE = System.getProperty("line.separator");
    String DELIMITER_COLON=":";
    String DELIMITER_BLANK="";
    String BERLIN_CHAR_R = "R";
    String BERLIN_CHAR_Y = "Y";
    String BERLIN_CHAR_O = "O";
    String BERLIN_CHAR__YYY = "YYY";
    String BERLIN_CHAR__YYR = "YYR";

    String ERROR_PROVIDE_TIME = "Error: Please provide a valid time";
    String ERROR_TIME_INVALID = "Error: The provided time is invalid.";
    String ERROR_TIME_TYPE = "Error: Timevalue provided must be numeric.";
    String ERROR_HOUR_OUT_OF_LIMIT = "Error: Hours out of limit";
    String ERROR_MINUTES_OUT_OF_LIMIT = "Error: Minutes out of limit";
    String ERROR_SECONDS_OUT_OF_LIMIT = "Error: Seconds out of limit";
}
