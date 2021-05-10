package org.project.co.RandomGen;

import java.util.Random;

//array of 50 elements that has numbers from 1 to 75;
public class bingoNumbers {
    public static int[] generateBingo() {
        int[] nums = new int[50];
        int[] check = new int[76];
        int x;
        Random r = new Random();
        for (int i = 0; i <= 75; i++)
            check[i] = 0;
        for (int i = 0; i < 50; i++) {
            x = r.nextInt(75) + 1;
            if (check[x] == 1)
                i = i-1;
            else {
                check[x]++;
                nums[i] = x;
            }
        }
        return nums;
    }
}