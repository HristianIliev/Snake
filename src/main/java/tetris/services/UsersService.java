package tetris.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tetris.contracts.IRepository;
import tetris.contracts.IUsersService;
import tetris.dbmodels.User;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService implements IUsersService {
  private final IRepository<User> usersRepository;

  @Autowired
  public UsersService(IRepository<User> usersRepository) {
    this.usersRepository = usersRepository;
  }

  @Override
  public User create(User user) {
    if (doesExist(user)) {
      return null;
    }

    return this.usersRepository.create(user);
  }

  @Override
  public User getUser(int id) {
    return this.usersRepository.getById(id);
  }

  @Override
  public User updateHighScore(int id, int highScore) {
    User user = this.usersRepository.getById(id);

    user.setHighScore(highScore);

    this.usersRepository.update(user);

    return user;
  }

  @Override
  public List<User> leaderboard() {
    return this.usersRepository.getAll().stream()
            .sorted((o1, o2) -> {
              if (o1.getHighScore() < o2.getHighScore()) {
                return 1;
              } else if (o1.getHighScore() == o2.getHighScore()) {
                return 0;
              }

              return -1;
            })
            .collect(Collectors.toList());
  }

  private boolean doesExist(User user) {
    List<User> users = this.usersRepository.getAll().stream()
            .filter(u -> u.getUsername().equals(user.getUsername()))
            .collect(Collectors.toList());

    return users.size() != 0;
  }
}
