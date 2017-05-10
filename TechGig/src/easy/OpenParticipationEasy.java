package easy;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class OpenParticipationEasy {
	 static ArrayList sumList=new ArrayList<>();
	
	public static void combination(int[] input1,int [] data,int start,int end,int index,int r,int multiple)
	{ 
	   int sum=0;
	    if(index==r)
	    {   
	        for(int j=0;j<r;j++)
	        {
	            sum+=data[j];
	        }
	            if(sum%multiple==0)
	            {
	             sumList.add(sum);
	            }
	     
	}
	for(int i=start;i<=end && end-i+1>=r-index;i++)
	{
	    data[index]=input1[i];
	    combination(input1,data,i+1,end,index+1,r,multiple);
	}


	}
	 public static int ball_count(int[] input1,int input2,int input3)
	    { 
		 if(input1==null)
		    {
		        return -1;
		    }
		 int N=input1.length;
		   int data[]=new int[N];
		 combination(input1,data,0,N-1,0,input3,input2);
		 if(sumList !=null){
		 Collections.sort(sumList, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1,Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		 //System.out.println(sumList.size()+sumList.toString());
		 return (int) sumList.get(0);
		 }
		 else {
			 return -1;
		 }
	    } 
	    
	 public static void main(String[] args) throws IOException{
	        Scanner in = new Scanner(System.in);
	        int output = 0;
	        int ip1_size = 0;
	        
	        ip1_size = Integer.parseInt(in.nextLine().trim());
	       
	        int[] ip1 = new int[ip1_size];
	        int ip1_item;
	        for(int ip1_i = 0; ip1_i < ip1_size; ip1_i++) {
	            ip1_item = Integer.parseInt(in.nextLine().trim());
	            ip1[ip1_i] = ip1_item;
	        }
	        int ip2 = Integer.parseInt(in.nextLine().trim());
	        int ip3 = Integer.parseInt(in.nextLine().trim());
	        output = ball_count(ip1,ip2,ip3);
	        System.out.println(String.valueOf(output));
	    }
}
