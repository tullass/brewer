package co.mz.schoolCtrl.repository.filter;

import co.mz.schoolCtrl.enumerator.Bank;
import co.mz.schoolCtrl.enumerator.Month;
import co.mz.schoolCtrl.enumerator.Year;
import co.mz.schoolCtrl.model.Matricula;
import co.mz.schoolCtrl.model.Services;

public class InvoiceFilter {

	private String transation;

	private Matricula matricula;

	private Services service;

	private Bank bank;

	private Year year;

	private Month montha;

	public String getTransation() {
		return transation;
	}

	public void setTransation(String transation) {
		this.transation = transation;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Services getService() {
		return service;
	}

	public void setService(Services service) {
		this.service = service;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public Month getMontha() {
		return montha;
	}

	public void setMontha(Month montha) {
		this.montha = montha;
	}

}
