package com.example.testTask;

import com.example.testTask.controller.MemberController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TestTaskApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnMembers() throws Exception {
		this.mockMvc.perform(get("/member"))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void shouldReturnMembersGroup() throws Exception {
		this.mockMvc.perform(get("/memberGroup"))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void shouldReturnMembersGroupOld() throws Exception {
		this.mockMvc.perform(get("/memberGroup/old"))
				.andDo(print())
				.andExpect(status().isOk());
	}

}
