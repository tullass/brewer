package co.mz.schoolCtrl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.mz.schoolCtrl.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {


	List<Student> findByNameStartingWithIgnoreCase(String name);

	@Query(nativeQuery = true, value="select * from Student m ORDER BY m.id DESC LIMIT 1")
	Student findlast();




}
