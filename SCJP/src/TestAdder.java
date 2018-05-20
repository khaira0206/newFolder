class Adder {
public int addThem(int x, int y) {
return x + y;
}
public int addThem(short x, short y) {
	System.out.println("Short one");
return x + y;
}
// Overload the addThem method to add doubles instead of ints
public double addThem(double x, double y) {
return x + y;
}
}
// From another class, invoke the addThem() method
public class TestAdder {
public static void main (String [] args) {
Adder a = new Adder();
short b = 27;
short c = 3;
int result = a.addThem((int)b,c); // Which addThem is invoked?
double doubleResult = a.addThem(22.5,9.3); // Which addThem?
System.out.println(result);
System.out.println(doubleResult);
}
}