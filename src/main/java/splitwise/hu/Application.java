package splitwise.hu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import javax.servlet.annotation.WebServlet;

@SpringBootApplication
public class Application{

  public static void main(String[] args) {
    SpringApplication.run(Application.class,args);
  }

//  @Bean
//  public ServletRegistrationBean h2servletRegistration() {
//    ServletRegistrationBean registrationBean = new ServletRegistrationBean(WebServlet());
//    registrationBean.addUrlMappings("/console/*");
//    return registrationBean;
//  }
}
