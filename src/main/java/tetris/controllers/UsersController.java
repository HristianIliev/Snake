package tetris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tetris.contracts.IUsersService;
import tetris.dbmodels.User;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {
  private final IUsersService usersService;

  @Autowired
  public UsersController(IUsersService usersService){
    this.usersService = usersService;
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  @ResponseBody
  public User register(@RequestBody User user){
    return this.usersService.create(user);
  }

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  @ResponseBody
  public User getUser(@RequestParam("id") int id){
    return this.usersService.getUser(id);
  }

  @RequestMapping(value = "/updateHighScore", method = RequestMethod.GET)
  public void updateHighScore(@RequestParam("id") int id,
                              @RequestParam("highScore") int highScore){
    this.usersService.updateHighScore(id, highScore);
  }

  @RequestMapping(value = "/leaderboard", method = RequestMethod.GET)
  public List<User> leaderboard(){
    return this.usersService.leaderboard();
  }
}
