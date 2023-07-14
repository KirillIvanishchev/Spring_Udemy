package com.demoapp.springCoreDemo.config;

import com.demoapp.springCoreDemo.common.DemoBeanAnnotation;
import com.demoapp.springCoreDemo.common.DemoInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanAnnotationConfig {
    // @Bean Annotation is used to create a Spring Bean from the THIRD PARTY CLASS
    //Basically from a class, that does not have ANY connections with the rest of the application.
    //As an example here: DemoBeanAnnotation class. He has no @Component annotation, and not connected to the rest of the application.
    //We link this class through the @Bean annotation, and creating an instance of this class through method.
    //So connecting this class with this Spring application.

    //We can use simple @Bean annotation, and @Bean("<UNIQUE_ID>") annotation.
    //@Bean annotation connects through method name. @Bean("<UNIQUE_ID>") annotation connects through UNIQUE_ID.
    //Example:
    @Bean("any_unique_id_name")
    public DemoInterface demoBeanAnnotation() {
        return new DemoBeanAnnotation();
    }
}
