package jbr.springmvc.dao;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;



import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public interface UserDao {

  int register(User user);

  User validateUser(Login login);
  List<User> showAllUsers();
  
  List<User> list();
  void marshallUsers() throws JAXBException,IOException;
  
  public List<User> unmarshallUsers()throws JAXBException,IOException;
}
