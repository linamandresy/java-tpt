package mbds.tpt.egouvernance_javaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(
	scanBasePackages={"mbds.tpt.egouvernance_javaserver.api","mbds.tpt.egouvernance_javaserver.helpers"},
	exclude = { SecurityAutoConfiguration.class }
	)
public class EgouvernanceJavaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EgouvernanceJavaserverApplication.class, args);
	}

}
