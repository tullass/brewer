package co.mz.schoolCtrl.model;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import co.mz.schoolCtrl.enumerator.Period;
import co.mz.schoolCtrl.enumerator.Semester;

@Entity
public class Matricula implements Serializable {

	private static final long serialVersionUID = 8748215153719299764L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "")
	private String value;

	@NotBlank(message = "")
	private String mulct;

	@NotBlank(message = "")
	private String total;

	@NotBlank(message = "")
	private String transation;

	GregorianCalendar calendar = new GregorianCalendar();
	private int data = calendar.getWeekYear();

	@Enumerated(EnumType.STRING)
	@NotNull
	private Period period;

	@Enumerated(EnumType.STRING)
	@NotNull
	private Semester semester;

	@ManyToOne
	private Student student;

	@ManyToOne
	private Classe grade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Classe getGrade() {
		return grade;
	}

	public void setGrade(Classe grade) {
		this.grade = grade;
	}

	public String getTransation() {
		return transation;
	}

	public void setTransation(String transation) {
		this.transation = transation;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
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
		Matricula other = (Matricula) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
