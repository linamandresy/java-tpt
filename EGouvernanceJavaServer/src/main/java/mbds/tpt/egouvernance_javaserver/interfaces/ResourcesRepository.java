package mbds.tpt.egouvernance_javaserver.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import mbds.tpt.egouvernance_javaserver.models.Resources;

public interface ResourcesRepository extends JpaRepository<Resources, String>{
}