package pac1;

public class Foo extends Hobbit {
	
	
 public static void main(String[] args) {
	 Foo f =  new Foo();
 int myGold = 7;
 System.out.println(f.countGold((short) myGold, (short) 6));
 }
 }
 class Hobbit {
int countGold(short x, short y) { return x + y; }
 }