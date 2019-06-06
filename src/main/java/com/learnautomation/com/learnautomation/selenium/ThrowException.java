package com.learnautomation.com.learnautomation.selenium;

interface example{
	public void run();
}
class emapleClass implements example{

	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
}

class y implements example{
	private int i = 23 ;
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	y(){}
	{System.out.println("i am in y");}
	class x{
	
		
	    x(){
	    	System.out.println(i);
	    	
	    	
	    }
	}
	
}





public class ThrowException {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		y yy = new y();
		y.x yx = yy.new x();
	}
}