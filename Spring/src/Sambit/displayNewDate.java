package Sambit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class displayNewDate {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "newDate.xml");

        newDate date = (newDate) context.getBean("date1");
        System.out.println(date);

    }
}
