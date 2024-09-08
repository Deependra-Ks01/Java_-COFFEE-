# JAVA
Hello World program
```sh
  public class HelloWorld{
    public static void main(String[] args){
      System.out.println("Hello World");
    }
  }
```

```sh
  import java.util.*
  public class areaOfCircle{
    public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter the radius of the circle: ");
      Scanner radius = scanner.nextDouble();
      double area = Math.PI * Math.pow(radius, 2);
      System.out.println("The area of the circle is: " + area);
      scanner.close();
    }
  }
```
