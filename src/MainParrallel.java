
/**
 * Created by Clayza on 2017-08-25.
 */

import java.io.*;
import java.util.*;
import java.util.concurrent.ForkJoinPool;


public class MainParrallel {

    public static void main(String args[]) {
        int size = 0;
        double[] timeArr = new double[Experiment.cut_Off().length];
        int length=1000000;

        for (int i = 0; i < Experiment.cut_Off().length; i++) {

            double arr[] = Experiment.readFile("C:\\Users\\USER\\Desktop\\2nd year\\2nd Semester\\CSC2002S\\Assignments\\sampleinputfile.txt", length);
            double newArr[] = new double[arr.length];

            size = 15;// sc.nextInt();

            // while (size != 0) {
            double tempArr[] = new double[size];
            //System.out.println(Experiment.cut_Off()[i]);
            long start_time = System.nanoTime();
            ForkJoinPool.commonPool().invoke(new MedianParrallel((size - 1) / 2, arr.length - (size - 1) / 2, arr, newArr, tempArr, size,Experiment.cut_Off()[i]));
            long end_time = System.nanoTime();
            Experiment.writeFile("C:\\Users\\USER\\Desktop\\2nd year\\2nd Semester\\CSC2002S\\Assignments\\Assignment1\\output.txt", newArr);
            //System.out.println


            timeArr[i] = ((end_time - start_time) / 1e6);

        }
        //System.out.println(Arrays.toString(timeArr));
        Experiment.writeCSV("C:\\Users\\USER\\Desktop\\2nd year\\2nd Semester\\CSC2002S\\Assignments\\Assignment1\\outputSEQUENTIAL_CUTOFF.csv", Experiment.cut_Off(), length,size, timeArr);


    }

}








