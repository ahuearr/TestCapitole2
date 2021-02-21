package capitole.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test 
	public void testEmptyBrandId() throws Exception {
		this.mockMvc.perform(get("/prices?productId=35455&date=2020-06-14-10.00.00"))
		.andDo(print())
		.andExpect(status().isBadRequest());
	}
	
	@Test 
	public void testEmptyProductId() throws Exception {
		this.mockMvc.perform(get("/prices?brandId=1&date=2020-06-14-10.00.00"))
		.andDo(print())
		.andExpect(status().isBadRequest());
	}
	
	@Test 
	public void testEmptyDate() throws Exception {
		this.mockMvc.perform(get("/prices?brandId=1&productId=35455"))
		.andDo(print())
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void test1() throws Exception {
		this.mockMvc.perform(get("/prices?brandId=1&productId=35455&date=2020-06-14-10.00.00"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("1"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("35.5"));
	}

	@Test
	public void test2() throws Exception {
		this.mockMvc.perform(get("/prices?brandId=1&productId=35455&date=2020-06-14-16.00.00"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("2"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("25.45"));
	}

	@Test
	public void test3() throws Exception {
		this.mockMvc.perform(get("/prices?brandId=1&productId=35455&date=2020-06-14-21.00.00"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("1"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("35.5"));
	}

	@Test
	public void test4() throws Exception {
		this.mockMvc.perform(get("/prices?brandId=1&productId=35455&date=2020-06-15-10.00.00"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("3"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("30.5"));
	}

	@Test
	public void test5() throws Exception {
		this.mockMvc.perform(get("/prices?brandId=1&productId=35455&date=2020-06-16-21.00.00"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("4"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("38.95"));
	}
}
