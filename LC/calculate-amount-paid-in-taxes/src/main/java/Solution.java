public class Solution {
    public double calculateTax(int[][] brackets, int income) {

        double totalTax = 0.0;
        int previousUpper = 0;

        for (int[] bracket : brackets) {
            //Выделяем границу с подмасива
            int upper = bracket[0];
            //Выделяем процент с подмасива
            int percent = bracket[1];

            if(income > upper) {
                //Если доход превышает текущую верхнюю границу, то налогооблагаемый доход для текущего диапазона равен разнице между текущей и предыдущей верхней границей.
                int taxableIncome = upper - previousUpper;
                totalTax += (double) (taxableIncome * percent) / 100;
            }else {
                //Если доход меньше текущей верхней границы, то налогооблагаемый доход для текущего диапазона равен разнице между доходом и предыдущей верхней границей.
                int taxableIncome = income - previousUpper;
                totalTax += (double) (taxableIncome * percent) / 100;
                break;
            }
            previousUpper = upper;
        }
        return totalTax;
    }
}
