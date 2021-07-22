package utils;

public class Test {
    public static void main(String[] args) {
        PropertyReader propertyReader = new PropertyReader("src/main/resources/configuration.properties");
        System.out.println(propertyReader.getPropertyValueByKey("login"));
        System.out.println(propertyReader.getPropertyValueByKey("blabla"));
    }
}
