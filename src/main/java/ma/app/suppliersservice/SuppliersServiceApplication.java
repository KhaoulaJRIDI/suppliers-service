package ma.app.suppliersservice;


import ma.app.suppliersservice.entities.Supplier;
import ma.app.suppliersservice.repositories.SupplierRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;
@SpringBootApplication
public class SuppliersServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SuppliersServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner lineRunner(SupplierRepository supplierRepository){
        return args -> {
            Stream.of("JBOSS","ORACLE","IBM").forEach(n->{
                supplierRepository.save(new Supplier(null,n,n+"@"+n.toLowerCase()+".com"));
            });
        };
    }
}
