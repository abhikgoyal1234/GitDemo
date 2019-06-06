package com.learnautomation.com.learnautomation.selenium;

public class Multi3 implements Runnable{  
	int i ;
	
	private Multi3() {
		i = 25 ;
	} 
	Multi3(int i){
		
	}
	
public void run(){  
System.out.println("thread is running...");  
}  
  
public static void main(String args[]){  
Multi3 m1=new Multi3(); 
int j =m1.i;
Thread t1 =new Thread(m1);  
t1.start();  
 }  
}  

abstract class xyz extends Multi3{
	xyz(){
		super(25);
	}
}