package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("销毁掉一个req");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("创建了一个req");
	}

}
