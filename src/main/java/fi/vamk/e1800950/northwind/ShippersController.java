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
public class ShippersController {
	@Autowired
	private ShippersRepository repository;

	// returning all Shippers
	@RequestMapping("/AllShippers")
	public Iterable<Shippers> allShippers() {
		return repository.findAll();
	}

	// returning one Shippers only
	@RequestMapping("/Shippers/{id}")
	public Optional<Shippers> get(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	 // create a new Shippers
	@RequestMapping(value = "/Shippers", method = RequestMethod.POST)
	public @ResponseBody Shippers create(@RequestBody Shippers item) {
		return repository.save(item);
	}

	 // update an existing Shippers
	@RequestMapping(value = "/Shippers", method = RequestMethod.PUT)
	public @ResponseBody Shippers update(@RequestBody Shippers item) {
		return repository.save(item);
	}

	 // delete a Shippers
	@RequestMapping(value = "/Shippers", method = RequestMethod.DELETE)
	public void delete(@RequestBody Shippers item) {
		repository.delete(item);
	}

}