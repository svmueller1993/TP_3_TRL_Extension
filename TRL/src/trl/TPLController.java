package trl;

import java.util.ArrayList;
import java.util.List;

public class TPLController {
	List<Worker> workers = new ArrayList<Worker>();
	
	public TPLController() {
		loadSampleData();
	}
	
	public void loadSampleData() {
		workers.add(new Worker("worker", "Alex", "Kevin", "worker"));
		workers.add(new Manager("manager", "Alex", "Kevin", "manager"));
		
	}
	
	public Worker login(String login, String password) {
		for (Worker worker : workers) {
			if (worker.getWorkerId().equalsIgnoreCase(login) && 
					worker.getPassword().equals(password)) {
				return worker;
			}
		}
		return null;
	}

}
