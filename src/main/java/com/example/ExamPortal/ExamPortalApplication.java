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
//		User user =new User();
//		user.setName("Nicole");
//		user.setEmail("shubhamj010@icloud.com");
//		user.setPassword("111");
//		user.setAbout("I love her so much");
//		List<UserRole> userRoles=new ArrayList<>();
//		userRoles.add(UserRole.builder().role(Role.builder().roleId(2L).roleName("ADMIN").build()).user(user).build());
//		userRoles.add(UserRole.builder().role(Role.builder().roleId(1L).roleName("USER").build()).user(user).build());
//		User user1=this.userService.createUser(user,userRoles);
//		System.out.println(user1.getName());


	}
}
