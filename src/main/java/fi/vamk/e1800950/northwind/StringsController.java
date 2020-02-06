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
public class StringsController {
	@Autowired
	private StringsRepository repository;

	// returning all Stringss
	@RequestMapping("/Stringss")
	public Iterable<Strings> stringss() {
		return repository.findAll();
	}

	// returning one Strings only
	@RequestMapping("/Strings/{id}")
	public Optional<Strings> get(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	 // create a new Strings
	@RequestMapping(value = "/Strings", method = RequestMethod.POST)
	public @ResponseBody Strings create(@RequestBody Strings item) {
		return repository.save(item);
	}

	 // update an existing Strings
	@RequestMapping(value = "/Strings", method = RequestMethod.PUT)
	public @ResponseBody Strings update(@RequestBody Strings item) {
		return repository.save(item);
	}

	 // delete a Strings
	@RequestMapping(value = "/Strings", method = RequestMethod.DELETE)
	public void delete(@RequestBody Strings item) {
		repository.delete(item);
	}

}