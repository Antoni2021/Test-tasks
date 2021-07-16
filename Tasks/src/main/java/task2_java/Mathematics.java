package task2_java;

import java.util.Arrays;
import java.util.Scanner;

public class Mathematics {

    public static void getAbsolutDifference(){

        int min = 2147483647;
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int number = sc.nextInt();
        String str = sc.next();
        int[] num = new int[number];
        String[] st = str.split(" ");
        for (int i = 0; i < number ; i++){
            num[i] = Integer.parseInt(st[i]);
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length - 1; i++){
            int dif = num[i + 1] - num[i];
            if ( dif < min){
                min = dif;
            }
        }
        System.out.println(min);
    }
}
