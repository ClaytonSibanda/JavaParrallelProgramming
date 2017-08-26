
/**
 * Created by Clayza on 2017-08-25.
 */

import java.io.*;
import java.util.*;
import java.util.concurrent.ForkJoinPool;


public class MainParrallel {

    public static void main(String args[]) {
        int size=0;
        double[] timeArr = new double[Experiment.inputSize().length];;

        for (int i = 0; i < Experiment.inputSize().length; i++) {
            double arr[] = Experiment.readFile("C:\\Users\\USER\\Desktop\\2nd year\\2nd Semester\\CSC2002S\\Assignments\\sampleinputfile.txt", Experiment.inputSize()[i]);
            double newArr[] = new double[arr.length];

            size = 3;// sc.nextInt();

            // while (size != 0) {
            double tempArr[] = new double[size];
            long start_time = System.nanoTime();
            ForkJoinPool.commonPool().invoke(new MedianParrallel((size - 1) / 2, arr.length - (size - 1) / 2, arr, newArr, tempArr, size));
            long end_time = System.nanoTime();
            Experiment.writeFile("C:\\Users\\USER\\Desktop\\2nd year\\2nd Semester\\CSC2002S\\Assignments\\Assignment1\\output.txt", newArr);
            //System.out.println


            timeArr[i]=((end_time - start_time) / 1e6);
            //System.out.println(timeArr[i]);
        }
        //System.out.println(Arrays.toString(timeArr));
        Experiment.writeCSV("C:\\Users\\USER\\Desktop\\2nd year\\2nd Semester\\CSC2002S\\Assignments\\Assignment1\\output1.csv",Experiment.inputSize(),size,timeArr);


    }

}








