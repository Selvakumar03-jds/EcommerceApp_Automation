package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotUtils {

    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        try {

            TakesScreenshot screenshot =
                    (TakesScreenshot) driver;

            File source =
                    screenshot.getScreenshotAs(
                            OutputType.FILE
                    );

            String folder =
                    "screenshots/failed/";

            Path directory =
                    Paths.get(folder);

            Files.createDirectories(directory);

            String fileName =
                    testName + "_" +
                            System.currentTimeMillis() +
                            ".png";

            Path destination =
                    directory.resolve(fileName);

            Files.copy(
                    source.toPath(),
                    destination
            );

            return destination.toString();

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }
}
