package org.eclipse.store;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.eclipse.IDAO.IDAO;
import org.eclipse.models.Book;
import org.eclipse.models.Product;
import org.eclipse.services.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ProductServiceTest {
	@Mock
	private IDAO<Product> mockedProductService;
	
	@InjectMocks
	private ProductService productService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldReturnProductList() {
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Book(1,55d,55,"test",Calendar.getInstance(), null));
		productList.add(new Book(2,55d,55,"test2",Calendar.getInstance(), null));
		when(this.mockedProductService.find()).thenReturn(productList);
		assertTrue("Test failed: Size of list isn't equal to the size of mocked list",this.productService.find().size() == productList.size());
	}
	
	@Test
	public void shouldAddProductSuccessfully() {
		this.productService.add(new Book(1,55d,55,"test",Calendar.getInstance(), null));
		verify(this.mockedProductService, times(1)).add(any(Product.class));
	}
	
	@Test
	public void shouldUpdateProductSuccessfully() {
		this.productService.update(new Book(1,55d,55,"test",Calendar.getInstance(), null));
		verify(this.mockedProductService, times(1)).update(any(Product.class));
	}
	
	@Test
	public void shouldDeleteProductSuccessfully() {
		this.productService.delete(new Book(1,55d,55,"test",Calendar.getInstance(), null));
		verify(this.mockedProductService, times(1)).delete(any(Product.class));
	}
}
