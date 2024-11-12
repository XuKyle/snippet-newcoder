package com.kylexu.basic;

public class RemoveKDigits {
    public static void main(String[] args) {
        System.out.println(removeKDigits("1593212", 3));
    }

    private static String removeKDigits(String number, int num) {
        for (int i = 0; i < num; i++) {
            boolean found = false;
            for (int j = 0; j < number.length() - 1; j++) {
                if (number.charAt(j) >= number.charAt(j + 1)) {
                    number = number.substring(0, j) + number.substring(j + 1);
                    found = true;
                    break;
                }
            }
            if (!found ){
                number = number.substring(0, number.length()-1);
            }
        }

        while (number.charAt(0)=='0'){
            number = number.substring(1);
        }

        return number;
    }
}
