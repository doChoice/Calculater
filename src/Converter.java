public class Converter {

    private static final String[] romanNumbers = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] arabicNumbers = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static String getNumberRoman(int numberArabic) {
        return convertArabicToRomanNumbers(numberArabic);
    }

    public static int getNumberArabic(String numberRoman) {
        return convertRomanToArabicNumbers(numberRoman);
    }

    private static String convertArabicToRomanNumbers(int number) {

        StringBuilder stringBuilder = new StringBuilder();

        if (number == 0) {
            stringBuilder.append("nullo");
        } else if (number < 0) {
            stringBuilder.append("-");
            number *= -1;
        }
        int i = 0;
        while (number > 0) {
            if(arabicNumbers[i] <= number) {
                stringBuilder.append(romanNumbers[i]);
                number -= arabicNumbers[i];
            } else {
                i++;
            }
        }
        return stringBuilder.toString();
    }

    private static int convertRomanToArabicNumbers(String number) {
        int result = 0;
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder(number);

        while (i < romanNumbers.length) {
            int offset = romanNumbers[i].length();
            if (offset <= stringBuilder.length() && romanNumbers[i].equals(stringBuilder.substring(0, offset))) {
                result += arabicNumbers[i];
                stringBuilder.delete(0, offset);
            } else {
                i++;
            }
        }

        return result;
    }

}
