package uk.ac.shef.com3529.lectures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTriangle {

    @Test
    public void testInvalid() {
        assertEquals(Triangle.Type.INVALID, Triangle.classify(0,0,0));
    }

    //no equal sides
    @Test
    public void testScalene() {
        assertEquals(Triangle.Type.SCALENE, Triangle.classify(2,4,5));
    }

    @Test
    public void testEquilateral() {
        assertEquals(Triangle.Type.EQUILATERAL, Triangle.classify(2,2,2));
    }

    //This one is equivalent to branch 36F45
    @Test
    public void testScaleneWithEqualSides12ButNot23() {
        assertEquals(Triangle.Type.SCALENE, Triangle.classify(2,2,3));
    }

    @Test
    public void testIsosceles() {
        assertEquals(Triangle.Type.ISOSCELES, Triangle.classify(1,2,2));
    }

    //here tests the early part branches, this checks all of them as it rearranges it back to front
    @Test
    public void testScalene1Biggest3Smallest() {
        assertEquals(Triangle.Type.SCALENE, Triangle.classify(5,4,2));
    }
}
