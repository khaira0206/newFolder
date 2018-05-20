package Threads;

public class ThreadA {

	public static void main(String args[]){
		
		ThreadB b = new ThreadB();
		b.start();
		
		synchronized(b){
			System.out.println("Waiting for b to complete");
			try {
				b.wait();
			} catch (InterruptedException e){}
			
			System.out.println("Toatl is: " +b.total);
		}
		
	}
	

	
}

class ThreadB extends Thread{
	int total;
	
	public void run(){
		synchronized(this){
			for(int i = 0; i <= 100; i++){
				total += i;
			}
			System.out.println("Toatl is: " +total);
			notify();
			
		}
	}
	
}