package ssd.comedyvenue.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import ssd.comedyvenue.ui.Startup;

public class App {

    public static void main(String[] args){

       ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Startup init = new Startup();

        init.createComedian();

    }
}
