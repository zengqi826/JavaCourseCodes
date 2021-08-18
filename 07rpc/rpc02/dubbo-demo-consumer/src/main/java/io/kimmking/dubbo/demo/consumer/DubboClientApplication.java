package io.kimmking.dubbo.demo.consumer;

import io.kimmking.dubbo.demo.api.entity.Account;
import io.kimmking.dubbo.demo.api.service.OrderService;
import io.kimmking.dubbo.demo.api.service.TransferService;
import io.kimmking.dubbo.demo.api.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class DubboClientApplication {

	@DubboReference(version = "1.0.0") //, url = "dubbo://127.0.0.1:12345")
	private UserService userService;

	@DubboReference(version = "1.0.0") //, url = "dubbo://127.0.0.1:12345")
	private OrderService orderService;

	@DubboReference(version = "1.0.0") //, url = "dubbo://127.0.0.1:12345")
	private TransferService transferService;


	public static void main(String[] args) {

		SpringApplication.run(DubboClientApplication.class).close();

		// UserService service = new xxx();
		// service.findById

//		UserService userService = Rpcfx.create(UserService.class, "http://localhost:8080/");
//		User user = userService.findById(1);
//		System.out.println("find user id=1 from server: " + user.getName());
//
//		OrderService orderService = Rpcfx.create(OrderService.class, "http://localhost:8080/");
//		Order order = orderService.findOrderById(1992129);
//		System.out.println(String.format("find order name=%s, amount=%f",order.getName(),order.getAmount()));

	}

	@Bean
	public ApplicationRunner runner() {
		return args -> {
//			User user = userService.findById(1);
//			System.out.println("find user id=1 from server: " + user.getName());
//			Order order = orderService.findOrderById(1992129);
//			System.out.println(String.format("find order name=%s, amount=%f",order.getName(),order.getAmount()));

			//测试转账效果
			System.out.println(transferService.findAccountByUserId(1));
			System.out.println(transferService.findAccountByUserId(2));

			Account account1 = new Account();
			account1.setCny(BigDecimal.valueOf(700));
			account1.setUserId(1);
			Account account2 = new Account();
			account2.setUsd(BigDecimal.valueOf(100));
			account2.setUserId(2);
			Boolean transfer1 = transferService.transfer(1, account1);
			System.out.println(transfer1);
			System.out.println(transferService.findAccountByUserId(1));
			Boolean transfer2 = transferService.transfer(2,account2);
			System.out.println(transfer2);
			System.out.println(transferService.findAccountByUserId(2));

		};
	}

}
