package com.hibernet.demo.springIntigration;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class SpringHibernateMain {

	public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("springIntrgration.xml");
		
    EmpserviceImpl empobj=(EmpserviceImpl)context.getBean(EmpserviceImpl.class);
    Employee  emp=new Employee(101, "sonali", "karad");
    empobj.save(emp);
    System.out.println("employee ::"+emp);
    List<Employee>list=empobj.emplist();
       for (Employee e : list) {
    	   System.out.println("employee list ::"+e);
		
	}
         /*
		Person person = new Person();
		person.setName("Pankaj"); person.setCountry("India");
		
		personDAO.save(person);
		
		System.out.println("Person::"+person);
		
		List<Person> list = personDAO.list();
		
		for(Person p : list){
			System.out.println("Person List::"+p);
		}*/
		//close resources
		//context.close();	
	}

}
