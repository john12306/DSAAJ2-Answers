//Chap02.question.20.PrimalityTest.java

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    private static Random random = new Random();

    public static void main(String... args) {
        for (long i = 10000000000000700L; i < 10000000000001000L; i++)
            if (testPrime(i))
                System.out.print(i + ", ");

        int times = 100000;
        List<Long> l20 = new ArrayList<>();
        List<Long> l40 = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            l20.add(generateRandomLong(20));
            l40.add(generateRandomLong(40));
        }

        long a = System.currentTimeMillis();
        for (long l : l20)
            testPrime(l);
        long b = System.currentTimeMillis();
        System.out.println("\n20 bits : " + (b - a));

        a = System.currentTimeMillis();
        for (long l : l40)
            testPrime(l);
        b = System.currentTimeMillis();
        System.out.println("40 bits : " + (b - a));

    }

    public static boolean testPrime(long n) {
        if (n < 2) return false;
        if (n < 4) return true;
        if ((n & 0x1) == 0) return false;

        //now n>=5 and n is odd
        for (long i = 3; i <= (long) (Math.sqrt(n)) + 1; i += 2) {
            if (n % i == 0) return false;
        }

        return true;
    }


    private static long generateRandomLong(int bits) {
        long r = 0;
        for (int i = 0; i < bits; i++) {
            r <<= 1;
            if (random.nextBoolean())
                r += 1;
        }
        return r;
    }
}
