public class Main {

    int steps;

    public Main() {
        for (int i=0; i<=100; i++) {
            steps = 0;
            long f = fib3(i);
            System.out.printf("Fib(%d) =  %,d , in %,d steps!%n", i, f, steps);
        }
    }

    long fib1(int n) {
        if (n==0 || n==1) {
            return n;
        } else {
            return add(fib1(n-1), fib1(n-2));
        }
    }

    long add(long a, long b) {
        steps++;
        return a+b;
    }

    public long fib2(int n) {
        long sum;
        long result = 1;
        long prev = -1;
        for (int i=0; i<=n; i++) {
            sum = add(result, prev);
            prev = result;
            result = sum;
        }
        return result;
    }

    //THE fastest fibonacci algorithm ever!!!
    //"closed form solutions!"
    public long fib3(int n) {
        double p = (1 + Math.sqrt(5)) / 2;
        return (long)(Math.pow(p, n) / Math.sqrt(5) + 0.5);
    }

    public static void main(String[] args) {
        new Main();
    }
}
