package pl.bartkn;

public class Main {

    public static void main(String[] args) {
        BalancedWordCounter counter = new BalancedWordCounter();
        int result = counter.count("aabbabcccba");
        System.out.println(result);
    }
}
