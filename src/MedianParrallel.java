import java.util.concurrent.RecursiveAction;

/**
 * Created by Clayza on 2017-08-25.
 */
public class MedianParrallel extends RecursiveAction
{
 int low;
 int high;
 double arr [];
 double newArr [];
 double tempArr[];
 int size;
 int SEQUENTIAL_CUTOFF=1000;

 public MedianParrallel(int low, int high,double arr[],double newArr[],double tempArr[],int size)
    {
        this.low=low;
        this.high=high;
        this.arr=arr;
        this.newArr=newArr;
        this.size=size;
        this.tempArr=tempArr;

    }

   @Override
public void compute()
{
    if(high-low<SEQUENTIAL_CUTOFF)
    {
        int k=0;
        //System.out.println(Arrays.toString(newArr));

        for(int i=low;i<high;i++)
        {
            k=0;
            for(int j=i-(size/2);j<=i+(size/2);j++)//for populating temp Array
            {System.out.println("j is "+j+" and i is "+i);
                tempArr[k]=arr[j];
                k++;
            }
            //System.out.println("Temp arry is "+Arrays.toString(tempArr));
            newArr[i]=median(tempArr);

        }
    }

    else
    {
        MedianParrallel left = new MedianParrallel(low,(low+high)/2,arr,newArr,tempArr,size);
        MedianParrallel right = new MedianParrallel((low+high)/2,high,arr,newArr,tempArr,size);
       left.fork();
       right.compute();
       left.join();
    }


}


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
