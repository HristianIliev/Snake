package tetris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tetris.contracts.IUsersService;
import tetris.dbmodels.User;

@RestController
@RequestMapping("/api")
public class UsersController {
  private final IUsersService usersService;

  @Autowired
  public UsersController(IUsersService usersService){
    this.usersService = usersService;
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public boolean register(@RequestBody User user){
    return this.usersService.create(user);
  }
}
