package tetris.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tetris.contracts.IRepository;
import tetris.contracts.IUsersService;
import tetris.dbmodels.User;

import java.util.ArrayList;

@Service
public class UsersService implements IUsersService {
  private final IRepository<User> usersRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UsersService(IRepository<User> usersRepository,
                      PasswordEncoder passwordEncoder) {
    this.usersRepository = usersRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public User getUserByUsername(String username) {
    return usersRepository.getAll()
            .stream()
            .filter(u -> u.getUsername().equals(username))
            .findFirst()
            .orElse(null);
  }

  @Override
  public void create(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    usersRepository.create(user);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = getUserByUsername(username);
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
  }
}
