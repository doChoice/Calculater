import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Data {
    private int firstNumber;
    private int secondNumber;
    private String operation;
    private boolean arabicNumber;
    private Scanner scanner = new Scanner(System.in);

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public String getOperation() {
        return operation;
    }

    public boolean isArabicNumber() {
        return arabicNumber;
    }

    public void inputData() {
        System.out.println("Введите в одной строке два целых числа и знак операции между ними (+, -, *, /).\n" +
                "Числа от 1 до 10 могут быть или арабскими или римскими.\n" +
                "Числа и знаки водятся через пробел!");

        String inputData = scanner.nextLine();

        String[] dataForCalculate = inputData.split("\\s");

        if (dataForCalculate.length != 3) {
            System.out.println("Повторите ввод данных");
            inputData();
        }

        // Проверка введенных чисел на отрицательность
        if (dataForCalculate[0].matches("^-+.*") || dataForCalculate[2].matches("^-+.*")) {
            throw new IllegalArgumentException("Вы ввели отрицательные числа : " + dataForCalculate[0] + " и " +
                    dataForCalculate[2] + ". Числа могут быть только пложительными.");
        }
        // Проверка введенных чисел на принадлежность к арабской или римской системе счисления
        if(dataForCalculate[0].matches("\\d+") && dataForCalculate[2].matches("\\d+")) {
            firstNumber = parseInt(dataForCalculate[0]);
            secondNumber = parseInt(dataForCalculate[2]);
            arabicNumber = true;

        } else if (dataForCalculate[0].matches("[IVXC]+") && dataForCalculate[2].matches("[IVXC]+")) {
            firstNumber = Converter.getNumberArabic(dataForCalculate[0]);
            secondNumber = Converter.getNumberArabic(dataForCalculate[2]);
            arabicNumber = false;
        } else {
            throw new IllegalArgumentException("Вы ввели некорректные числа : " + dataForCalculate[0] + " и " + dataForCalculate[2] +
                    ". Числа могут быть или арабскими или римскими цифрами.");
            }

        //Проверка введенных чисел на соответствию диапазона 1-10
        if(firstNumber > 10 || firstNumber < 1 || secondNumber > 10 || secondNumber < 1) {
            throw new IllegalArgumentException("Вы ввели некорректные числа : " + dataForCalculate[0] + " и " + dataForCalculate[2] +
                    ". Числа могут быть от 1 до 10 или арабскими или римскими цифрами.");
        }

        //Проверка допустимости операции
        if (dataForCalculate[1].matches("[+-/*]")) {
            operation = dataForCalculate[1];
        } else {
            throw new IllegalArgumentException("Неизвестная операция");
        }
    }
}
