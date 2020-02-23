import no.tordly.fagkveld.api.Main;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(Main.class)
@Configuration(proxyBeanMethods = false)
public class TestConfig {
}
