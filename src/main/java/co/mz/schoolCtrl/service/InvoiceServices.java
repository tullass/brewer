package co.mz.schoolCtrl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.mz.schoolCtrl.model.Invoice;
import co.mz.schoolCtrl.repository.InvoiceRepository;;

@Service
public class InvoiceServices {

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Transactional
	public void save(Invoice invoice) {

		invoiceRepository.save(invoice);
	}

	public Iterable<Invoice> findAll() {
		return invoiceRepository.findAll();
	}

	public Invoice findOne(Long id) {
		return invoiceRepository.findOne(id);
	}

	public void remove(Long id) {
		Invoice invoice = this.findOne(id);
		if (invoice != null)
			invoiceRepository.delete(invoice);
	}

	public List<Invoice> getAll() {

		List<Invoice> listAll = (List<Invoice>) invoiceRepository.findAll();
		return listAll;
	}

}
