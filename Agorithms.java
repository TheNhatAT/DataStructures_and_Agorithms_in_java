import javafx.scene.control.RadioMenuItem;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.Random;

public class Agorithms implements ProcessArray, DivideAndConquer{
    private ArrayList<Integer> number = new ArrayList<>();

    public Agorithms(){
        //empty
    }
    public void setAgorithms(int sizeOfArray){
        Random random = new Random();
        for (int i = 0; i < sizeOfArray; i++){
            number.add(random.nextInt(20 - (-10)) + -10);
           // number.add(random.nextInt(10));
        }
    }
    public void print(){
        for (int e: number) {
            System.out.print(e + " ");
        }
        System.out.println("\n");
    }

    @Override
    public int maxByBruteForce() {
        int maxSum = Integer.MIN_VALUE, i, j;
        for (i = 0; i < number.size(); i++) {
            for (j = i; j < number.size(); j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += number.get(k);
                }
                if (sum > maxSum){
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    @Override
    public int maxByBruteForceImproved() {
        int maxSum = Integer.MIN_VALUE, i, j;
        for (i = 0; i < number.size(); i++) {
            int sum = 0;
            for (j = i; j < number.size(); j++) {
                sum += number.get(j);
                if (sum > maxSum){
                    maxSum = sum;
                }
            }
        }
        return maxSum;

    }

    @Override
    public int maxByRecursive() {
        return maxSub(0, number.size() - 1);
    }
    @Override
    public int maxSub(int low, int high){
        int mid = 0;
        int wL, wR, wM;
        if(low == high) return number.get(low);
        else {
            mid = (low + high) / 2;
            wL = maxSub(low, mid);
            wR = maxSub(mid + 1, high);
            wM = maxLeft(0, (number.size() - 1)/2) + maxRight((number.size() - 1)/2 + 1, number.size() - 1);
            return max(wL, wR, wM);
        }
    }

    @Override
    public int max(int wL, int wR, int wM) {
        int max = wL;
        if (wR > max){
            max = wR;
        }
        else if (wM > max){
            max = wM;
        }
        return max;
    }

    @Override
    public int max(int x1, int x2) {
        if(x1 >= x2){
            return x1;
        }
        else {
            return x2;
        }
    }

    @Override
    public int maxLeft(int low, int mid) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for(int k = mid; k >= low; k--){
            sum = sum + number.get(k);
            maxSum = max(sum, maxSum);
        }
        return maxSum;
    }

    @Override
    public int maxRight(int mid, int high) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for(int k = mid; k <= high; k++){
            sum = sum + number.get(k);
            maxSum = max(sum, maxSum);
        }
        return maxSum;
    }

    @Override
    public int maxByDynamicPrograming() {
        return maxSub();
    }

    @Override
    public int maxSub() {
        int smax = number.get(0);
        int ei = number.get(0);
        int imax = 1;
        for(int i = 1; i < number.size(); i++){
            ei = max(number.get(i), ei + number.get(i));
            smax = max(smax, ei);
        }
        return smax;
    }

    @Override // divide and conquer
    public int fastPower(int a, int n) {
        int x;
        if (0 == n) return 1;
        if (1 == n) return a;
        else {
           x = fastPower(a, n/2);
        }
        if (n % 2 == 0) return x*x;
        else return x*x*a;
    }
}
