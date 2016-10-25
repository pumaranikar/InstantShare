package swift;

import org.javaswift.joss.client.factory.AccountConfig;
import org.javaswift.joss.client.factory.AccountFactory;
import org.javaswift.joss.client.factory.AuthenticationMethod;
import org.javaswift.joss.model.Account;
import org.javaswift.joss.model.Container;

public class swift_test {

	
	static String auth = "http://172.99.106.175:8080/auth/v1.0";
	static String username = "tester";
	static String password = "testing";
	//static String tenantID = "ddd81f9ab03f45e09196169abceaec6f";
	
	
	public void auth(){
		
	    AccountConfig config = new AccountConfig();
	    config.setPassword(password);
	    config.setUsername(username);
	    config.setAuthUrl(auth);
	    //config.setTenantId(tenantID);
	   //config.setTenantName("osic-engineering");
	    
	    System.out.println(config.getAuthUrl());
	    config.setAuthenticationMethod(AuthenticationMethod.TEMPAUTH);
	    Account account =new AccountFactory(config).createAccount();
	    
	    System.out.println(account.authenticate());
	    
	    //Container container = account.getContainer("sumant_test");
	    //container.create();
	    //container.makePublic();
	}
	
	public static void main(String[] args) {
		
		swift_test a = new swift_test();
		a.auth();
	}
	
	
	
}
