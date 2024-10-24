import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class OutputGenerator {
    public void generateOutput(String languageCode) {
        Locale locale;

        // Create locale based on language code
        switch (languageCode) {
            case "en":
                locale = new Locale("en", "US"); // US English
                break;
            case "fi":
                locale = new Locale("fi", "FI"); // Finnish
                break;
            case "fa":
                locale = new Locale("fa", "IR"); // Farsi example
                break;
            case "ch":
                locale = new Locale("ch", "CH"); // Chinese example
                break;
            default:
                System.out.println("Error: Unsupported language code.");
                return;
        }

        ResourceBundle resourceBundle;

        // Load resource bundle
        try {
            resourceBundle = ResourceBundle.getBundle("messages", locale);
        } catch (MissingResourceException e) {
            System.out.println("Error: Resource bundle not found for locale: " + locale);
            return;
        }

        // Get current time and date
        Date currentDate = new Date();
        DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);

        // Debugging output
        System.out.println("Locale: " + locale);
        System.out.println("Current Date: " + currentDate);
        String currentTime = timeFormat.format(currentDate);
        String currentDateStr = dateFormat.format(currentDate);
        System.out.println("Formatted Time: " + currentTime);
        System.out.println("Formatted Date: " + currentDateStr);

        // Get language-specific messages from resource bundle
        String greeting;
        String instructions;
        try {
            greeting = resourceBundle.getString("greeting");
            instructions = resourceBundle.getString("instructions");
        } catch (MissingResourceException e) {
            System.out.println("Error: One or more keys not found in the resource bundle.");
            return;
        }

        // Replace placeholders with current time and date
        greeting = greeting.replace("{time}", currentTime).replace("{date}", currentDateStr);
        instructions = instructions.replace("{time}", currentTime).replace("{date}", currentDateStr);

        // Display output
        System.out.println(greeting);
        System.out.println(instructions);
    }

}