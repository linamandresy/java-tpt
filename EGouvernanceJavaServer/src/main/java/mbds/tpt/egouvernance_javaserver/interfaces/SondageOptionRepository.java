package mbds.tpt.egouvernance_javaserver.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mbds.tpt.egouvernance_javaserver.models.SondageOption;

public interface SondageOptionRepository extends JpaRepository<SondageOption, String>{    
    List<SondageOption> findByIdSondageMere(String id);
}
