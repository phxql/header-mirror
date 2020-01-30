package de.mkammerer.headermirror;

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

    @Get(produces = MediaType.TEXT_PLAIN)
    @NonBlocking
    public String index(HttpHeaders headers) {
        LOGGER.info("Got request");

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, List<String>> header : headers) {
            sb.append(header.getKey());
            sb.append(": ");
            List<String> values = header.getValue();
            for (int i = 0; i < values.size(); i++) {
                sb.append(values.get(i));

                if (i < values.size() - 1) {
                    sb.append('\n');
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
