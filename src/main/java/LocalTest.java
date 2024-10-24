import java.util.Locale;

public class LocalTest {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        System.out.println("Default Local " + locale);
        //getting all availiable locale from JVM
        Locale[] availiableLocale = Locale.getAvailableLocales();
        for (Locale alocale : availiableLocale) {
            System.out.println("Name of the Locale: " + alocale.getDisplayName());
            System.out.println("Language code " + alocale.getLanguage() + " Country Display " + alocale.getDisplayCountry());
            if (alocale.getScript().equals("")) {
                System.out.println("Selected code " + alocale.getScript() + "Script display Name " + alocale.getDisplayScript());
            }
            if (alocale.getVariant().equals("")) {
                System.out.println("Variant code " + alocale.getVariant() + "Script display Name " + alocale.getDisplayVariant());
            }
            System.out.println("____________________");
        }
    }
}