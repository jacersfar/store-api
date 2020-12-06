package org.eclipse.store;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Calendar;

import org.eclipse.controllers.ProductController;
import org.eclipse.helper.Mapper;
import org.eclipse.models.Product;
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
import org.eclipse.models.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

public class ProductControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Mock
	private IService<Product> mockedProductService;
	@InjectMocks
	private ProductController productController;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}
	@Test
	public void shouldReturnProductList() throws Exception {
		ArrayList<Product> productList = new ArrayList<Product>();
		productList.add(new Book(1, 5.0d, 55, "test", Calendar.getInstance(), new Author(1, "jacer Sfar")));
		productList.add(new Book(1, 5.0d, 55, "testing", Calendar.getInstance(), new Author(1, "soussi Oussama")));
		when(mockedProductService.find()).thenReturn(productList);
		this.mockMvc.perform(get("/product/all")).andExpect(status().isOk())
		.andExpect(jsonPath("$",hasSize(2))).andDo(print());
	}
	
	@Test
	public void shouldAddProductSuccessfully() throws Exception {
		Book book = new Book(1, 5.0d, 55, "testing", Calendar.getInstance(), new Author(1, "soussi Oussama"));
		doNothing().when(this.mockedProductService).add(any(Product.class));
		this.mockMvc.perform(post("/product/book/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Mapper.asJsonString(book))
				).andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void shouldFailAddingProductAndReturnClientError() throws Exception {
		this.mockMvc.perform(post("/product/book/add")
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().is4xxClientError())
				.andDo(print());
	}
	
	@Test
	public void shouldUpdateProductSuccessfully() throws Exception {
		Book book = new Book(1, 5.0d, 55, "testing", Calendar.getInstance(), new Author(1, "soussi Oussama"));
		doNothing().when(this.mockedProductService).update(any(Product.class));
		this.mockMvc.perform(put("/product/book/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Mapper.asJsonString(book))
				).andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void shouldFailUpdatingProductAndReturnClientError() throws Exception {
		this.mockMvc.perform(put("/product/book/update")
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().is4xxClientError())
				.andDo(print());
	}
	
	@Test
	public void shouldDeleteProductSuccessfully() throws Exception {
		Book book = new Book(1, 5.0d, 55, "testing", Calendar.getInstance(), new Author(1, "soussi Oussama"));
		doNothing().when(this.mockedProductService).delete(any(Product.class));
		this.mockMvc.perform(delete("/product/book/delete")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Mapper.asJsonString(book))
				).andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void shouldFailDeletingAndReturnClientError() throws Exception {
		this.mockMvc.perform(delete("/product/book/delete")
				).andExpect(status().is4xxClientError())
				.andDo(print());
	}
}
