package com.springnew.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
//import org.mockito.junit.jupiter.MockitoExtension;

import com.springnew.controller.TeacherController;
import com.springnew.entity.Teacher;
import com.springnew.service.TeacherService;

@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
public class TeacherControllerTest {
	@Mock
	private TeacherService service;

	@InjectMocks
	private TeacherController controller;
	
	private List<Teacher> prepareTeacherRecords(){
		List<Teacher> teacherstudents = new ArrayList<Teacher>();
		Teacher teacherstudent1 = new Teacher(1L, "Sabari", "sabari@fff.com", "Nathan", "H23423443", 21, false, 232342345345f);
		Teacher teacherstudent2 = new Teacher(1L, "Kishore", "kishore@fff.com", "kumar", "H26563463", 27, true, 345677345345f);
		teacherstudents.add(teacherstudent1);
		teacherstudents.add(teacherstudent2);
		return teacherstudents;
	}
	
	@Test
	public void testFetchAllPass() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareTeacherRecords());
		List<Teacher> teacherstudents = prepareTeacherRecords();
		List<Teacher> teacherstudentsFromController =  controller.fetchAll();
		for(int i=0; i<teacherstudents.size();i++) {
			Assertions.assertEquals(teacherstudents.get(i).getId(), teacherstudentsFromController.get(i).getId());
			Assertions.assertEquals(teacherstudents.get(i).getAge(), teacherstudentsFromController.get(i).getAge());
			Assertions.assertEquals(teacherstudents.get(i).getPlateletsCount(), teacherstudentsFromController.get(i).getPlateletsCount());
			Assertions.assertEquals(teacherstudents.get(i).getEmailId(), teacherstudentsFromController.get(i).getEmailId());
			Assertions.assertEquals(teacherstudents.get(i).getFirstName(), teacherstudentsFromController.get(i).getFirstName());
			Assertions.assertEquals(teacherstudents.get(i).getLastName(), teacherstudentsFromController.get(i).getLastName());
			Assertions.assertEquals(teacherstudents.get(i).getPassportNumber(), teacherstudentsFromController.get(i).getPassportNumber());
		}
		
	}

	@Test
	public void testFetchAllFailure() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareTeacherRecords());
		List<Teacher> teacherstudents = null; //Intentionally made null to fail the test.
		List<Teacher> teacherstudentsFromController =  controller.fetchAll();
		Assertions.assertNotEquals(teacherstudents, teacherstudentsFromController);
	}
	
	
	 @Test public void fetchByIdPass() { 
		 Mockito
	        .when(controller.fetchById(1L)).thenReturn(prepareTeacherRecords().get(0));
			Teacher teacherById = prepareTeacherRecords().get(0);
			Teacher teacherByIdFromController = controller.fetchById(1L);
			
			Assertions.assertEquals(teacherById.getId(), teacherByIdFromController.getId());
			Assertions.assertEquals(teacherById.getAge(), teacherByIdFromController.getAge());
			Assertions.assertEquals(teacherById.getPlateletsCount(), teacherByIdFromController.getPlateletsCount());
			Assertions.assertEquals(teacherById.getEmailId(), teacherByIdFromController.getEmailId());
			Assertions.assertEquals(teacherById.getFirstName(), teacherByIdFromController.getFirstName());
			Assertions.assertEquals(teacherById.getLastName(), teacherByIdFromController.getLastName());
			Assertions.assertEquals(teacherById.getPassportNumber(), teacherByIdFromController.getPassportNumber());
		     
			Assertions.assertEquals(teacherById.getName(), teacherByIdFromController.getName());
	 }

	 @Test public void fetchByIdFailure() { 
		 Mockito
	        .when(controller.fetchById(1L)).thenReturn(prepareTeacherRecords().get(0));
			Teacher teacherById = prepareTeacherRecords().get(1);
			Teacher teacherByIdFromController = controller.fetchById(1L);
			
			Assertions.assertNotEquals(teacherById.getId(), teacherByIdFromController.getId());
			Assertions.assertNotEquals(teacherById.getAge(), teacherByIdFromController.getAge());
			Assertions.assertNotEquals(teacherById.getPlateletsCount(), teacherByIdFromController.getPlateletsCount());
			Assertions.assertNotEquals(teacherById.getEmailId(), teacherByIdFromController.getEmailId());
			Assertions.assertNotEquals(teacherById.getFirstName(), teacherByIdFromController.getFirstName());
			Assertions.assertNotEquals(teacherById.getLastName(), teacherByIdFromController.getLastName());
			Assertions.assertNotEquals(teacherById.getPassportNumber(), teacherByIdFromController.getPassportNumber());

        Assertions.assertNotEquals(teacherById.getName(), teacherByIdFromController.getName());
	 }
	 
	 @Test
	 public void deletePass() { 
		 controller.delete(1L);
		 Assertions.assertTrue(true); // This line will be executed only if there is no error in calling the controller for delete as there is no return value.
	 }

	@Test
	public void createPass() {
		Teacher teacherToBeCreated = prepareTeacherRecords().get(0);
		Teacher teacherReturned = prepareTeacherRecords().get(0);
		teacherReturned.setId(1L); //Changed the ID.
		
		Mockito
			.when(controller.create(teacherToBeCreated)).thenReturn(teacherReturned);
		
		Teacher teacherFromController  = controller.create(teacherToBeCreated);
		Assertions.assertNotEquals(teacherToBeCreated.getId(), teacherFromController.getId()); //Since Id of created one is mocked as changed from within serviceid, it cannot be equal. 
		Assertions.assertEquals(teacherToBeCreated.getAge(), teacherFromController.getAge());
		Assertions.assertEquals(teacherToBeCreated.getPlateletsCount(),teacherFromController.getPlateletsCount());
		Assertions.assertEquals(teacherToBeCreated.getEmailId(), teacherFromController.getEmailId());
		Assertions.assertEquals(teacherToBeCreated.getFirstName(), teacherFromController.getFirstName());
		Assertions.assertEquals(teacherToBeCreated.getLastName(), teacherFromController.getLastName());
		Assertions.assertEquals(teacherToBeCreated.getPassportNumber(),teacherFromController.getPassportNumber());
        Assertions.assertEquals(teacherToBeCreated.getName(), teacherFromController.getName());
	}
	
	@Test
	public void createFailure() {
		Teacher teacherToBeCreated = prepareTeacherRecords().get(0);
		Teacher teacherReturned = null; // Intentionally left to null to fail the case. 
				
		Mockito
			.when(controller.create(teacherToBeCreated)).thenReturn(teacherReturned);
		
			Teacher teacherFromController  = controller.create(teacherToBeCreated);
		Assertions.assertNull(teacherFromController);
	}
	
	/*
	 * @Test public void update() { ResponseEntity<Object> responseObject = null;
	 * 
	 * Mockito.when(controller.update(studentToBeUpdated,
	 * "")).thenReturn(responseObject); }
	 */	
}