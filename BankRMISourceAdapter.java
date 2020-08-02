import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.naming.CommunicationException;

public class BankRMISourceAdapter implements IBank
{
	private IBankRMITargetAdapter bank;
	
	public BankRMISourceAdapter(String whereServer) throws CommunicationException
	{
		System.err.println("Source Adapter ready");
		connect(whereServer);
	}
	
	public void connect(String server) throws CommunicationException
	{
		try
		{
			bank = (IBankRMITargetAdapter) Naming.lookup(server);
			System.err.println("Remote connection with Target Adapter successful"); 
		}
		catch (Exception e)
		{
			System.err.println("Server not found."); 
			throw new CommunicationException();
		}

	}
	
	@Override
	public void deposit (String accountNumber, double value)throws CommunicationException,UnknownAccountException
	{
		try
		{
			bank.deposit(accountNumber,value);
		}
		catch (RemoteException e)
		{
				throw new CommunicationException();
		}
	}

}
