public class Demo {
    public static void main(String[] args) {
        int x = 10;

        if(x == 10) {
            System.out.println("Hello");
        }

        if(x == 10) {  // duplicate condition (issue)
            System.out.println("World");
        }
    }
}