package com.example.financial_accounting_system;

import com.example.financial_accounting_system.entity.*;
import com.example.financial_accounting_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FinancialAccountingSystemApplication implements CommandLineRunner {
    @Autowired
    CategoryService categoryService;
    @Autowired
    TransactionService transactionService;
    @Autowired
    UserService userService;
    @Autowired
    AccountService accountService;
    @Autowired
    ClientService clientService;
    public static void main(String[] args) {
        SpringApplication.run(FinancialAccountingSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {



        Category category = Category.builder()
                .name("Salary")
                .type("Income")
                .build();
        categoryService.save(category); // Сохранение категории
        //System.out.println("Сохранённая категория: " + categoryService.findById(category.getId()));


        User user = User.builder()
                .email("user1@example.com")
                .passwordHash("hashedpassword")
                .role("admin")
                .username("admin_user")
                .build();
        userService.save(user); // Сохранение пользователя
        System.out.println("Сохранённый пользователь: " + userService.findById(user.getId()));


        Account account = Account.builder()
                .accountName("Corporate Account")
                .balance(1000.0)
                .currency("USD")
                .status("active")
                .user(user)
                .build();
        accountService.save(account); // Сохранение аккаунта
        System.out.println("Сохранённый аккаунт: " + accountService.findById(account.getId()));


        Client client = Client.builder()
                .name("Client 1")
                .address("123 Business St.")
                .contactInfo("client1@example.com")
                .build();
        clientService.save(client); // Сохранение клиента
        System.out.println("Сохранённый клиент: " + clientService.findById(client.getId()));

        // 5. Работа с Transaction
        Transaction transaction = Transaction.builder()
                .amount(500.0)
                .date(java.time.LocalDateTime.now().atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli())
                .description("Payment for services")
                .type("expense")
                .account(account)
                .category(category)
                .client(client)
                .user(user)
                .build();
        transactionService.save(transaction); // Сохранение транзакции
       // System.out.println("Сохранённая транзакция: " + transactionService.findById(transaction.getId()));

        System.out.println("Все категории: ");
        List<Category> categories = categoryService.findAll();
        categories.forEach(System.out::println);

        System.out.println("Все пользователи: ");
        List<User> users = userService.findAll();
        users.forEach(System.out::println);

        System.out.println("Все аккаунты: ");
        List<Account> accounts = accountService.findAll();
        accounts.forEach(System.out::println);

        System.out.println("Все клиенты: ");
        List<Client> clients = clientService.findAll();
        clients.forEach(System.out::println);

        System.out.println("Все транзакции: ");
        List<Transaction> transactions = transactionService.findAll();
        transactions.forEach(System.out::println);

        category.setName("Updated Salary");
        categoryService.update(category);
       // System.out.println("Обновлённая категория: " + categoryService.findById(category.getId()));

        account.setBalance(2000.0);
        accountService.update(account);
        System.out.println("Обновлённый аккаунт: " + accountService.findById(account.getId()));


      //  transactionService.delete(transaction.getId());
        //System.out.println("Транзакция удалена. Все транзакции: " + transactionService.findAll());

   //     clientService.delete(client.getId());
        System.out.println("Клиент удалён. Все клиенты: " + clientService.findAll());

       // userService.delete(user.getId());
        System.out.println("Пользователь удалён. Все пользователи: " + userService.findAll());
    }
}


