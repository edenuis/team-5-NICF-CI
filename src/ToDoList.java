import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ToDoList {
private HashMap<String, Task> tasks = new HashMap<String, Task>();

	public void addTask (Task task) {
		tasks.put(task.getDescription(), task);
	}
	public void completeTask(String description) {
		tasks.get(description).setComplete(true);
	}
	public boolean getStatus(String description) {
		return tasks.get(description).isComplete();
	}
	public Task getTask(String description) {
		// Add code here
		return tasks.get(description);
	}
	public Task removeTask(String description) {
		return tasks.remove(description);
	}
	public Collection<Task> getAllTasks() {
		return tasks.values();
		return null;
	}
	public Collection<Task> getCompletedTasks() {
		ArrayList<Task> arr = new ArrayList<Task>();
		for(String desc: tasks.keySet()) {
			Task task = tasks.get(desc);
			if(task.isComplete()) {
				arr.add(task);
			}
		}
		return arr;
	}
	
	public boolean isEmpty() {
		return tasks.isEmpty();
	}
}
