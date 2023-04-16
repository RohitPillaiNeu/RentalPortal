package portal.src.main.java.com.portal.RentalApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.portal.RentalApp.dao","com.portal.RentalApp.pojo","com.portal.RentalApp.controller"})
public class PortalApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path","/Rental");
		SpringApplication.run(PortalApplication.class, args);
	}

}
