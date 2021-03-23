package jbr.springmvc.service;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;

import jbr.springmvc.dao.UserDao;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public int register(User user) {
    return userDao.register(user);
  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }

@Override
public List<User> showAllUsers() {
	// TODO Auto-generated method stub
	return userDao.showAllUsers();
}

@Override
public List<User> list() {
	// TODO Auto-generated method stub
	return userDao.list();
}

@Override
public void marshallUsers() {
try {
	userDao.marshallUsers();
} catch (JAXBException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
}

@Override
public List<User> unmarshallUsers() {
	try {
		return userDao.unmarshallUsers();
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
}

}
