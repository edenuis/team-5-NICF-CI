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
	public Task setTaskCategory(String description, String category) {
		tasks.get(description).setCategory(category);
		return tasks.get(description);
	}
	public String getTaskCategory(String description) {
		return tasks.get(description).getCategory();
	}
	public boolean getStatus(String description) {
		return tasks.get(description).isComplete();
	}
	public Task setTask(String oldDescription ,String newDescription) {
		Task task = this.removeTask(oldDescription); //removes old task based on description
		task.setDescription(newDescription); //adds a new description
		tasks.put(newDescription, task);  //push back in 
		return task; 
	}
	public Task getTask(String description) {
		return tasks.get(description);
	}
	public Task removeTask(String description) {
		return tasks.remove(description);
	}
	public Collection<Task> getAllTasks() {
		return tasks.values();
		
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
	
	public Collection<Task> getUncompletedTasks() {
		ArrayList<Task> arr = new ArrayList<Task>();
		for(String desc: tasks.keySet()) {
			Task task = tasks.get(desc);
			if(!task.isComplete()) {
				arr.add(task);
			}
		}
		return arr;
	}
	
	public boolean isEmpty() {
		return tasks.isEmpty();
	}
}
