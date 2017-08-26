import java.util.*;
import java.io.*;

class Main {


    public static void main(String args[])
    {


            Median m = new Median();
            int size=0;

            int arr[] =Experiment.filterSize();
        double timeArr[] =new double[arr.length];
            int length= 1000000;

        for(int i=0;i<arr.length;i++) {
            size=arr[i];
            long start_time = System.nanoTime();
            m.filter(Experiment.readFile("C:\\Users\\USER\\Desktop\\2nd year\\2nd Semester\\CSC2002S\\Assignments\\sampleinputfile.txt", length), size);
            long end_time = System.nanoTime();
            timeArr[i]=(end_time-start_time)/1e6;
        }

Experiment.writeCSV("C:\\Users\\USER\\Desktop\\2nd year\\2nd Semester\\CSC2002S\\Assignments\\Assignment1\\sequentialExp\\windowSizeExp.csv",arr,length,timeArr);








    }
}