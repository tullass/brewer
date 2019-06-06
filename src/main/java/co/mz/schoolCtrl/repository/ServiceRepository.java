package co.mz.schoolCtrl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.mz.schoolCtrl.model.Services;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Long> {

}
