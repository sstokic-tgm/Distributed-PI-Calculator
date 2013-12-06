package pitirut_stokic.server;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.*;

public class Server implements Compute {

	private static String name = "Compute";

	public Server() {
		super();
	}

	public <T> T executeTask(Task<T> t) {
		return t.execute();
	}

	public static void main(String[] args) {

		if(args[0] == null) {

			System.out.println("No arguments!");
			System.exit(-1);
		}

		if (System.getSecurityManager() == null) {
			System.setProperty("java.security.policy", "file:./policy/pi.policy");
			System.setSecurityManager(new SecurityManager());
		}

		try {
			//LocateRegistry.getRegistry().unbind(name);
			Compute engine = new Server();

			Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
			Registry registry = LocateRegistry.createRegistry(Integer.parseInt(args[0]));
			registry.rebind(name, stub);
			System.out.println("Server bound");



		} catch (Exception e) {

			System.err.println("Server exception:");
			e.printStackTrace();
			System.exit(-1);
		}
	}
}