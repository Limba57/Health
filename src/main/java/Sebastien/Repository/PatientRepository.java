package Sebastien.Repository;

import Sebastien.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Integer> {

    @Query(value = "select u from Patient u where u.firstname = :s or u.lastname = :s ")
    List<Patient> find(@Param("s") String searchPatient);
}
