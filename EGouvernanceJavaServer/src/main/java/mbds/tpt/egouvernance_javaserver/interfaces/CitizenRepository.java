package mbds.tpt.egouvernance_javaserver.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import mbds.tpt.egouvernance_javaserver.models.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, String>{
}
