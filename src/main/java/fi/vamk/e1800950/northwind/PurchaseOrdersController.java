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
public class PurchaseOrdersController {
	@Autowired
	private PurchaseOrdersRepository repository;

	// returning all PurchaseOrders
	@RequestMapping("/AllPurchaseOrders")
	public Iterable<PurchaseOrders> allPurchaseOrders() {
		return repository.findAll();
	}

	// returning one PurchaseOrders only
	@RequestMapping("/PurchaseOrders/{id}")
	public Optional<PurchaseOrders> get(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	 // create a new PurchaseOrders
	@RequestMapping(value = "/PurchaseOrders", method = RequestMethod.POST)
	public @ResponseBody PurchaseOrders create(@RequestBody PurchaseOrders item) {
		return repository.save(item);
	}

	 // update an existing PurchaseOrders
	@RequestMapping(value = "/PurchaseOrders", method = RequestMethod.PUT)
	public @ResponseBody PurchaseOrders update(@RequestBody PurchaseOrders item) {
		return repository.save(item);
	}

	 // delete a PurchaseOrders
	@RequestMapping(value = "/PurchaseOrders", method = RequestMethod.DELETE)
	public void delete(@RequestBody PurchaseOrders item) {
		repository.delete(item);
	}

}