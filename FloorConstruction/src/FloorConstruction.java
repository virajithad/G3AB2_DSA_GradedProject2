import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class NewCompare implements Comparator
{
	public int compare(Object obj1,Object obj2)
    {
 
     Integer i1=(Integer)obj1;
 
     Integer i2=(Integer)obj2;
 
     return i2.compareTo(i1);
 
    }
}

class FloorConstruction
{
    public static void main(String args[])throws IOException
    {
    	Scanner scanner = new Scanner(System.in);
    
        int n;
        System.out.println("Enter the total number of floors in the building");
        n=scanner.nextInt();
        int a[]=new int[n];

        for(int i=0;i<n;i++)
        {
        	int day = i + 1;
        	System.out.println("enter the floor size given on day :" + day );
            a[i]=scanner.nextInt();
        }
        
        int max=n;
        Queue<Integer> queue=new PriorityQueue<Integer>(new NewCompare());
        System.out.println("The order of construction is as follows");
        
        for(int i=0;i<n;i++)
        {
        
         int daycounter = i+1;
         System.out.println("Day: "+ daycounter);
         
         queue.add(a[i]);
         
         while(!queue.isEmpty() && queue.peek()==max)
         {
             System.out.print(queue.poll() + " ");
             max--;
         }
         
         System.out.println();

         }
         scanner.close();
      }

  }