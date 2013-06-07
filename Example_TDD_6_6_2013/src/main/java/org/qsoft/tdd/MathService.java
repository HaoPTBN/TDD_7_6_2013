package org.qsoft.tdd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: haopt
 * Date: 6/6/13
 * Time: 2:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class MathService {
    private static String processString(String numbers) {
        numbers = numbers.replace("\n", ",").replace("!", ",").replace("~", ",").replace("@", ",").replace("#", ",").replace("$", ",").replace("%", ",").replace("^", ",").replace("&", ",").replace("*", ",").replace("(", ",").replace(")", ",").replace("_", ",").replace("+", ",").replace("=", ",").replace(">", ",").replace("/", ",").replace("?", ",").replace(";", ",").replace(":", ",").replace("'", ",").replace("\"", ",").replace("[", ",").replace("{", ",").replace("]", ",").replace("}", ",").replace("\\", ",").replace("|", ",").replace("`", ",").replace(",", ",").replace(".", ",").replace("<", ",").replace("^", ",").replace("&", ",").replace("*", ",").replace("(", ",").replace(")", ",").replace("_", ",").replace("+", ",").replace("=", ",");
        return numbers;
    }

    private static String processDelimiter(String numbers) {
        List<String> delemites = new ArrayList<String>();
        StringBuffer sb = new StringBuffer(numbers);
        int begin = 0;
        int end = 0;
        while (true) {
            begin = sb.indexOf("[", end);
            end = sb.indexOf("]", end);
            if ((begin == -1) || (end == -1)) {
                break;
            }
            if (begin > end) {
                end = sb.indexOf("]", begin);
                if (end == -1) {
                    continue;
                }
            }
            delemites.add(sb.substring(begin, end + 1));
            delemites.add(sb.substring(begin + 1, end));
            end += 1;
        }
        String stringReturn = sb.toString();
        if (delemites.size() > 0) {
            for (Iterator<String> it = delemites.iterator(); it.hasNext(); ) {
                String str = it.next();
                System.out.println("---:" + str);
                stringReturn = stringReturn.replace(str, ",");
            }
        }
        System.out.println("---ee:" + stringReturn);
        return stringReturn;
    }

    public static int methodAdd(String numbers) throws Exception {
        int numberReturn = 0;
        if (numbers == null || numbers.equals("")) {
            numberReturn = 0;
        } else {
            numbers = processDelimiter(numbers);
            numbers = processString(numbers);
            String[] arrayString = numbers.split(",");
            int index = arrayString.length;
            for (int i = 0; i < index; i++) {
                if (!arrayString[i].equals("")) {
                    int intAdd = Integer.valueOf(arrayString[i]);
                    if (intAdd < 0) {
                        throw new Exception("Negatives not allowed " + (intAdd));
                    }
                    if (intAdd < 1000) {
                        numberReturn += intAdd;
                    }
                }
            }
        }
        return numberReturn;
    }
}
