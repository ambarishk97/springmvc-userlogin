package jbr.springmvc.service;

import java.util.List;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public interface UserService {

  int register(User user);

  User validateUser(Login login);
  
   List<User> showAllUsers();
   
   List<User> list();
   
   void marshallUsers();
   
   List<User> unmarshallUsers();
}
