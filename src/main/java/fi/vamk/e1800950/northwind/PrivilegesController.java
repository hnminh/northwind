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
public class PrivilegesController {
	@Autowired
	private PrivilegesRepository repository;

	// returning all Privileges
	@RequestMapping("/AllPrivileges")
	public Iterable<Privileges> allPrivileges() {
		return repository.findAll();
	}

	// returning one Privileges only
	@RequestMapping("/Privileges/{id}")
	public Optional<Privileges> get(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	 // create a new Privileges
	@RequestMapping(value = "/Privileges", method = RequestMethod.POST)
	public @ResponseBody Privileges create(@RequestBody Privileges item) {
		return repository.save(item);
	}

	 // update an existing Privileges
	@RequestMapping(value = "/Privileges", method = RequestMethod.PUT)
	public @ResponseBody Privileges update(@RequestBody Privileges item) {
		return repository.save(item);
	}

	 // delete a Privileges
	@RequestMapping(value = "/Privileges", method = RequestMethod.DELETE)
	public void delete(@RequestBody Privileges item) {
		repository.delete(item);
	}

}