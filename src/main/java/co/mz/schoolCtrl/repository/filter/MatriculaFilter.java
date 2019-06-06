package co.mz.schoolCtrl.repository.filter;

import co.mz.schoolCtrl.model.Classe;
import co.mz.schoolCtrl.model.Student;

public class MatriculaFilter {

	private Student student;

	private Classe classe;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

}
