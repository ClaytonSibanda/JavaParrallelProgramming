import java.util.*;
import java.io.*;

class Main {


    public static void main(String args[])
    {


            Median m = new Median();
            int size=19;
            double timeArr[] =new double[Experiment.inputSize().length];
        for(int i=0;i<Experiment.inputSize().length;i++) {
            long start_time = System.nanoTime();
            m.filter(Experiment.readFile("C:\\Users\\USER\\Desktop\\2nd year\\2nd Semester\\CSC2002S\\Assignments\\sampleinputfile.txt", Experiment.inputSize()[i]), size);
            long end_time = System.nanoTime();
            timeArr[i]=(end_time-start_time)/1e6;
        }

Experiment.writeCSV("C:\\Users\\USER\\Desktop\\2nd year\\2nd Semester\\CSC2002S\\Assignments\\Assignment1\\sequentialExp\\lengthExp.csv",Experiment.inputSize(),size,timeArr);








    }
}