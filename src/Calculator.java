public class Calculator {
    private int firstNumber;
    private int secondNumber;
    private String operation;
    private boolean arabicNumber;

    public Calculator(Data date) {
        this.firstNumber = date.getFirstNumber();
        this.secondNumber = date.getSecondNumber();
        this.operation = date.getOperation();
        this.arabicNumber = date.isArabicNumber();
    }


    private int calculate(String operation) {
        int result = 0;
        switch(operation) {
            case "+" :
                result = firstNumber + secondNumber;
                break;
            case "-" :
                result = firstNumber - secondNumber;
                break;
            case "*" :
                result = firstNumber * secondNumber;
                break;
            case "/" :
                result = firstNumber / secondNumber;
                break;

        }
        return result;
    }

    public int getResult() {
        return calculate(operation);
    }

    @Override
    public String toString() {
        if (arabicNumber) {
            return "Результат: \n" + getResult();
        } else {
            return "Результат: \n" + Converter.getNumberRoman(getResult());
        }
    }
}
