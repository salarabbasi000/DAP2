import java.rmi.RemoteException;
import java.util.concurrent.TimeUnit;

import javax.naming.CommunicationException;

public class Source {

	public static void main(String[] args) throws CommunicationException, UnknownAccountException, RemoteException {
		// TODO Auto-generated method stub
		
		//FacadeFactory f=new FacadeFactory();
		//IBank sA= f.createAdapter(args[0]);
		
		IBank sA= new BankRMISourceAdapter("BankServer0");
		
		IBankRMITargetAdapter tA2 = new BankRMITargetAdapter(sA,1);
		
		IBank sA2= new BankRMISourceAdapter("BankServer1");
		
		IBankRMITargetAdapter tA3 = new BankRMITargetAdapter(sA2,2);
		
		IBank sA3= new BankRMISourceAdapter("BankServer2");
		
		IBankRMITargetAdapter tA4 = new BankRMITargetAdapter(sA3,3);
		
		IBank sA4= new BankRMISourceAdapter("BankServer3");
		
		long startTime = System.nanoTime();
		
		sA3.deposit("43203-4280420-1",100000);
		
		long endTime = System.nanoTime();
		long durationInNano = (endTime - startTime);  //Total execution time in nano seconds
	    long durationInMillis = TimeUnit.NANOSECONDS.toMillis(durationInNano);  //Total execution time in nano seconds
	     
	    System.out.println(durationInNano);
	    System.out.println(durationInMillis);
	}

}
