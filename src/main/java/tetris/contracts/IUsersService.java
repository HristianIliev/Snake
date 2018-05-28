package tetris.contracts;

import tetris.dbmodels.User;

public interface IUsersService{
  boolean create(User user);
}
