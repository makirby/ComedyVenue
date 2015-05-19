package ssd.comedyvenue.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssd.comedyvenue.ui.Startup;

public class App {

    public static void main(String[] args){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Startup init = new Startup();



    }
}
