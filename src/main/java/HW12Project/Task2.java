package HW12Project;

public class Task2 {
    public static void main(String[] args) {
    FizzBuzzThread [] threads = {
            new FizzBuzzThread (i -> i%3==0 && i%5==0, i-> "fizzbuzz", 20),
            new FizzBuzzThread (i -> i%3==0 && i%5!=0, i-> "fizz", 20),
            new FizzBuzzThread (i -> i%3!=0 && i%5==0, i-> "buzz", 20),
            new FizzBuzzThread (i -> i%3!=0 && i%5!=0, i-> String.valueOf(i), 20)
             };

        for (FizzBuzzThread thread : threads) {
            thread.start();
        }
    }
}
