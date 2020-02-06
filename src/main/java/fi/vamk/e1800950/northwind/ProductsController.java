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
public class ProductsController {
	@Autowired
	private ProductsRepository repository;

	// returning all Productss
	@RequestMapping("/Productss")
	public Iterable<Products> productss() {
		return repository.findAll();
	}

	// returning one Products only
	@RequestMapping("/Products/{id}")
	public Optional<Products> get(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	 // create a new Products
	@RequestMapping(value = "/Products", method = RequestMethod.POST)
	public @ResponseBody Products create(@RequestBody Products item) {
		return repository.save(item);
	}

	 // update an existing Products
	@RequestMapping(value = "/Products", method = RequestMethod.PUT)
	public @ResponseBody Products update(@RequestBody Products item) {
		return repository.save(item);
	}

	 // delete a Products
	@RequestMapping(value = "/Products", method = RequestMethod.DELETE)
	public void delete(@RequestBody Products item) {
		repository.delete(item);
	}

}