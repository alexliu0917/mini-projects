public class cratePacking {
    public static void main(String[] args) {
        System.out.println(twofit(25, 18, 6, 5));
        System.out.println(threefit(123, 456, 789, 10, 11, 12));
    }

    static int twofit(int x, int y, int a, int b) { // Calculates the max number of 2 dimensional "boxes" that will fit
        int totalBoxes = x / a;
        totalBoxes *= (y / b);

        if ( ((x/b) * (y/a)) > totalBoxes) { // Check if rotating the squares will allow more to fit
            return ((x/b) * (y/a));
        }

        return totalBoxes;
    }

    static int threefit(int x, int y, int z, int a, int b, int c) { // Calculates the number of 3 dimensional boxes that will fit
        int totalBoxes = 0;
        if(((x/a)*(y/b)*(z/c)) > totalBoxes) totalBoxes = ((x/a)*(y/b)*(z/c));
        if(((x/a)*(y/c)*(z/b)) > totalBoxes) totalBoxes = ((x/a)*(y/c)*(z/b));
        if(((x/b)*(y/a)*(z/c)) > totalBoxes) totalBoxes = ((x/b)*(y/a)*(z/c));
        if(((x/b)*(y/c)*(z/a)) > totalBoxes) totalBoxes = ((x/b)*(y/c)*(z/a));
        if(((x/c)*(y/a)*(z/c)) > totalBoxes) totalBoxes = ((x/c)*(y/a)*(z/c));
        if(((x/c)*(y/c)*(z/a)) > totalBoxes) totalBoxes = ((x/c)*(y/c)*(z/a));
        return totalBoxes;
    }

}