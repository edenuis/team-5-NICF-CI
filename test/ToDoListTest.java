import java.util.ArrayList;
import java.util.Collection;

import org.junit.*;
import org.junit.Test;
import junit.framework.*;

public class ToDoListTest extends TestCase{
	// Define Test Fixtures
	private Task task1, task2, task3, task4;
	ToDoList tdl;
	public ToDoListTest() {
		super();
	}
	@Before
	 public void setUp() throws Exception{
		//Initialise Test Fixtures
		task1 = new Task("Beat Clarence");
		task2 = new Task("Beat Edenuis", true);
		task3 = new Task("Beat Erycka", true);
		task4 = new Task("Beat LJ", false);
		tdl = new ToDoList();
	}
	@After
	 public void tearDown() throws Exception{
		task1 = null;
		task2 = null;
	}

	@Test
	public void testAddTask() {
		assertTrue(tdl.isEmpty());
		tdl.addTask(task1);
		assertFalse(tdl.isEmpty());
	}
	@Test
	public void testgetStatus() {
		assertTrue(tdl.isEmpty());
		tdl.addTask(task1);
		assertFalse(tdl.isEmpty());
		assertFalse(tdl.getStatus("Beat Clarence"));
	}
	@Test
	public void testRemoveTask() {
		assertTrue(tdl.isEmpty());
		tdl.addTask(task2);
		assertFalse(tdl.isEmpty());
		tdl.removeTask("Beat Edenuis");
		assertTrue(tdl.isEmpty());
	}
	@Test
	public void testGetCompletedTasks() {
		assertTrue(tdl.isEmpty());
		tdl.addTask(task1);
		tdl.addTask(task2);
		tdl.addTask(task3);
		tdl.addTask(task4);
		assertFalse(tdl.isEmpty());
		ArrayList<Task> arr = (ArrayList <Task>) tdl.getCompletedTasks();
		assertEquals(task2, arr.get(0));
		assertEquals(task3, arr.get(1));
		assertEquals(2, arr.size());
	}
	@Test
	public void testGetUncompletedTasks() {
		assertTrue(tdl.isEmpty());
		tdl.addTask(task1);
		tdl.addTask(task2);
		tdl.addTask(task3);
		tdl.addTask(task4);
		assertFalse(tdl.isEmpty());
		ArrayList<Task> arr = (ArrayList <Task>) tdl.getUncompletedTasks();
		assertEquals(task4, arr.get(0));
		assertEquals(task1, arr.get(1));
		assertEquals(2, arr.size());
	}
	@Test
	public void testCompleteTask() {
		assertTrue(tdl.isEmpty());
		tdl.addTask(task1);
		assertFalse(tdl.isEmpty());
		tdl.completeTask("Beat Clarence");
		assertTrue(task1.isComplete());	
	}
	@Test
	public void testGetTask() {
		assertTrue(tdl.isEmpty());
		tdl.addTask(task1);
		tdl.addTask(task2);
		assertFalse(tdl.isEmpty());
		Task task = tdl.getTask("Beat Daniel");
		assertNull(task);
		Task task11 = tdl.getTask("Beat Clarence");
		assertSame(task11, task1);
	}
	@Test
	public void testSetTask() {
		assertTrue(tdl.isEmpty());
		tdl.addTask(task1);
		tdl.addTask(task2);
		Task chicken = tdl.setTask("Beat Clarence", "Clarence follow JK GF");
		assertEquals("Fail Here",tdl.getTask("Clarence follow JK GF"), chicken);
		assertNull("Fail There",tdl.getTask("Beat Clarence"));
	}
	
	@Test
	public void testGetCategory() {
		assertTrue(tdl.isEmpty());
		tdl.addTask(task1);
		tdl.addTask(task2);
		assertNull(tdl.getTaskCategory("Beat Clarence"));
	}
	@Test
	public void testSetCategory() {
		assertTrue(tdl.isEmpty());
		tdl.addTask(task1);
		tdl.addTask(task2);
		tdl.setTaskCategory("Beat Clarence", "Stalker");
		assertEquals("Fail Here","Stalker", tdl.getTaskCategory("Beat Clarence"));
		assertNull(tdl.getTaskCategory("Beat Edenuis"));
	}
}
