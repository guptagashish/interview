package com.ubs.opsit.interviews.impl;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.utils.ApplicationConstants;
import com.ubs.opsit.interviews.utils.ApplicationUtilities;

public class BerlinClock implements TimeConverter {
    
	@Override
	public String convertTime(String time) {

        if(null == time) {
        	throw new IllegalArgumentException(ApplicationConstants.ERROR_PROVIDE_TIME);
        }

        String[] times = time.split(ApplicationConstants.DELIMITER_COLON, ApplicationConstants.TIME_PARTS_COUNT.intValue());
        if(ApplicationConstants.TIME_PARTS_COUNT.intValue() != times.length) {
        	throw new IllegalArgumentException(ApplicationConstants.ERROR_TIME_INVALID);
        }

        int hoursInTime = 0;
        int minutesInTime = 0;
        int secondsInTime = 0;
        
        try {
            hoursInTime = Integer.parseInt(times[0]);
            minutesInTime = Integer.parseInt(times[1]);
            secondsInTime = Integer.parseInt(times[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ApplicationConstants.ERROR_TIME_TYPE);
        }

        
        if (hoursInTime < 0 || hoursInTime > 24) {
        	throw new IllegalArgumentException(ApplicationConstants.ERROR_HOUR_OUT_OF_LIMIT);
        }
        if (minutesInTime < 0 || minutesInTime > 59) {
        	throw new IllegalArgumentException(ApplicationConstants.ERROR_MINUTES_OUT_OF_LIMIT);
        }
        if (secondsInTime < 0 || secondsInTime > 59) {
        	throw new IllegalArgumentException(ApplicationConstants.ERROR_SECONDS_OUT_OF_LIMIT);
        }

        return ApplicationUtilities.processTimeValues(hoursInTime, minutesInTime, secondsInTime);
	}

}