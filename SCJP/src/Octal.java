class Octal {
	
	int[] arr;
	String s = "Fred";
 String t = s; // Now t and s refer to the same
	// String object
	 

	 
	public void pp(){
		t.toUpperCase();
		System.out.println( t +" "+ s);
		Boolean b = new Boolean("fals");
		if (!b){
			System.out.println("Hello");
		}
		
		Integer i3 = 128;
		int i4 = 128;
		if(i3 == i4) System.out.println("same object");
		if(i3.equals(i4)) System.out.println("meaningfully equal");
		
	}
	
public static void main(String [] args) {
int six = 06; // Equal to decimal 6
int seven = 07; // Equal to decimal 7
int eight = 01010; // Equal to decimal 8
int nine = 011; // Equal to decimal 9
//System.out.println("Octal 010 = " + eight);
Octal oc = new Octal();
oc.pp();
int x = 0Xf1;
int y = 0x7fffffff;
int z = 0xDeadCafe;
//System.out.println("x = " + x + " y = " + y + " z = " + z);

char c = '\"'; // A double quote
char d = '\n';
byte b = (byte)128;
byte e ;
//System.out.println("literals = " + b );
}
}