package uk.ac.shef.com3529.practicals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestWeek1 {

    //FindLast
    //error was in "for (int i = x.length - 1; i > 0; i--) " as i>=0 otherwise if the only occurence of y in x is the
    //first index then it will not be found
    @Test
    void testFindLastNonFault() {
        int[] noX = {};
        assertEquals(-1, Week1.findLast(noX, 9),
                "This should not execute the fault, as there is no x to begin the for loop where the infection is");
        //could do x as null so wont run the for loop so wont encounter the fault (this is a bit more correct)
    }

    @Test
    void testFindLastNonInfection() {
        int[] noY = {1,2,3,4,5,6,7,8};
        assertEquals(7, Week1.findLast(noY, 8),
                "This should execute the fault, but not infect the program state as the for loop is executed" +
                        "but the last item is found to be the correct answer so the first index is not skipped (infection)");
    }

    @Test
    void testFindLastInfectionNoFailure() {
        int[] noY = {1,2,3,4,5,6,7,8};
        assertEquals(-1, Week1.findLast(noY, 9),
                "This should execute the fault, cause infect but not a failure as the last index is missed which" +
                        "is the infection, but the correct answer was still given so non-failure");
    }

    //first infected state is when the for loop terminates while there should be one more iteration left
    /**@Test
    void testFindLastInfectionFailure() {
        int[] Y = {1,2,3,4,5,6,7,8};
        assertEquals(1, Week1.findLast(Y, 0),
                "This should execute the fault, cause infect but not a failure as the last index is missed which" +
                        "is the infection, but the correct answer was still given so nonfailure");
    } */

    @Test
    void testFindLastInfectionFailureFixed() {
        int[] Y = {1,2,3,4,5,6,7,8};
        assertEquals(0, Week1.fixedFindLast(Y, 1),
                "This should execute the fault, cause infect but not a failure as the last index is missed which" +
                        "is the infection, but the correct answer was still given so nonfailure");
    }


    //countpositive - also counting 0 values in if statement

    @Test
    void testCountPositiveNoFault() {
        int[] X = {};
        assertEquals(0, Week1.countPositive(X),
                "This should execute not execute the fault as the if state");
    }

    @Test
    void testCountPositiveFaultNoInfection() {
        int[] X = {1,2,3};
        assertEquals(3, Week1.countPositive(X),
                "This should execute the fault by using if statement, no 0s so no infection");
    }

    /** Not possible?
    @Test
    void testCountPositiveFaultInfectionNoFailure() {
        int[] X = {1,2,3};
        assertEquals(3, Week1.countPositive(X),
                "This should execute the fault by using if statement, no 0s so no infection");
    }
    */

    @Test
    void testCountPositiveFaultInfectionFailure() {
        int[] X = {0,1,2,3};
        assertEquals(3, Week1.fixedCountPositive(X),
                "This should execute the fault by using if statement, there is 0s an infection takes place " +
                        "and this infection creates the error");
    }


    //last zero - fault is in that it will return the first 0 as the for loop is iterating up and not down
    @Test
    void testLastZeroNoFault() {
        int[] X = null;
        assertThrows(NullPointerException.class, () -> {Week1.lastZero(X);},
                "This should not execute the fault as it throws a null pointer exception first");
    }

    @Test
    void testLastZeroFaultNoInfection() {
        int[] X = {1,2,3};
        assertEquals(-1, Week1.lastZero(X),
                "This should execute the fault but as there are no 0s the state is not changed and no infection");
    }

    @Test
    void testLastZeroFaultInfectionNoFailure() {
        int[] X = {1,2,3,0};
        assertEquals(3, Week1.lastZero(X),
                "This should execute the fault and there is an infection as the state is changed as the last zero " +
                        "is returned, but it is in fact actually the last zero so there is no failure");
    }

    @Test
    void testLastZeroFaultInfectionFailure() {
        int[] X = {0,1,2,3,0};
        assertEquals(4, Week1.fixedLastZero(X),
                "This should execute the fault and there is an infection as the state is changed as the last zero" +
                        "is returned, but it is not the last zero therefore bringing a failure");
    }

    //oddOrPos - fault is in "if (x[i] % 2 == 1 || x[i] > 0)" as negative odd numbers will result in a modulo of -1 not 1
    @Test
    void testOddOrPosNoFault() {
        int[] X = {};
        assertEquals(0, Week1.oddOrPos(X),
                "This should not execute the fault as the for loop is terminated instantly and the if statement " +
                        "not checked");
    }

    @Test
    void testOddOrPosFaultNoInfection() {
        int[] X = {1,2,3};
        assertEquals(3, Week1.oddOrPos(X),
                "This should execute the fault as the if statement is executed, but as all the inputs are positive" +
                        "the state is not changed and no failure occurs");
    }

    //can you do a fault with infection but no failure?

    @Test
    void testOddOrPosFaultInfectionFailure() {
        int[] X = {-3};
        assertEquals(1, Week1.fixedOddOrPos(X),
                "This should execute the fault and there is an infection as the state is changed by not correctly" +
                        "incrementing the count for the negative number being odd, this incorrect state then propagates " +
                        "to the output of 0 causing a failure as it should have been 1");
    }

}