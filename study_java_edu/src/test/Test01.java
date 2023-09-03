package test;

public class Test01 {
    public static void swap(Integer a, Integer b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("Inside the swap function: a = " + a + ", b = " + b);
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        System.out.println("Before swapping: a = " + a + ", b = " + b);

        swap(a, b);

        System.out.println("After swapping: a = " + a + ", b = " + b);
    }
}
