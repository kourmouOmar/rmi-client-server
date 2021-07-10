import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.net.*;

/**
 * The server creates a RemImpl (which implements the Rem interface), then
 * registers it with the URL Rem, where clients can access it.
 */

public class RemServer {
	public static void main(String[] args) {

		String port = (args.length > 0) ? args[0] : "1099";

		try {
				LocateRegistry.createRegistry(Integer.parseInt(port));
				RemImpl localObject = new RemImpl();
				Naming.rebind("rmi://localhost:" + port + "/Rem", localObject);
				System.out.println("Server connected :) ");

				
		} catch (RemoteException re) {
			System.out.println("RemoteException: " + re);
		} catch (MalformedURLException mfe) {
			System.out.println("MalformedURLException: " + mfe);
		}
	}
}
