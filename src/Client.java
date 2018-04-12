import java.util.Scanner;
import cabd.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;

public class Client {

	static Calculator implementation;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		try {
			ORB orb = ORB.init(args, null);
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			String name = "Implementation";
			implementation = CalculatorHelper.narrow(ncRef.resolve_str(name));
			int choice = 1;
			while (choice != 0) {
				System.out.println("What operation would you like to do?:\n 1.Sum\n 2.Subtract\n 3.Multiply\n 4.Divide\n 0.Exit");
				choice = sc.nextInt();
				System.out.println("Enter first number");
				int a = sc.nextInt();
				System.out.println("Enter second number: ");
				int b = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Sum result: " + Integer.toString(implementation.sumar(a, b)) );
				break;
				case 2:
					System.out.println("Subtrac result: " + Integer.toString(implementation.restar(a, b)) );
				break;
				case 3:
					System.out.println("Multiply result: " + Integer.toString(implementation.multiplicar(a, b)) );
				break;
				case 4:
					System.out.println("Divide result: " + Integer.toString(implementation.dividir(a, b)) );
				break;
				case 0:
					implementation.shutdown();
					sc.close();
				break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
