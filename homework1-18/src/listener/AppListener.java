package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("销毁con域对象");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("创建con域对象");
	}

}
