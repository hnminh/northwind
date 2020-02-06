package fi.vamk.e1800950.northwind;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeePrivilegesController {
	@Autowired
	private EmployeePrivilegesRepository repository;

	// returning all EmployeePrivilegess
	@RequestMapping("/EmployeePrivilegess")
	public Iterable<EmployeePrivileges> employeeprivilegess() {
		return repository.findAll();
	}

	// returning one EmployeePrivileges only
	@RequestMapping("/EmployeePrivileges/{id}")
	public Optional<EmployeePrivileges> get(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	 // create a new EmployeePrivileges
	@RequestMapping(value = "/EmployeePrivileges", method = RequestMethod.POST)
	public @ResponseBody EmployeePrivileges create(@RequestBody EmployeePrivileges item) {
		return repository.save(item);
	}

	 // update an existing EmployeePrivileges
	@RequestMapping(value = "/EmployeePrivileges", method = RequestMethod.PUT)
	public @ResponseBody EmployeePrivileges update(@RequestBody EmployeePrivileges item) {
		return repository.save(item);
	}

	 // delete a EmployeePrivileges
	@RequestMapping(value = "/EmployeePrivileges", method = RequestMethod.DELETE)
	public void delete(@RequestBody EmployeePrivileges item) {
		repository.delete(item);
	}

}