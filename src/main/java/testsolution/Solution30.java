package testsolution;

import java.util.Scanner;

/**
 * created  by KDF on 2017/12/14.
 * 给出一个含有正整数和负整数的数组，重新排列成一个正负数交错的数组。
 注意事项
 不需要保持正整数或者负整数原来的顺序。
 样例

 给出数组[-1, -2, -3, 4, 5, 6]，重新排序之后，变成[-1, 5, -2, 4, -3, 6]或者其他任何满足要求的答案
 */


public class Solution30 {
    public static void rerange(int[] A){
        if(A.length==0||A.length==1)
            return;
        int q=-1;
        int p=0;
        while(p<A.length)
        {
            if(A[p]<0)
            {
                q++;
                int temp=A[p];
                A[p]=A[q];
                A[q]=temp;

            }
            p++;
        }
        int left=1;
        int right=A.length-2;
        if(A.length%2==1)
        {
            if(A[A.length/2]<0)
            {
                int temp2=A[A.length/2];
                A[A.length/2]=A[A.length-1];
                A[A.length-1]=temp2;
                left=1;
                right=A.length-3;
            }
            else
            {
                int temp3=A[A.length/2];
                A[A.length/2]=A[0];
                A[0]=temp3;
                left=2;
                right=A.length-2;
            }
        }

        while(left<right)
        {
            int temp1=A[left];
            A[left]=A[right];
            A[right]=temp1;
            left=left+2;
            right=right-2;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = sc.nextInt();
            }
            rerange(a);
            for (int i = 0; i < a.length; i++) {

                System.out.print(a[i] + " ");
            }
        }
    }
}
