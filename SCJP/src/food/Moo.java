package food;
import pac1.*;
public class Moo extends Zoo {

	public void useMyCoolMethod() {
		// Does an instance of Moo inherit the coolMethod()?
		System.out.println("Moo says, " + this.coolMethod());
		// The preceding line works because Moo can inherit the
		// public method
		// Can an instance of Moo invoke coolMethod() on an
		// instance of Zoo?
		Zoo z = new Zoo();
	//	System.out.println("Zoo says, " + z.coolMethod());
		// coolMethod() is public, so Moo can invoke it on a Zoo
		//reference
		}
	
}
