package co.edu.uco.tiendachepito.config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco.tiendachepito.api.controller"})
public class TiendachepitoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiendachepitoApplication.class, args);
    }

}
