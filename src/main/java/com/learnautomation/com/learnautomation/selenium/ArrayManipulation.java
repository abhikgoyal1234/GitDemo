package com.learnautomation.com.learnautomation.selenium;

public class ArrayManipulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int arr[] = {2,45,7,181,13,46,35,9,5,6,15,18,25,97,8,97};
		
	/*	int count= 3 ;
		
		int arrCopy[] = new int[arr.length];
		int k=0;
		for(int i =0 ; i< arr.length ;i+=3) {
			
			 for(int j=count-1 ; j>=count-3 ; j--) {
				 arrCopy[k] = arr[j] ;
			
				 System.out.println(arrCopy[k]);
				 k++;
			 }
			// count++;
			 count =count+3;
			// i--;
		}*/
		
		int countDup=1 ;
		
		
		for(int t =0 ; t< arr.length ;t++) {
			for(int g=1; g<arr.length-t;g++) {
			if(arr[t]==arr[t+g]) {
				countDup++;
               System.out.println("First duplicate value:"+arr[t]);
               break;
			}
			
		}
			if(countDup>1) {
				break;
			}
	}

}
}