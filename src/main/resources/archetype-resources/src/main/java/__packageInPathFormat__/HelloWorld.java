package ${package};

public class HelloWorld {

  private static final String HELLO_WORLD = "Hello World!";
  
  public static void main(String[] args) {
    new HelloWorld().helloWorld();
  }
  
  public String helloWorld() {
    return HELLO_WORLD;
  }
}
