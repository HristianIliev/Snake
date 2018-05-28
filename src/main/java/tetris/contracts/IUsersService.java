package tetris.contracts;

import org.springframework.security.core.userdetails.UserDetailsService;
import tetris.dbmodels.User;

public interface IUsersService extends UserDetailsService {
  User getUserByUsername(String username);

  void create(User user);
}
