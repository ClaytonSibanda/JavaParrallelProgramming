import java.util.*;

public class Median
{


    //int size =new Scanner(System.in).nextInt();


    public double [] filter(double arr[],int size)

    {
        double newArr[] = new double[arr.length];
        double tempArr[] = new double[size];
        int start =(size-1)/2;

        for( int i=0;i<start;i++)
        {
            newArr[i]=arr[i];
        }

        for(int i=arr.length-start;i<arr.length;i++)
        {
            newArr[i]=arr[i];
        }
        int k=0;
        //System.out.println(Arrays.toString(newArr));

        for(int i=start;i<arr.length-start;i++)
        {
            k=0;
            for(int j=i-(size/2);j<=i+(size/2);j++)//for populating temp Array
            {//System.out.println("j is "+j+" and i is "+i);
                tempArr[k]=arr[j];
                k++;
            }
            //System.out.println("Temp arry is "+Arrays.toString(tempArr));
            newArr[i]=median(tempArr);

        }
       // System.out.println("newArr array is "+Arrays.toString(newArr));
Experiment.writeFile("C:\\Users\\USER\\Desktop\\2nd year\\2nd Semester\\CSC2002S\\Assignments\\Assignment1\\sequentialExp\\outputSeq.txt",newArr);
        //System.out.println(Arrays.toString(newArr));

        return newArr;}



    public double median(double arr[])
    {

        MergeSort ms = new MergeSort();

        arr=ms.mergeSort(arr);



            if((arr.length)%2!=0)
                return arr[arr.length/2];

            else
                return (arr[arr.length/2]+arr[(arr.length/2)-1])/2;

    }



}