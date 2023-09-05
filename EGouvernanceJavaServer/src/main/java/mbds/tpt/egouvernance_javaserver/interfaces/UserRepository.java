package mbds.tpt.egouvernance_javaserver.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import mbds.tpt.egouvernance_javaserver.models.User;

public interface UserRepository extends JpaRepository<User, String>{
    User findOneByUserNameAndUserPassword(String userName,String userPassword);
}
