package q2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Primes
 * <p>This is a program that finds the prime numbers up to a max value.</p>
 * <p>It then processes each number into a Boolean array that calculates
 * if the index number is prime or not. It uses the Sieve of Eratosthenes and
 * sets the index to true or false.</p>
 *
 * @author Ivan (Oliver) Harrison
 * @version 2020
 */
public class Primes {
    
    /** <p>Private instance variable for list of prime numbers.</p> */
    private List<Boolean> primes = new ArrayList<Boolean>();
    
    /** 
     * <p>Constructor that calls the calculatePrimes() method with 
     * the parameters for the max value.</p>
     * @param n the max value to check for.
     */
    public Primes(int n) {
        if (!(n > 1)) {
            throw new IllegalArgumentException("Integer must be"
                + "greater than 1");
        }
        calculatePrimes(n);
    }
    
    /**
     * <p>Method to calculate prime numbers up to a point n.</p>
     * @param n parameter for the max value to check for primes.
     */
    private void calculatePrimes(int n) {
        for (int i = 0; i <= n; i++) {
            primes.add(true);
        }
        for (int i = 0; i <= (int) Math.sqrt(n); i++) {
            if (isPrime(i)) {
                primes.set(i, true);
                for (int j = 2; j * i <= n; j++) {
                    primes.set(j * i, false);
                }
            } else {
                primes.set(i, false);
            }
        }
    }
    
    /**
     * <p>Method to print the prime numbers in the primes array list.</p>
     */
    public void printPrimes() {
        for (int i = 0; i < primes.size(); i++) {
            if (primes.get(i)) {
                System.out.print(i + " ");
            }
            
        }
    }
    
    /**
     * <p>Method to count the number of primes in the array.</p>
     * @return count the amount of prime numbers in the array primes.
     */
    public int countPrimes() {
        int count = 0;
        for (int i = 0; i < primes.size(); i++) {
            if (primes.get(i)) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * <p>Method that checks if a number is prime.</p>
     * @param x the number that is being checked.
     * @return boolean whether the number is prime (true) or not (false).
     */
    public boolean isPrime(int x) {
        if (x > (primes.size() - 1)) {
            throw new IllegalArgumentException();
        }
        if (x < 2) {
            return false;
        }
        if (x == 2) {
            return true;
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        //Message asking for the max value of a list of prime numbers.
        System.out.println("This program uses the sieve of Eratosthenes to "
            + "determine which numbers are prime.\nEnter an upper bound"
            + " greater than 1:");
        int upperBound;
        Scanner scan = new Scanner(System.in);
        
        //After getting user input do loop verifies the value is greater than 1.
        do {
            upperBound = scan.nextInt();
        } while (upperBound <= 1);
        
        //Creation of the prime object.
        Primes prime = new Primes(upperBound);

        //Calculates and prints number of primes and the prime numbers.
        System.out.println("There are " + prime.countPrimes() + " primes:");
        System.out.println("The prime numbers between 0 and " + upperBound
            + " are:");
        prime.printPrimes();
        
        scan.close();
    }
}
