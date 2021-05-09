package BigPi;
import java.math.*;
public class spigot{
    public static BigInteger myspigot(int digits){
    String input="0"; //we need a string to initialize Big Integer
    BigInteger nr=new BigInteger(input);
    int n=digits+2;//The algorithm calculates n-2 digits of pi, the first being the integral number(3) being the integral part. 
    int len=(n/3*10)+1;
    int nine=0;
    int predigit=0;
    int q=0;
    int[] sarray=new int[len];
    for(int i=0;i<len;i++)
        sarray[i]=2;
    for(int j=1;j<=n;j++){
         for(int i=len;i>0;i--){
             int x=10*sarray[i-1]+q*i;
             sarray[i-1]=x%(2*i-1);
             q=x/(2*i-1);
         }
         sarray[0]=q%10;
         q=q/10;
         if(q==9)
         nine++;
         else if(10==q)
         {
            nr=nr.multiply(BigInteger.valueOf(10));
            nr=nr.add(BigInteger.valueOf(predigit+1));
            for(int k=0;k<nine;k++){
            nr=nr.multiply(BigInteger.valueOf(10));
            }
        predigit=0;
        nine=0;
        }
         else{
             nr=nr.multiply(BigInteger.valueOf(10));
             nr=nr.add(BigInteger.valueOf(predigit));
             predigit=q;
             if(0!=nine)
             {
                 for(int k=0; k<nine;k++){
                    nr=nr.multiply(BigInteger.valueOf(10));
                    nr=nr.add(BigInteger.valueOf(9)); 
             }
             }
             nine=0;
         }
     }
     nr=nr.multiply(BigInteger.valueOf(10));
     nr=nr.add(BigInteger.valueOf(predigit));
     return nr;
}
}