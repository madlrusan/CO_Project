package org.project.co.RandomGen;
import static org.project.co.BigPi.spigot.myspigot;
import java.math.BigInteger;
import java.util.Random;

//array of 50 elements that has numbers from 1 to 75;
public class bingoNumbers {
    public static int[] generateBingo() {
        int[] nums = new int[50];
        int[] check = new int[76];
        int x;
        Random r = new Random();
        BigInteger rand=new BigInteger("0");
        BigInteger temp=new BigInteger("0");
        rand=myspigot((r.nextInt(50)+50));
        for (int i = 0; i <= 75; i++)
            check[i] = 0;
        for (int i = 0; i < 50; i++) {
         //   x = r.nextInt(75) + 1;
            rand=myspigot((r.nextInt(3000)+30));
            temp=rand.remainder(BigInteger.valueOf(75));
            x=temp.intValue()+1;
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