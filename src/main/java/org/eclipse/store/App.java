package org.eclipse.store;

import org.eclipse.daos.UserDAO;
import org.eclipse.models.Admin;
import org.eclipse.models.Client;
import org.eclipse.models.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Hello world!
 *
 */
public class App 
{
	@Autowired
	static UserDAO userDao;
    public static void main( String[] args )
    {
    	userDao.add(new Admin(5,"test@test.Com", "123456", "Jacer sfar"));
    	userDao.add(new Client(1, "test2@test.com", "1234567","OussamaBen hammouda"));
    	for (User u: userDao.find()) {
    		System.out.println(u);
    	}
    }
}
