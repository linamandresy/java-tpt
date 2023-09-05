package mbds.tpt.egouvernance_javaserver.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import mbds.tpt.egouvernance_javaserver.models.TypeResource;

public interface TypeResourceRepository extends JpaRepository<TypeResource, String>{
    
}
