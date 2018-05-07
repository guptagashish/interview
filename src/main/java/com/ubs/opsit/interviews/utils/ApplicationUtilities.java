package com.ubs.opsit.interviews.utils;

import java.util.Arrays;
import java.util.Collections;

public class ApplicationUtilities {

	/**
     * This method converts time into a BerlinTime object.
     *
     * @param hours - an integer showing Hours
     * @param minutes - an integer showing Minutes
     * @param seconds - an integer showing Seconds
     * @return a String representing the BerlinTime object.
     */
    public static String processTimeValues(int hours, int minutes, int seconds) {

        String firstLine = (seconds % 2 == 0) ? ApplicationConstants.BERLIN_CHAR_Y : ApplicationConstants.BERLIN_CHAR_O;
        String secondLine = constructClockRow(hours / 5, 4, ApplicationConstants.BERLIN_CHAR_R);
        String thirdLine = constructClockRow(hours % 5, 4, ApplicationConstants.BERLIN_CHAR_R);
        String fourthLine = constructClockRow(minutes / 5, 11, ApplicationConstants.BERLIN_CHAR_Y).replaceAll(ApplicationConstants.BERLIN_CHAR__YYY, ApplicationConstants.BERLIN_CHAR__YYR);
        String fifthLine = constructClockRow(minutes % 5, 4, ApplicationConstants.BERLIN_CHAR_Y);

        return String.join(ApplicationConstants.NEW_LINE, Arrays.asList(firstLine, secondLine, thirdLine, fourthLine, fifthLine));

    }

    /**
     * This method prepare a row of the berlin clock.
     * @param glowLights
     * @param lightsInRow
     * @param typeOfLamp
     * @return A string of characters for a row of berlin clock.
     */
    private static String constructClockRow(int glowLights, int lightsInRow, String typeOfLamp) {

    	String glowingLights = String.join(ApplicationConstants.DELIMITER_BLANK, Collections.nCopies(glowLights, typeOfLamp));
        int unlitLights = lightsInRow - glowLights;
        String unlit = String.join("", Collections.nCopies(unlitLights, ApplicationConstants.BERLIN_CHAR_O));

        return new StringBuilder().append(glowingLights).append(unlit).toString();
    }
}
