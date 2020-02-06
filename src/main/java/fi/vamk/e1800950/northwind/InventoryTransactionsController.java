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
public class InventoryTransactionsController {
	@Autowired
	private InventoryTransactionsRepository repository;

	// returning all InventoryTransactionss
	@RequestMapping("/InventoryTransactionss")
	public Iterable<InventoryTransactions> inventorytransactionss() {
		return repository.findAll();
	}

	// returning one InventoryTransactions only
	@RequestMapping("/InventoryTransactions/{id}")
	public Optional<InventoryTransactions> get(@PathVariable("id") int id) {
		return repository.findById(id);
	}

	 // create a new InventoryTransactions
	@RequestMapping(value = "/InventoryTransactions", method = RequestMethod.POST)
	public @ResponseBody InventoryTransactions create(@RequestBody InventoryTransactions item) {
		return repository.save(item);
	}

	 // update an existing InventoryTransactions
	@RequestMapping(value = "/InventoryTransactions", method = RequestMethod.PUT)
	public @ResponseBody InventoryTransactions update(@RequestBody InventoryTransactions item) {
		return repository.save(item);
	}

	 // delete a InventoryTransactions
	@RequestMapping(value = "/InventoryTransactions", method = RequestMethod.DELETE)
	public void delete(@RequestBody InventoryTransactions item) {
		repository.delete(item);
	}

}