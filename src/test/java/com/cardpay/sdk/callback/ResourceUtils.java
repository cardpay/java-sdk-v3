package com.cardpay.sdk.callback;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceUtils {

    private final static Logger log = LoggerFactory.getLogger(ResourceUtils.class);

    public static String readFile(String path) {
        try {
            ClassLoader classLoader = ResourceUtils.class.getClassLoader();
            Path filePath = Paths.get(classLoader.getResource(path).toURI());
            return new String(Files.readAllBytes(filePath), UTF_8);
        } catch (IOException | URISyntaxException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

}
