package co.mz.schoolCtrl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.mz.schoolCtrl.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
