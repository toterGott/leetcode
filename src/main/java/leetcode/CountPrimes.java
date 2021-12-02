package leetcode;

public class CountPrimes {
    public static void main(String[] args) {
        Utils.exec(CountPrimes::countPrimes, 10, 4);
        Utils.exec(CountPrimes::countPrimes, 0, 0);
        Utils.exec(CountPrimes::countPrimes, 1, 0);
        Utils.exec(CountPrimes::countPrimes, 499979, 41537);
    }

    public static int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        int counter = 0;

        for (int i = 2; i * i < notPrimes.length; i++) {
            if (notPrimes[i] == false) {
                for (int j = i; j * i < notPrimes.length; j++) {
                    notPrimes[i * j] = true;
                }
            }
        }

        for (int i = 2; i < notPrimes.length; i++) {
            if (notPrimes[i] == false) counter++;
        }

        return counter;
    }
}
