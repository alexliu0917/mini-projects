import java.lang.Math.*;
// Alex Liu

/*
How tax brackets work
A tax bracket is a range of income based on the income caps, and each tax bracket has a corresponding marginal tax rate, which 
applies to income within the bracket. In our example, the tax bracket for the range ¤10,000 to ¤30,000 has a marginal tax rate of 10%. 
Here's what that means for each bracket:

 *If your income is less than ¤10,000, you owe 0 income tax.

 *If your income is between ¤10,000 and ¤30,000, you owe 10% income tax on the income that exceeds ¤10,000. For instance, 
  if your income is ¤18,000, then your income in the 10% bracket is ¤8,000. So your income tax is 10% of ¤8,000, or ¤800.

 *If your income is between ¤30,000 and ¤100,000, then you owe 10% of your income between ¤10,000 and ¤30,000, plus 25% 
  of your income over ¤30,000.

 *And finally, if your income is over ¤100,000, then you owe 10% of your income from ¤10,000 to ¤30,000, plus 25% of your 
  income from ¤30,000 to ¤100,000, plus 40% of your income above ¤100,000.

One aspect of progressive taxation is that increasing your income will never decrease the amount of tax that you owe, or 
your overall tax rate (except for rounding).
*/
public class progTaxCalc{
    public static void main(String[] args) {
        System.out.println("test");
        System.out.println(taxCalc(256250.0)); // $256,250 should be taxed at $82,000
    }

    static double taxCalc(double income) {
        double totalTaxes = 0;  // Total amount of taxes to be paid

        double firstCap = 10000;
        double firstRate = 0.1; // 10% is taxed between $10k - $30k

        double secondCap = 30000;
        double secondRate = 0.25; // 25% is taxed between $30k and $100k

        double thirdCap = 100000;
        double thirdRate = 0.40; // 40% is taxed from $100k+

        if(income < firstCap) {
            return totalTaxes;
        }
        if (income > firstCap) {
            double taxableAmt = Math.min((secondCap-firstCap), (income-firstCap)); // tax income-firstCap or 20k, whichever is lower
            totalTaxes += taxableAmt * firstRate;
        }
        if (income > secondCap) {
            double taxableAmt = Math.min((thirdCap-secondCap), (income-secondCap)); // tax income-secondCap or 70k, whichever is lower
            totalTaxes += taxableAmt * secondRate;
        }
        if (income > thirdCap) {
            totalTaxes += (income - thirdCap) * thirdRate; // tax anything made above 100k at 40%
        }

        return totalTaxes;
    }
}