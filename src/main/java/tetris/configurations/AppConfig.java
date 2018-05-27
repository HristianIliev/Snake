package tetris.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tetris.contracts.IRepository;
import tetris.dbmodels.User;
import tetris.repositories.HibernateRepository;

@Configuration
public class AppConfig {
  @Bean
  @Autowired
  IRepository<User> provideUsersGenericRepository() {
    HibernateRepository<User> repository = new HibernateRepository<>();
    repository.setEntityClass(User.class);

    return repository;
  }
}
