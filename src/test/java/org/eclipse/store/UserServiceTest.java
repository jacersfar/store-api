package org.eclipse.store;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import org.eclipse.IDAO.IDAO;
import org.eclipse.models.Client;
import org.eclipse.models.User;
import org.eclipse.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

public class UserServiceTest {
	@Mock
	public IDAO<User> userDAO;

	@InjectMocks
	public UserService userService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void shouldReturnUserList() {
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new Client(1,"ars.jacer.sfar@","123456", "jacer sfar", null, null));
		userList.add(new Client(2,"jacer.sfar@","123456", "jacer sfar", null, null));
		when(userDAO.find()).thenReturn(userList);
		assertTrue("Test failed: Array size is wrong", this.userService.find().size() == userList.size());
		assertTrue("Test failed: First element is not equal to the first element the mocked list",
					this.userService.find().get(0).equals(userList.get(0))
				);
	}
	
	@Test
	public void shouldAddUserSuccessfully() {
		User user = new Client(2,"jacer.sfar@","123456", "jacer sfar", null, null);
		doNothing().when(this.userDAO).add(any(User.class));
		this.userService.add(user);
		verify(this.userDAO, times(1)).add(any(User.class));
	}
	
	@Test
	public void shouldUpdateUserSuccessfully() {
		User user = new Client(2,"jacer.sfar@","123456", "jacer sfar", null, null);
		doNothing().when(this.userDAO).update(any(User.class));
		this.userService.update(user);
		verify(this.userDAO, times(1)).update(any(User.class));
	}
	
	@Test
	public void shouldDeleteUserSuccessfully() {
		User user = new Client(2,"jacer.sfar@","123456", "jacer sfar", null, null);
		doNothing().when(this.userDAO).delete(any(User.class));
		this.userService.delete(user);
		verify(this.userDAO, times(1)).delete(user);
		
	}
}
