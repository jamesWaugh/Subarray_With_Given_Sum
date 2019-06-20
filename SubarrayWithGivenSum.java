/*
 Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.

 Input:
 The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

 Output:
 For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.

 Constraints:
 1 <= T <= 100
 1 <= N <= 10^7
 1 <= Ai <= 10^10

 Example:
 Input:
 2
 5 12
 1 2 3 7 5
 10 15
 1 2 3 4 5 6 7 8 9 10
 Output:
 2 4
 1 5

 Explanation : 
 Testcase1: sum of elements from 2nd position to 4th position is 12
 Testcase2: sum of elements from 1st position to 5th position is 15
 */
package subarraywithgivensum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubarrayWithGivenSum {

    static Scanner scan = new Scanner(System.in);
    static int t;//denotes the number of test cases
    static List<Integer> n = new ArrayList<Integer>();//size of the array
    static List<Integer> s = new ArrayList<Integer>();//sum of the array
    static int testcase;

    public static void main(String[] args) throws IOException {
        System.out.println("Input:");
        //Enter T, number of test cases
        int testT = scan.nextInt();
        while (testT < 1 || testT > 100) {
            System.out.println("Error, out of bounds, reenter");
            testT = scan.nextInt();
        }
        t = testT;

        List<int[]> a = new ArrayList<int[]>();
        for (int i = 0; i < t; i++) {
            //Enter N and S, size of array and sum
            BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
            String lines1 = br1.readLine();

            String[] strs1 = lines1.trim().split("\\s+");
            n.add(Integer.parseInt(strs1[0]));
            s.add(Integer.parseInt(strs1[1]));

            //Enter array elements
            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
            String lines2 = br2.readLine();

            String[] strs2 = lines2.trim().split("\\s+");
            a.add(new int[n.get(i)]);
            for (int j = 0; j < n.get(i); j++) {
                a.get(i)[j] = Integer.parseInt(strs2[j]);
            }
        }

        //output
        System.out.println("Output:");
        for (int i = 0; i < t; i++) {
            int storeOutput[] = new int[2];
            int sum = 0;
            int j = 0;
            while (sum != s.get(i)) {
                sum = 0;
                for (int k = j; k < n.get(i); k++) {
                    sum += a.get(i)[k];
                    if (sum == s.get(i)) {
                        //+1 since the problem asks for the position (1 indexing)
                        storeOutput[0] = j + 1;
                        storeOutput[1] = k + 1;
                        break;
                    }
                }
                j++;
            }

            if (sum == s.get(i)) {
                System.out.println(storeOutput[0] + " " + storeOutput[1]);
            } else {
                System.out.println(-1);
            }
        }
    }
}
