package com.ubs.opsit.interviews;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.ubs.opsit.interviews.impl.BerlinClock;

/**
 * Acceptance test class that uses the JBehave (Gerkin) syntax for writing stories.  You should not need to
 * edit this class to complete the exercise, this is your definition of done.
 */
public class BerlinClockFixture {

    private static TimeConverter berlinClock;
    private String theTime;

    @BeforeClass
    public static void setUp() {
    	berlinClock = new BerlinClock();
    }
    
    @Test
    public void berlinClockAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock.story")
                .run();
    }

    @When("the time is $time")
    public void whenTheTimeIs(String time) {
        theTime = time;
    }

    @Then("the clock should look like $")
    public void thenTheClockShouldLookLike(String theExpectedBerlinClockOutput) {
        assertThat(berlinClock.convertTime(theTime)).isEqualTo(theExpectedBerlinClockOutput);
    }

    @SuppressWarnings("unchecked")
	@Test(expected=IllegalArgumentException.class)
    public void berlinClockExceptionForNullTime() throws Exception {
        Mockito.when(berlinClock.convertTime(null)).thenThrow(IllegalArgumentException.class);
    }
}
