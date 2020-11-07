package MyExceptionPackage;

import java.lang.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Calculator {
    private static float x;
    private static float y;
    public float addition(float x, float y)
    {
        return x + y;
    }
    public float subtraction(float x, float y)
    {
        return x - y;
    }
    public float multiplication(float x, float y)
    {
        return x * y;
    }
    public float division(float x, float y) { return x/y; }
    public void calc() {
        Scanner sc = new Scanner(System.in);
        int ops = sc.nextInt();
        System.out.println("operand 1: ");
        try { //when user doesn`t enter numbers , user get message
            x = sc.nextFloat();
            System.out.println("operand 2: ");
            y = sc.nextInt();
        }
        catch (InputMismatchException ex) {
            System.out.println("/////Введено не число//////");
            System.out.println("Введите заново");
        }
        switch(ops)
        {
            case(1):
                System.out.println("x + y = " +addition(x, y)); break;
            case(2):
                System.out.println("x - y = " +subtraction(x, y)); break;
            case(3):
                System.out.println("x * y = " + multiplication(x, y)); break;
            case(4):
                try { // when user enter second operand "0" , get message about division by zero
                    if (y == 0) throw new MyException(y);
                    else System.out.println("x / y = " +division(x, y));
                }
                catch (MyException e){
                    System.out.println("You can`t divine by " + e.getNumber() + " , try again");
                    System.out.println("What operation? (1 = '+', 2 = '-', 3 = '*', 4 = '/')");
                    calc();
                }
            default: break;
        }
    }
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("What operation? ('+', '-', '*', '/')");
        System.out.println(" Enter 1 for Addition");
        System.out.println(" Enter 2 for Subtraction");
        System.out.println(" Enter 3 for Multiplication");
        System.out.println(" Enter 4 for Division");
        Calculator calc = new Calculator();
        calc.calc();
    }
}
