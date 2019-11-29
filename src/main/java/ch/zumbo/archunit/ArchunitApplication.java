package ch.zumbo.archunit;


import ch.zumbo.archunit.infrastructure.UserInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ArchunitApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		UserInterface ui = context.getBean(UserInterface.class);
		String data = ui.getSomeData();
		System.out.println(data);
	}

}
