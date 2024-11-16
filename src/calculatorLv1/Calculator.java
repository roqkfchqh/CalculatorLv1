package calculatorLv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner calculation = new Scanner(System.in);

        while (true){
            try{
                System.out.println("첫 번째 숫자를 입력하고 엔터");
                int firstNumber = calculation.nextInt();
                if(firstNumber < 0){
                    System.out.println("양의 정수만 계산이 가능합니다. 계산기를 재실행합니다");
                    continue;
                }
                System.out.println("연산자(+, -, *, /)를 입력하고 엔터");
                char operator = calculation.next().charAt(0);
                if(operator != '+' && operator != '-' && operator != '*' && operator != '/'){
                    System.out.println("+, -, *, /만 입력 가능합니다.");
                    continue;
                }
                System.out.println("두 번째 숫자를 입력하고 엔터");
                int secondNumber = calculation.nextInt();
                if(secondNumber < 0){
                    System.out.println("양의 정수만 계산이 가능합니다. 계산기를 재실행합니다");
                    continue;
                }

                System.out.println("계산 결과는 : " + calculate(operator, firstNumber, secondNumber));
                System.out.println("더 계산하시겠습니까? 아무 키나 입력.(exit 입력 시 종료)");
                calculation.nextLine();
                String input = calculation.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                calculation.next();
            }
        }
    }

    public static int calculate(char operator, int firstNumber, int secondNumber){
        int result = 0;
        switch(operator){
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if(secondNumber == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return 0;
                } else {
                    result = firstNumber / secondNumber;
                    break;
                }
            default:
                break;
        }
        return result;
    }
}
