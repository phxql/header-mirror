package de.mkammerer.headermirror;

import io.micronaut.context.annotation.Value;
import io.micronaut.core.annotation.NonBlocking;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    private final int port;

    public IndexController(@Value("${micronaut.server.port}") int port) {
        this.port = port;
    }

    @Get(produces = MediaType.TEXT_PLAIN)
    @NonBlocking
    public String index(HttpHeaders headers) {
        LOGGER.info("Got request on port {}", port);

        StringBuilder sb = new StringBuilder();
        sb.append("> Handled request on port ");
        sb.append(port);
        sb.append('\n');

        for (Map.Entry<String, List<String>> header : headers) {
            sb.append(header.getKey());
            sb.append(": ");
            List<String> values = header.getValue();
            int valueCount = values.size();
            for (int i = 0; i < valueCount; i++) {
                sb.append(values.get(i));

                if (i < valueCount - 1) {
                    sb.append(", ");
                }
            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
