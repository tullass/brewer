package co.mz.schoolCtrl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.mz.schoolCtrl.model.Classe;

@Repository
public interface ClassRepository extends CrudRepository<Classe, Long> {
	
	
	
	public List<Classe> findByGradeId(Long id);

	@Query("SELECT DISTINCT e FROM Classe e INNER JOIN e.grade t ON e.grade.id=t.id  WHERE e.id=:id")
	public List<Classe> ineer(@Param("id") Long id);

}
