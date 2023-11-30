package com.example.ExamPortal;

import com.example.ExamPortal.Service.Impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ExamPortalApplication implements CommandLineRunner {

	private final UserServiceImpl userService;
	public static void main(String[] args)
	{
		SpringApplication.run(ExamPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("RUN");



	}
}
