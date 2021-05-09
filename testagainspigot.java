import java.math.*;
public class testagainspigot{
    public static void main(String args[])
    {    String input="0";
        BigInteger nr=new BigInteger(input);
         int n=19;
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
                 //System.out.print((predigit+1));
                nr=nr.multiply(BigInteger.valueOf(10));
                nr=nr.add(BigInteger.valueOf(predigit+1));
                 for(int k=0;k<nine;k++)
                 {//System.out.print(0);
                 nr=nr.multiply(BigInteger.valueOf(10));
                 }
                 predigit=0;
                 nine=0;
             }
             else{
                 //System.out.print((predigit));
                 nr=nr.multiply(BigInteger.valueOf(10));
                 nr=nr.add(BigInteger.valueOf(predigit));
                 predigit=q;
                 if(0!=nine)
                 {
                     for(int k=0; k<nine;k++){
                        nr=nr.multiply(BigInteger.valueOf(10));
                        nr=nr.add(BigInteger.valueOf(9)); 
                         //System.out.print(9);
                 }
                 }
                 nine=0;
             }
         }
         nr=nr.multiply(BigInteger.valueOf(10));
         nr=nr.add(BigInteger.valueOf(predigit));
         System.out.println((nr));
         //System.out.println(predigit);
     }
 }