package com.blitmatthew.DemonBook;

import com.blitmatthew.DemonBook.entity.Demon;
import com.blitmatthew.DemonBook.repository.DemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemonBookApplication implements CommandLineRunner {

	@Autowired
	private DemonRepository demonRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemonBookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Demon demon = new Demon("Valik", 7.56, 450.56, "Monster of the great plains of Jerginstan");
		demonRepository.save(demon);
	}
}
