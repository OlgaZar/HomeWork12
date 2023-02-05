package HW12Project;

import java.util.function.Function;
import java.util.function.Predicate;

public class FizzBuzzThread extends Thread {
    private  static volatile int current  = 1;
    Predicate<Integer> checker;
    Function<Integer, String> output;
    int  n;

    public FizzBuzzThread(Predicate<Integer> checker, Function<Integer, String> output, int n) {
        this.checker = checker;
        this.output = output;
        this.n = n;
    }

    public FizzBuzzThread() {
    }

    @Override
    public void run() {
        while (current <= n) {
            synchronized (this) {
                if (checker.test(current)) {
                    System.out.println(output.apply(current));
                    current++;
                }
            }
        }
    }
}


