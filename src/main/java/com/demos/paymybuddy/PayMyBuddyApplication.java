package com.demos.paymybuddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication()
public class PayMyBuddyApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayMyBuddyApplication.class, args);
    }


/*    @Bean
    CommandLineRunner start(CustomUserRepository userRepository, AccountRepository accountRepository) {
        return args -> {
            userRepository.findAll().forEach(user -> {
                Account account = accountRepository.findById(user.getId()).orElse(null);
                if (account != null) {
                    user.setAccount(account);
                    account.setOwner(user);
                    userRepository.save(user);
                    accountRepository.save(account);
                }
            });
        };
    }*/

/*    @Bean
    CommandLineRunner start(CustomUserRepository userRepository) {
        return args -> {

            Random random = new Random();
            List<CustomUser> users = userRepository.findAll();

            for (CustomUser user : users) {
                List<CustomUser> friendIds = new ArrayList<>();
                int numFriends = random.nextInt(10);

                for (int i = 0; i < numFriends; i++) {
                    // Generate a random friend ID between 1 and 203 (excluding the user's own ID)
                    Long friendId = (long) (random.nextInt(202) + 1);
                    if (friendId >= user.getId()) {
                        friendId++; // Skip the user's own ID
                    }
                    friendIds.add(userRepository.findById(friendId).orElse(null));
                }
                user.setFriendsList(friendIds);
                userRepository.save(user);
            }
        };
    }

    @Bean
    CommandLineRunner start(CustomUserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            List<CustomUser> users = userRepository.findAll().stream().filter(user -> (user.getId() != 206 && user.getId() != 207 && user.getId() != 208)).collect(Collectors.toList());
            users.forEach(user -> {
                user.setPassword(passwordEncoder.encode(user.getUsername()));
                userRepository.save(user);
            });
        };
    }
    */

}
