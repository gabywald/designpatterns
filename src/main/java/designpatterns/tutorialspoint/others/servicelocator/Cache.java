package designpatterns.tutorialspoint.others.servicelocator;

import java.util.ArrayList;
import java.util.List;

public class Cache {

	private List<Service> services;

	public Cache() {
		this.services = new ArrayList<Service>();
	}

	public Service getService(String serviceName) {
		for (Service service : this.services) {
			if (service.getName().equalsIgnoreCase(serviceName)) {
				System.out.println("Returning cached {" + serviceName + "} object");
				return service;
			}
		}
		return null;
	}

	public void addService(Service newService) {
		boolean exists = false;

		for (Service service : this.services) {
			if (service.getName().equalsIgnoreCase(newService.getName())) {
				exists = true;
			}
		}
		if ( ! exists) {
			this.services.add(newService);
		}
	}
}