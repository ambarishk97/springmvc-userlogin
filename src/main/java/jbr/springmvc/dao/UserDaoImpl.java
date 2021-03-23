package jbr.springmvc.dao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public class UserDaoImpl implements UserDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public int register(User user) {
    String sql = "insert into users values(?,?,?,?,?,?,?)";

    return jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
        user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });
  }

  public User validateUser(Login login) {
    String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
        + "'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());

    return users.size() > 0 ? users.get(0) : null;
  }
  
  public List<User> showAllUsers() {
	 String sql="select * from users";
	 return jdbcTemplate.query(sql,new UserMapper());
	 
  }
  
  public List<User> list() {
	    String sql = "SELECT * FROM users";
	    List<User> listContact = jdbcTemplate.query(sql, new RowMapper<User>() {
	 
	        @Override
	        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	            User aContact = new User();
	 
	            aContact.setUsername(rs.getString("username"));
	            aContact.setPassword(rs.getString("password"));
	            aContact.setFirstname(rs.getString("firstname"));
	            aContact.setLastname(rs.getString("lastname"));
	            aContact.setEmail(rs.getString("email"));
	            aContact.setAddress(rs.getString("address"));
	            aContact.setPhone(rs.getInt("phone"));
	 
	            return aContact;
	        }
	 
	    });
	 
	    return listContact;

}

class UserMapper implements RowMapper<User> {

  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();

    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    user.setFirstname(rs.getString("firstname"));
    user.setLastname(rs.getString("lastname"));
    user.setEmail(rs.getString("email"));
    user.setAddress(rs.getString("address"));
    user.setPhone(rs.getInt("phone"));

    return user;
  }
  
}
 

@Override
public void marshallUsers() throws JAXBException, IOException {
	
	User usersz = new User();
	
	  List<User> users = new ArrayList<>();
		
		users=showAllUsers();
		
		usersz.setUserlist(users);
		
		//Object[] users1=users.toArray();
		
	  
		/*
		 * game.setGameId(1); game.setGameName("Borderlands 3");
		 * game.setgamePublisher("Gearbox");
		 */
		//game.setDate(new Date());
		
		JAXBContext context = JAXBContext.newInstance(User.class);
		Marshaller mar = context.createMarshaller();
		mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		mar.marshal(usersz,new File("C:\\work\\users.xml"));
		System.out.println("users marshalled");
	// TODO Auto-generated method stub
	
}

@SuppressWarnings("unchecked")
@Override
public List<User> unmarshallUsers() throws JAXBException, IOException {
	List<User> am= new ArrayList<>();
	JAXBContext context = JAXBContext.newInstance(User.class);
	User us =(User)context.createUnmarshaller().unmarshal(new FileReader("C:\\work\\users.xml"));
	for(User u : us.getUserlist())
	{
		System.out.println(u.getFirstname());
		System.out.println(u.getLastname());
		System.out.println(u.getEmail());
		
		am.add(u);
		

	}
return am;
}
}