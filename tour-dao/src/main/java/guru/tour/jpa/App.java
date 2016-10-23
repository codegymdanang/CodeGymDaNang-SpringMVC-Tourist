package guru.tour.jpa;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import guru.tour.entity.RoleEntity;
import guru.tour.entity.UserEntity;
import guru.tour.repository.UserEntityRepository;


public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-data.xml");
        
        UserEntityRepository userRepository = (UserEntityRepository) context.getBean("userEntityRepository");
        
        UserEntity user = userRepository.findByUsername("Toan");
        
        System.out.println();
        System.out.println(user.toString());
        
        RoleEntity role = user.getRoles().iterator().next();
        
        System.out.println(role.toString());
        System.out.println();
        user.setDiadiem("Quảng Nam");       
        Thread.sleep(1000);
        
        userRepository.save(user);
        Thread.sleep(1000);
        user = userRepository.findOne(1);
        System.out.println();
        role = user.getRoles().iterator().next();
        System.out.println(role.toString());
        
    }
}
