package it.academy.main;

import it.academy.task8_10.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@ComponentScan("it.academy")
//@ComponentScan.Filter( type = FilterType.ANNOTATION, classes = TestAnnotation.class)
//@ComponentScan(includeFilters = )
public class AppConfig {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(AppConfig.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        Person person=context.getBean("person", Person.class);
        System.out.println(person);
    }
}
