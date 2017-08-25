import java.util.*;
import java.io.*;

class Main {


    public static void main(String args[])
    {
        int length =0;
        try
        {
            FileReader fr = new FileReader("C:\\Users\\USER\\Desktop\\2nd year\\2nd Semester\\CSC2002S\\Assignments\\sampleinputfile.txt");
            BufferedReader bf = new BufferedReader(fr);

            String line="";

            length =Integer.parseInt(bf.readLine());
            double[] arr  =new double[length];
            int i=0;
            while((line=bf.readLine())!=null)
            {
                //System.out.println(line);
                arr[i]=Double.parseDouble(line.split(" ")[1]);
                i++;
                //if(Integer.parseInt(line.split(" ")[0])>10000)

            }
           // System.out.println("these are the items "+Arrays.toString(arr));
            Median m = new Median();
            m.filter(arr,3);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }












        //  System.out.println(m.median(arr));
















    }
}