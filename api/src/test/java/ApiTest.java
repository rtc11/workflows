import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestConfig.class, webEnvironment = RANDOM_PORT)
public class ApiTest {

    @Autowired
    private WebApplicationContext context;

    @Test
    void apiReturnsUuids() {
        val response = httpGet("/uuid");
        val uuid = UUID.fromString(response);

        assertThat(uuid, is(notNullValue()));
    }

    @SneakyThrows
    private String httpGet(String path) {
        val restMock = MockMvcBuilders.webAppContextSetup(context).build();

        return restMock.perform(get(path))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}
