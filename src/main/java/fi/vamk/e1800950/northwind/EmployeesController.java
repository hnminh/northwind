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
public class EmployeesController {
	@Autowired
	private EmployeesRepository repository;

	// returning all Employees
	@RequestMapping("/AllEmployees")
	public Iterable<Employees> allEmployees() {
		return repository.findAll();
	}

	// returning one Employees only
	@RequestMapping("/Employees/{id}")
	public Optional<Employees> get(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	 // create a new Employees
	@RequestMapping(value = "/Employees", method = RequestMethod.POST)
	public @ResponseBody Employees create(@RequestBody Employees item) {
		return repository.save(item);
	}

	 // update an existing Employees
	@RequestMapping(value = "/Employees", method = RequestMethod.PUT)
	public @ResponseBody Employees update(@RequestBody Employees item) {
		return repository.save(item);
	}

	 // delete a Employees
	@RequestMapping(value = "/Employees", method = RequestMethod.DELETE)
	public void delete(@RequestBody Employees item) {
		repository.delete(item);
	}

}