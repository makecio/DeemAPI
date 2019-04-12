package br.com.deem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.deem.utils.AppContext;

@SpringBootApplication
public class AppMain {
	
	public static void main(String[] args){
		
		SpringApplication.run(AppContext.class, args);
	}

}
