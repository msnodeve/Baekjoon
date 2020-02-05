package swea.d1;

import java.util.Arrays;
import java.util.Scanner;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        int[] list = new int[T];
 
        for(int i = 0 ; i < T; i++){
            list[i] = sc.nextInt();
        }
        Arrays.sort(list);
 
        System.out.println(list[T/2]);
    }
}
