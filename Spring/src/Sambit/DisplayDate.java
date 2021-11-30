package Sambit;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DisplayDate {
    public static void main(String args[]) {
        Resource resource = new ClassPathResource("Context.xml");
        BeanFactory factory = new XmlBeanFactory(resource);


        Object ob = factory.getBean("date2");
        Date1 d = (Date1) ob;
        System.out.println(d.display());
    }

}
