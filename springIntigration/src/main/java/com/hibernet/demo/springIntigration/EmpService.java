package com.hibernet.demo.springIntigration;

import java.util.List;

public interface EmpService {
	void save(Employee e);

	List<Employee> emplist();
}
