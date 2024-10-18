package spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.dbConnection;

public class MainCore {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext applicationContext
		
			   = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ItemRepo item = applicationContext.getBean("ItemsRepo" , ItemRepo.class);
		
		
        item itemData = item.getItembyId("42");
        
        System.out.println(itemData.getName());
        
        applicationContext.close();
	
	}
}
