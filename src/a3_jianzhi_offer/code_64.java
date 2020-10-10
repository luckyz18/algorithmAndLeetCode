package a3_jianzhi_offer;

public class code_64 {
    public int sum_solution(int n){
        int sum = n;
        boolean  b = (n>0) && ((sum += sum_solution(n-1)) > 0);
        return sum;
    }
}
