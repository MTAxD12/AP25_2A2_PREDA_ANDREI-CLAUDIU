public class Main {
    public static void main(String[] args) {
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int)(Math.random() * 1_000_000);
        n *= 3;
        n += 0b10101;
        n += 0xFF;
        n *= 6;

        int sum = n;

        while(sum > 9) {
            n = sum;
            sum = 0;
            while(n > 0) {
                sum += n%10;
                n /= 10;
            }
        }

        System.out.println("Willy-nilly, this semester I will learn " + languages[sum]);
    }
}