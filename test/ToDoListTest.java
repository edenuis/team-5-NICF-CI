import java.util.ArrayList;
import java.util.Collection;

import org.junit.*;
import org.junit.Test;
import junit.framework.*;

public class ToDoListTest extends TestCase{
	// Define Test Fixtures
	private Task task1, task2;
	
	public ToDoListTest() {
		super();
	}
	@Before
	 public void setUp() throws Exception{
		//Initialise Test Fixtures
		task1 = new Task("Beat Clarence");
		task2 = new Task("Beat Edenuis", true);
	}
	@After
	 public void tearDown() throws Exception{
		task1 = null;
		task2 = null;
	}

	@Test
	public void testAddTask() {
		ToDoList tdl = new ToDoList();
		assertTrue(tdl.isEmpty());
		tdl.addTask(task1);
		assertFalse(tdl.isEmpty());
	}
	@Test
	public void testgetStatus() {
		ToDoList tdl = new ToDoList();
		assertTrue(tdl.isEmpty());
		tdl.addTask(task1);
		assertFalse(tdl.isEmpty());
		assertFalse(tdl.getStatus("Beat Clarence"));
	}
	@Test
	public void testRemoveTask() {
		ToDoList tdl = new ToDoList();
		assertTrue(tdl.isEmpty());
		tdl.addTask(task2);
		assertFalse(tdl.isEmpty());
		tdl.removeTask("Beat Edenuis");
		assertTrue(tdl.isEmpty());
	}
	@Test
	public void testCompleteTask() {
		ToDoList tdl = new ToDoList();
		assertTrue(tdl.isEmpty());
		tdl.addTask(task1);
		assertFalse(tdl.isEmpty());
		tdl.completeTask("Beat Clarence");
		assertTrue(task1.isComplete());	
	}
	@Test
	public void testGetTask() {
		ToDoList tdl = new ToDoList();
		assertTrue(tdl.isEmpty());
		tdl.addTask(task1);
		tdl.addTask(task2);
		assertFalse(tdl.isEmpty());
		Task task = tdl.getTask("Beat Daniel");
		assertNull(task);
		Task task11 = tdl.getTask("Beat Clarence");
		assertSame(task11, task1);
	}
}
