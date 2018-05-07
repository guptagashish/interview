package com.ubs.opsit.interviews;

public interface TimeConverter {

    /**
     * This method convert the input time to berlin clock time
     * 
     * @param aTime string representing the time value to be converted
     * @return string representing the berlin clock time
     */
    String convertTime(String aTime);

}
