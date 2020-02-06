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
public class PurchaseOrderDetailsController {
	@Autowired
	private PurchaseOrderDetailsRepository repository;

	// returning all PurchaseOrderDetails
	@RequestMapping("/AllPurchaseOrderDetails")
	public Iterable<PurchaseOrderDetails> allPurchaseOrderDetails() {
		return repository.findAll();
	}

	// returning one PurchaseOrderDetails only
	@RequestMapping("/PurchaseOrderDetails/{id}")
	public Optional<PurchaseOrderDetails> get(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	 // create a new PurchaseOrderDetails
	@RequestMapping(value = "/PurchaseOrderDetails", method = RequestMethod.POST)
	public @ResponseBody PurchaseOrderDetails create(@RequestBody PurchaseOrderDetails item) {
		return repository.save(item);
	}

	 // update an existing PurchaseOrderDetails
	@RequestMapping(value = "/PurchaseOrderDetails", method = RequestMethod.PUT)
	public @ResponseBody PurchaseOrderDetails update(@RequestBody PurchaseOrderDetails item) {
		return repository.save(item);
	}

	 // delete a PurchaseOrderDetails
	@RequestMapping(value = "/PurchaseOrderDetails", method = RequestMethod.DELETE)
	public void delete(@RequestBody PurchaseOrderDetails item) {
		repository.delete(item);
	}

}