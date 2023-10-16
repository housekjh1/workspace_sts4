package edu.pnu;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class BoardControllerTest2 {
	
	@Autowired
	private MockMvc mockMvc;
	
	@DisplayName("/hello URL 테스트")
	@Test
	public void testHello() throws Exception {
		mockMvc.perform(get("/hello").param("name", "둘리")) // get호출, 파라미터 전달
		.andExpect(status().isOk())
		.andExpect(content().string("Hello : 둘리")) // 이러한 String이 반환될 것이라 기대
		.andDo(print());
		
	}
}
