import cabd.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;


class CalculatorImpl extends CalculatorPOA{
    private ORB orb;

    public void setORB(ORB orb_val) {   
        orb = orb_val;
    }
    
    public int sumar(int x, int y){
        int res= x+y;
        return res;
    }

    public int restar(int x, int y){
        int res= x-y;
        return res;
    }

    public int multiplicar(int x, int y){
        int res= x*y;
        return res;
    }
    
    public int dividir(int x, int y){
        int res= x/y;
        return res;
    }


    public void shutdown(){
            orb.shutdown(false);
    }
}

public class Server {
	
	public static void main(String args[]) {
		try {
			ORB orb = ORB.init(args, null);
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();
			CalculatorImpl calcImpl = new CalculatorImpl();
			calcImpl.setORB(orb);
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(calcImpl);
			Calculator calc = CalculatorHelper.narrow(ref);
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			String name = "Implementation";
			NameComponent path[] = ncRef.to_name(name);
			ncRef.rebind(path, calc);
			System.out.println("Server ready waiting for new request");
			orb.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
