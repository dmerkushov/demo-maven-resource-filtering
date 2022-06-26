# demo-maven-resource-filtering

This is to show the concept of Maven resource filtering (Maven placeholder replacement). Use it to supply Maven's POM values 
to your running code.

## Howto

1. Make sure you use Java 9 or higher, otherwise only ISO-8859-1 characters will be available (*). In this demo, we use Java 11 
   as it is the earliest LTS release satisfying the condition.
2. Configure a filtered resource directory in your POM's `<build>` section:
```xml
<resources>
    <resource>
        <directory>src/main/resources-filtered</directory>
        <filtering>true</filtering>
    </resource>
</resources>
```
3. Create a `.properties` file in the filtered resource directory, with placeholders to use Maven values, like
```properties
version=${project.version}
```
4. Read this properties file in your code, like
```java
InputStream fromPom = Main.class.getResourceAsStream("/fromPom.properties");
Properties properties = new Properties();
properties.load(fromPom);
```
5. From now on, you may use the POM-supplied values in your code!
```java
String version = properties.getProperty("version", "UNKNOWN");
System.out.println("Hallo world! My version is " + version);
```
(*) Since Java 9, `.properties` files are read using UTF-8.
See https://maven.apache.org/plugins/maven-resources-plugin/examples/filtering-properties-files.html