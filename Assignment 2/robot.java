/*
 * Daniel Lee
 * Assignment 2
 */

import java.util.Arrays;
public class robot 
{
    
    public static void main(String[] args)
    {
        int[][] a = new int[5][5];
        a[0][0] = 1;
        int[][] obstacleArray = new int[5][5];
        obstacleArray[1][1] = 2; //these are example obstacles, change values of table of where the obstacles should be
        obstacleArray[2][2] = 2; //this means there is an obstacle at row 2 column 2, row 3 column 3, and row 4 column
        obstacleArray[3][2] = 2; //3. Put obstacles as you see fit. 
        all_path(obstacleArray,a,0,0,5);
    }
    public static void all_path(int[][] obstacleArray, int[][] a, int r, int c, int N) 
    {
        if (r == N-1 && c == N-1) //this is the end point
        {
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    if (obstacleArray[i][j] == 2) {
                        System.out.print(2 + " ");
                    }
                    else {
                        System.out.print(a[i][j] + " ");
                    }
                }

            System.out.println();
            }
            System.out.println();
            return;
        }
        if (r < N-1 && obstacleArray[r][c] != 2)
        {
            a[r+1][c] = 1;
            all_path(obstacleArray, a, r+1, c, N);
            //System.out.println(r + " " + c);
            //System.out.println(Arrays.deepToString(a));
            a[r+1][c] = 0;
        }
        if (c < N-1 && obstacleArray[r][c] != 2)
        {
            a[r][c+1] = 1;
            all_path(obstacleArray,a,r,c+1,N);
            //System.out.println(r + " " + c);
            //System.out.println(Arrays.deepToString(a));
            a[r][c+1] = 0;
        }
    }
}