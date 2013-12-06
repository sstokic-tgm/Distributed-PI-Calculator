package pitirut_stokic.client;

import java.math.BigDecimal;
import java.rmi.registry.*;
import pitirut_stokic.server.*;

public class Client {

	public static void main(String args[]) {
        if (System.getSecurityManager() == null) {
            
        	System.setProperty("java.security.policy", "file:./policy/pi.policy");
        	System.setSecurityManager(new SecurityManager());
        }
        
        try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry(args[0], Registry.REGISTRY_PORT); // IP Adresse und Port.
            Compute comp = (Compute) registry.lookup(name);
            Pi task = new Pi(Integer.parseInt(args[1])); // Laenge von PI
            BigDecimal pi = comp.executeTask(task);
            System.out.println(pi);
        } catch (Exception e) {
        	
            System.err.println("Client exception:");
            e.printStackTrace();
            System.exit(-1);
        }
    }    
}
