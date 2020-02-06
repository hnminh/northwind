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
public class InvoicesController {
	@Autowired
	private InvoicesRepository repository;

	// returning all Invoicess
	@RequestMapping("/Invoicess")
	public Iterable<Invoices> invoicess() {
		return repository.findAll();
	}

	// returning one Invoices only
	@RequestMapping("/Invoices/{id}")
	public Optional<Invoices> get(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	 // create a new Invoices
	@RequestMapping(value = "/Invoices", method = RequestMethod.POST)
	public @ResponseBody Invoices create(@RequestBody Invoices item) {
		return repository.save(item);
	}

	 // update an existing Invoices
	@RequestMapping(value = "/Invoices", method = RequestMethod.PUT)
	public @ResponseBody Invoices update(@RequestBody Invoices item) {
		return repository.save(item);
	}

	 // delete a Invoices
	@RequestMapping(value = "/Invoices", method = RequestMethod.DELETE)
	public void delete(@RequestBody Invoices item) {
		repository.delete(item);
	}

}