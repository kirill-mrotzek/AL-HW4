package com.telran.prof.org.algoritms;

public class HomeworkFour {

    //Расставьте в алфавитном порядке буквы. Разрешается использование техники Разделяй и властвуй.
    // Полученные данные напечатайте.
    //На вход строка: "poiuytrewqlkjhgfdsamnbvcxz"
    //На выходе должно быть: ABCDEFGHIJKLMNOPQRSTUVWXYZ (с большой буквы)

    public static void main(String[] args) {
        String str = "poiuytrewqlkjhgfdsamnbvcxz";
        String sortedStr = sortAlphabet(str);
        System.out.println(sortedStr);
    }

        public static String sortAlphabet(String str) {
        if (str.length() <= 1) {
            return str.toUpperCase();
        }

        String leftStr = str.substring(0, str.length() / 2);
        String rightStr = str.substring(str.length() / 2);

        String sortedLeftStr = sortAlphabet(leftStr);
        String sortedRightStr = sortAlphabet(rightStr);

        // Объединяем отсортированные части
        return merge(sortedLeftStr, sortedRightStr);
    }

         public static String merge(String leftStr, String rightStr) {
        StringBuilder mergedStr = new StringBuilder();
        int i = 0, j = 0;

            while (i < leftStr.length() && j < rightStr.length()) {
            if (leftStr.charAt(i) < rightStr.charAt(j)) {
                mergedStr.append(leftStr.charAt(i));
                i++;
            } else {
                mergedStr.append(rightStr.charAt(j));
                j++;
            }
        }

            while (i < leftStr.length()) {
            mergedStr.append(leftStr.charAt(i));
            i++;
        }

        while (j < rightStr.length()) {
            mergedStr.append(rightStr.charAt(j));
            j++;
        }

        return mergedStr.toString().toUpperCase();
    }
}

