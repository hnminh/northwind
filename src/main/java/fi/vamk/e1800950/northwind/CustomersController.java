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
public class CustomersController {
	@Autowired
	private CustomersRepository repository;

	// returning all Customerss
	@RequestMapping("/Customerss")
	public Iterable<Customers> customerss() {
		return repository.findAll();
	}

	// returning one Customers only
	@RequestMapping("/Customers/{id}")
	public Optional<Customers> get(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	 // create a new Customers
	@RequestMapping(value = "/Customers", method = RequestMethod.POST)
	public @ResponseBody Customers create(@RequestBody Customers item) {
		return repository.save(item);
	}

	 // update an existing Customers
	@RequestMapping(value = "/Customers", method = RequestMethod.PUT)
	public @ResponseBody Customers update(@RequestBody Customers item) {
		return repository.save(item);
	}

	 // delete a Customers
	@RequestMapping(value = "/Customers", method = RequestMethod.DELETE)
	public void delete(@RequestBody Customers item) {
		repository.delete(item);
	}

}