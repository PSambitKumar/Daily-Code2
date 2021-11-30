package Spring;
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext; 
public class Test {
	public static void main(String[] args) {  
	    ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
	      
	    EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");  
	    dao.saveEmployee(new Employee(2,"Sambit",25000));
	    System.out.println("Data Updates");
	          
	    
	      
	}  
	  

}
