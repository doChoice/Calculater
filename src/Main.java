
public class Main {

    public static void main(String[] args) {
        Data data = new Data();
        data.inputData();
        Calculator calculator = new Calculator(data);
        System.out.println(calculator);
    }
}
