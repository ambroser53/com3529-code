package uk.ac.shef.com3529.lectures.execution;

import uk.ac.shef.com3529.lectures.Triangle.Type;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class RandomlyTestTriangle {

    public static final int ITERATIONS = 100;

    public static final int MIN_INT = Integer.MIN_VALUE;
    public static final int MAX_INT = Integer.MAX_VALUE;

    // public static final int MIN_INT = -10;
    // public static final int MAX_INT = 10;

    public static void main(String[] args) {
        randomlyTestClassify();
    }

    public static void randomlyTestClassify() {
        Random r = new Random();
        Set<Integer> coveredBranches = new TreeSet<>();

        for (int i=0; i < ITERATIONS; i ++) {
            int side1 = randomInt(r);
            int side2 = randomInt(r);
            int side3 = randomInt(r);
            System.out.println((i+1) + ": [" + side1 + ", " + side2 + ", " + side3 + "]");
            instrumentedClassify(side1, side2, side3, coveredBranches);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Branch Coverage: " + coveredBranches.size() + "/ 14");
        System.out.println("Covered Branch IDs: " + coveredBranches);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    static int randomInt(Random r) {
        if (MIN_INT == Integer.MIN_VALUE && MAX_INT == Integer.MAX_VALUE) {
            return r.nextInt();
        } else {
            return r.nextInt((MAX_INT - MIN_INT + 1) + MIN_INT);
        }
    }

    public static Type instrumentedClassify(int side1, int side2, int side3, Set<Integer> coveredBranches) {
        Type type;

        if (side1 > side2) {
            coveredBranches.add(1);
            int temp = side1;
            side1 = side2;
            side2 = temp;
        } else {
            coveredBranches.add(2);
        }

        if (side1 > side3) {
            coveredBranches.add(3);
            int temp = side1;
            side1 = side3;
            side3 = temp;
        } else {
            coveredBranches.add(4);
        }

        if (side2 > side3) {
            coveredBranches.add(5);
            int temp = side2;
            side2 = side3;
            side3 = temp;
        } else {
            coveredBranches.add(6);
        }

        if (side1 + side2 <= side3) {
            coveredBranches.add(7);
            type = Type.INVALID;
        } else {
            coveredBranches.add(8);
            type = Type.SCALENE;
            if (side1 == side2) {
                coveredBranches.add(9);
                if (side2 == side3) {
                    coveredBranches.add(11);
                    type = Type.EQUILATERAL;
                } else {
                    coveredBranches.add(12);
                }
            } else {
                coveredBranches.add(10);
                if (side2 == side3) {
                    coveredBranches.add(13);
                    type = Type.ISOSCELES;
                } else {
                    coveredBranches.add(14);
                }
            }
        }
        return type;
    }
}
