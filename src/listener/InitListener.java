package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dao.ConnectionManager;

@WebListener
public class InitListener implements ServletContextListener{

    public void contextDestroyed(ServletContextEvent arg0)  { 
    	ConnectionManager.close();
    }

    public void contextInitialized(ServletContextEvent event)  {
    	System.out.println("inicijalizacija...");

    	ConnectionManager.open();

		System.out.println("Uspesno!");
    }
}
