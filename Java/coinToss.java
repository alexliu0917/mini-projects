import java.util.concurrent.ThreadLocalRandom;

public class coinToss {

    public static void main(String[] args) {
        System.out.println(flip());
        System.out.println(multiFlip(100));
    }

    static String flip() {
        int toss = ThreadLocalRandom.current().nextInt(0, 2); // Determine heads or tails based on whether a 1 or 0 is generated
        if(toss == 0) return "heads";
        return "tails";
    }

    static String multiFlip(int x) {
        if (x <= 100) {
            String result = "";
            int numH = 0;
            int numT = 0;
            for(int i = 0; i < x; i++) {
                String temp = flip();
                if (temp == "heads") numH++; // Keep track of number of heads and tails flipped
                else numT++;
                result += temp;
                result += " ";
            }
            System.out.println("You flipped " + numH + " heads and " + numT + " tails");
            return result;
        }
        return "Your number is too large, you can flip 100 times max";
    }
    
}