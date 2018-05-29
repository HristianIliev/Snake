package tetris.contracts;

import tetris.dbmodels.User;

public interface IUsersService{
  User create(User user);

  User getUser(int id);

  User updateHighScore(int id, int highScore);
}
