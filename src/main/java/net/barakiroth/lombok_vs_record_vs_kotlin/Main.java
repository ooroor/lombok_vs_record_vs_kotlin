package net.barakiroth.lombok_vs_record_vs_kotlin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger =
            LoggerFactory.getLogger(Main.class);

    public Main() {
        super();
    }

    public static void main(String... args) {
        final Main main = new Main();
        main.run();
    }

    private void run() {
        logger.debug("Running...");
    }
}
