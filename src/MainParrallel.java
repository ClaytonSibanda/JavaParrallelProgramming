
/**
 * Created by Clayza on 2017-08-25.
 */

import java.io.*;
import java.util.*;
import java.util.concurrent.ForkJoinPool;


public class MainParrallel {

    public static void main(String args[]) {

        for(int i=0;i<inputSize().length;i++) {
            double arr[] = readFile("C:\\Users\\USER\\Desktop\\2nd year\\2nd Semester\\CSC2002S\\Assignments\\sampleinputfile.txt",inputSize()[i]);
            double newArr[] = new double[arr.length];
            //Scanner sc = new Scanner(System.in);
            // System.out.println("Enter the size of the window: ");
            int size = 3;// sc.nextInt();

           // while (size != 0) {
                double tempArr[] = new double[size];
            long start_time = System.nanoTime();
                ForkJoinPool.commonPool().invoke(new MedianParrallel((size - 1) / 2, arr.length - (size - 1) / 2, arr, newArr, tempArr, size));
            long end_time = System.nanoTime();
                writeFile("C:\\Users\\USER\\Desktop\\2nd year\\2nd Semester\\CSC2002S\\Assignments\\Assignment1\\output.txt", newArr);
                 System.out.println("length size time");
                System.out.println(arr.length+" "+size+" "+((end_time - start_time) / 1e6));
                // System.out.println("Enter the size of the window: ");
                //size = sc.nextInt();
            //}
        }

    }


    public static double[] readFile(String filename,int arrLength) //reads the file and returns an array of doubles
    {
        double[] arr = null;
        try {
            FileReader fr = new FileReader(filename);

            BufferedReader bf = new BufferedReader(fr);
            String line = "";
            int length = Integer.parseInt(bf.readLine());
           // System.out.println(length);
            arr = new double[arrLength];
            int i = 0;

                while ((line = bf.readLine()) != null && i<arrLength) {

                    arr[i] = Double.parseDouble((line.split(" ")[1]));
                    i++;
                }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return arr;

    }

    public static void writeFile(String filename, double arr[]) {
        try {
            FileWriter fw = new FileWriter(filename);
            String newLine = System.getProperty("line.separator");
            fw.write(arr.length + newLine);
            for (int i = 0; i < arr.length; i++) {
                fw.write(i + 1 + " " + arr[i] + newLine);
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



//This method is for taking in the input sizes for the experiment
private static int[] inputSize()
{
    int arr[] = new int[10];
    arr[0]=50000;
    arr[1]=100000;
    for(int i=2;i<arr.length;i++)
    {
      arr[i]=arr[i-1]+100000;
    }
   return arr;
}

private int[] filterSize()
{
    int arr[] = new int[10];
    for(int i=0,j=3;i<arr.length;i++,j+=2)
    {
        arr[i]=j;
    }
    return arr;
}


}