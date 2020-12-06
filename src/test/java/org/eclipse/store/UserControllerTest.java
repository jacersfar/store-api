package org.eclipse.store;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import org.eclipse.controllers.UserController;
import org.eclipse.helper.Mapper;
import org.eclipse.models.Client;
import org.eclipse.models.Admin;
import org.eclipse.models.User;
import org.eclipse.services.IService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class UserControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Mock
	private IService<User> mockedUserService;
	@InjectMocks
	private UserController userController;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}
	@Test
	public void shouldReturnUserList() throws Exception {
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new Client(1,"ars.jacer.sfar@","123456", "jacer sfar", null, null));
		userList.add(new Client(2,"jacer.sfar@","123456", "jacer sfar", null, null));
		when(this.mockedUserService.find()).thenReturn(userList);
		this.mockMvc.perform(get("/user/all")).andExpect(status().isOk())
		.andExpect(jsonPath("$",hasSize(2))).andDo(print());
	}
	
	@Test
	public void shouldAddClientAndThenAdminSuccessfully() throws Exception {
		User user = new Client(2,"jacer.sfar@","123456", "jacer sfar", null, null);
		User admin = new Admin(3,"admin@admin.com", "120", "admin");
		doNothing().when(this.mockedUserService).add(any(User.class));
		this.mockMvc.perform(post("/user/add/client")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Mapper.asJsonString(user))
				).andExpect(status().isOk())
				.andDo(print());
		this.mockMvc.perform(post("/user/add/admin")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Mapper.asJsonString(admin))
				).andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void shouldFailAddingUserAndReturnClientError() throws Exception {
		this.mockMvc.perform(post("/user/add/client")
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().is4xxClientError())
				.andDo(print());
	}
	
	@Test
	public void shouldUpdateClientThenAdminSuccessfully() throws Exception {
		User user = new Client(2,"jacer.sfar@","123456", "jacer sfar", null, null);
		User admin = new Admin(3,"admin@admin.com", "120", "admin");
		doNothing().when(this.mockedUserService).update(any(User.class));
		this.mockMvc.perform(put("/user/update/client")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Mapper.asJsonString(user))
				).andExpect(status().isOk())
				.andDo(print());
		this.mockMvc.perform(put("/user/update/admin")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Mapper.asJsonString(admin))
				).andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void shouldFailUpdatingUserAndReturnClientError() throws Exception {
		this.mockMvc.perform(put("/user/update/admin")
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().is4xxClientError())
				.andDo(print());
	}
	
	@Test
	public void shouldDeleteUserSuccessfully() throws Exception {
		User admin = new Admin(3,"admin@admin.com", "120", "admin");
		User user = new Client(2,"jacer.sfar@","123456", "jacer sfar", null, null);
		doNothing().when(this.mockedUserService).delete(any(User.class));
		this.mockMvc.perform(delete("/user/delete/client")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Mapper.asJsonString(user))
				).andExpect(status().isOk())
				.andDo(print());
		this.mockMvc.perform(delete("/user/delete/admin")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Mapper.asJsonString(admin))
				).andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void shouldFailDeletingAndReturnClientError() throws Exception {
		this.mockMvc.perform(delete("/user/delete/admin")
				).andExpect(status().is4xxClientError())
				.andDo(print());
	}
}
