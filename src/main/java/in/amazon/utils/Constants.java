package in.amazon.utils;

import java.io.File;

public interface Constants {
    String DRIVERS_LOCATION = System.getProperty("user.dir") + File.separator + "drivers";
    String REPORTS_LOCATION = System.getProperty("user.dir") + File.separator + "reports";
    String SCREENSHOT_LOCATION = System.getProperty("user.dir") + File.separator + "screenshots";
    String URL = "https://www.amazon.in";
    int RETRY_COUNT = 1;
}