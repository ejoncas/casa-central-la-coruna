package uade.web.listener;

import is2.uade.test.InitializeDataBase;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.junit.runner.JUnitCore;

public class DataBaseInitialization implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
	}

	public void contextInitialized(ServletContextEvent arg0) {
		JUnitCore.runClasses(InitializeDataBase.class);
	}

}
