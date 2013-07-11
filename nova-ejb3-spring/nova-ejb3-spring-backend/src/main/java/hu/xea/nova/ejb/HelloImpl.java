package hu.xea.nova.ejb;

import java.rmi.RemoteException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class HelloImpl implements Hello {

	@Override
	public String sayHello() throws RemoteException {
		return "hello";
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void register() throws NamingException {
		final Hashtable environment = new Hashtable();
		environment.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		environment.put(Context.PROVIDER_URL, "t3://localhost:7001");
		
		final Context context = new InitialContext(environment);
		
		context.bind("//localhost/HelloServer", this);
		
		context.close();
	}

}
