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
public class SuppliersController {
	@Autowired
	private SuppliersRepository repository;

	// returning all Suppliers
	@RequestMapping("/AllSuppliers")
	public Iterable<Suppliers> allSuppliers() {
		return repository.findAll();
	}

	// returning one Suppliers only
	@RequestMapping("/Suppliers/{id}")
	public Optional<Suppliers> get(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	 // create a new Suppliers
	@RequestMapping(value = "/Suppliers", method = RequestMethod.POST)
	public @ResponseBody Suppliers create(@RequestBody Suppliers item) {
		return repository.save(item);
	}

	 // update an existing Suppliers
	@RequestMapping(value = "/Suppliers", method = RequestMethod.PUT)
	public @ResponseBody Suppliers update(@RequestBody Suppliers item) {
		return repository.save(item);
	}

	 // delete a Suppliers
	@RequestMapping(value = "/Suppliers", method = RequestMethod.DELETE)
	public void delete(@RequestBody Suppliers item) {
		repository.delete(item);
	}

}