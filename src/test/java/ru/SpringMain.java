package ru;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.clients.web.client.ClientRestController;

import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        // java 7 automatic resource management
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml","spring/spring-db.xml")) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            ClientRestController ClientController = appCtx.getBean(ClientRestController.class);

            System.out.println();


        }
    }
}
