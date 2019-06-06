package co.mz.schoolCtrl.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import co.mz.schoolCtrl.enumerator.Bank;
import co.mz.schoolCtrl.enumerator.Month;
import co.mz.schoolCtrl.enumerator.Year;

@Entity
public class Invoice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9155270612946977176L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String transation;
	private String value;
	private String mulct;
	private String mulctTotal;

	private String prestation;

	private String total;

	@ManyToOne
	private Matricula matricula;

	@ManyToOne
	private Services service;

	@Enumerated(EnumType.STRING)
	private Bank bank;

	@Enumerated(EnumType.STRING)
	private Year year;

	@Enumerated(EnumType.STRING)
	private Month montha;

	public Long getId() {
		return id;
	}

	public String getTransation() {
		return transation;
	}

	public void setTransation(String transation) {
		this.transation = transation;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMulct() {
		return mulct;
	}

	public void setMulct(String mulct) {
		this.mulct = mulct;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
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

	public Month getMontha() {
		return montha;
	}

	public void setMontha(Month montha) {
		this.montha = montha;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMulctTotal() {
		return mulctTotal;
	}

	public void setMulctTotal(String mulctTotal) {
		this.mulctTotal = mulctTotal;
	}

	public String getPrestation() {
		return prestation;
	}

	public void setPrestation(String prestation) {
		this.prestation = prestation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
