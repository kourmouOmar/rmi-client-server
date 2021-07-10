import java.rmi.*; // For Naming, RemoteException, etc.
import java.net.*; // For MalformedURLException
import java.io.*; // For Serializable interface

/**
 * Get a Rem object from the specified remote host. Use its methods as though it
 * were a local object.
 */

public class RemClient {
	public static void main(String[] args) {
		System.out.println("Client connected :) ");
		try {

			String host = (args.length > 0) ? args[0] : "localhost";
			String port = (args.length > 1) ? args[1] : "1099";
			// Get the remote object and store it in remObject:
			Rem remObject = (Rem) Naming.lookup("rmi://" + host + ":" + port + "/Rem");
			

			 int num = 0;int num1 = 0;
				try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
					System.out.println("Enter number 1:");
					num = Integer.parseInt(in.readLine());
					System.out.println("You typed: " + num);
					System.out.println("Enter number 2:");
					num1 = Integer.parseInt(in.readLine());
					System.out.println("You typed: " + num1);
					System.out.println("Somme = "+remObject.addition(num,num1));
				} catch (Exception e) {
					
					System.out.println("Error while reading the data.");
				}
			
			
			
		
		} catch (RemoteException re) {
			System.out.println("RemoteException: " + re);
		} catch (NotBoundException nbe) {
			System.out.println("NotBoundException: " + nbe);
		} catch (MalformedURLException mfe) {
			System.out.println("MalformedURLException: " + mfe);
		}
	}
}
