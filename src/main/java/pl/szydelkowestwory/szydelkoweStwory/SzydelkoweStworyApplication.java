package pl.szydelkowestwory.szydelkoweStwory;

import org.hibernate.type.LocalDateType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.szydelkowestwory.szydelkoweStwory.model.Klient;

import java.time.LocalDate;

@SpringBootApplication
public class SzydelkoweStworyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SzydelkoweStworyApplication.class, args);


	}


}
