package co.mz.schoolCtrl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.mz.schoolCtrl.model.Matricula;

@Repository
public interface MatriculaRepository extends CrudRepository<Matricula, Long> {

	
	@Query("SELECT DISTINCT e FROM Matricula e INNER JOIN e.student t ON e.student.id=t.id  WHERE e.student.name=:name")
	public List<Matricula> findStudentByNameStartinrgWithIgnoreCase(@Param("name") String name);

//	public List<Matricula>	findByStudentNameStartingWithIgnoreCase(String name);
}
