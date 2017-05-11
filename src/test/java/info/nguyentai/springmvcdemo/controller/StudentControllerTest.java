package info.nguyentai.springmvcdemo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import info.nguyentai.springmvcdemo.model.Student;
import info.nguyentai.springmvcdemo.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testContext.xml", "classpath:exampleApplicationContext-web.xml"})
@WebAppConfiguration
public class StudentControllerTest {
	private MockMvc mockMvc;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() {
		Mockito.reset(studentService);
		 
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testGetAllStudent_Success() throws Exception {
		Date currentDate = new Date();
		Student student1 = new Student("st1", "Student 1", currentDate);
		Student student2 = new Student("st2", "Student 2", currentDate);
		when(studentService.getAllStudents()).thenReturn(Arrays.asList(student1, student2));
		mockMvc.perform(get("/students"))
				.andExpect(status().isOk())
				.andExpect(view().name("students"))
				.andExpect(model().attribute("students", hasSize(2)))
				.andExpect(model().attribute("students", hasItem(
						allOf(
								hasProperty("id", is("st1")),
								hasProperty("fullName", is("Student 1")),
								hasProperty("dayOfBirth", is(currentDate)))
				)))
				.andExpect(model().attribute("students", hasItem(
						allOf(
								hasProperty("id", is("st2")),
								hasProperty("fullName", is("Student 2")),
								hasProperty("dayOfBirth", is(currentDate)))
				)));
		verify(studentService, times(1)).getAllStudents();
        verifyNoMoreInteractions(studentService);
	}
	
	@Test
	public void testAddStudentForm_Success () throws Exception {
		mockMvc.perform(get("/students/add"))
			.andExpect(status().isOk())
			.andExpect(view().name("add-student"))
			.andExpect(model().attributeExists("student"));
	}
	
	@Test
	public void testAddStudent_Success () throws Exception {
		mockMvc.perform(post("/students")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED))
			.andExpect(status().isOk())
			.andExpect(view().name("add-student"))
			.andExpect(model().attributeExists("student"));
	}
}
