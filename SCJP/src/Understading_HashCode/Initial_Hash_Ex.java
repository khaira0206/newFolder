package Understading_HashCode;

public class Initial_Hash_Ex {

	int x;
	
	// if we call equals method without overriding equals method it will print objects are not same
	public Initial_Hash_Ex(int x) {
		this.x = x;
	}
	int getValue(){
		return x;
	}
	
	 // now override equals methods
	public boolean equals(Object o){
		
		if((o instanceof Initial_Hash_Ex) && ((Initial_Hash_Ex) o).getValue() == this.getValue() ){
			
			return true;
		}
		return false;
	}
	
	
	
	public static void main(String[] arg){
	
		Initial_Hash_Ex obj1 = new Initial_Hash_Ex(1);
		Initial_Hash_Ex obj2 = new Initial_Hash_Ex(2);
	
		
		if(obj1.equals(obj2)){
			System.out.println("objects are same");
		}
		else{
			System.out.println("object are not same");
		}
		
		
		
		
	}

}
