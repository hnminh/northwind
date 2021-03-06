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
public class OrdersController {
	@Autowired
	private OrdersRepository repository;

	// returning all Orders
	@RequestMapping("/AllOrders")
	public Iterable<Orders> allOrders() {
		return repository.findAll();
	}

	// returning one Orders only
	@RequestMapping("/Orders/{id}")
	public Optional<Orders> get(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	 // create a new Orders
	@RequestMapping(value = "/Orders", method = RequestMethod.POST)
	public @ResponseBody Orders create(@RequestBody Orders item) {
		return repository.save(item);
	}

	 // update an existing Orders
	@RequestMapping(value = "/Orders", method = RequestMethod.PUT)
	public @ResponseBody Orders update(@RequestBody Orders item) {
		return repository.save(item);
	}

	 // delete a Orders
	@RequestMapping(value = "/Orders", method = RequestMethod.DELETE)
	public void delete(@RequestBody Orders item) {
		repository.delete(item);
	}

}