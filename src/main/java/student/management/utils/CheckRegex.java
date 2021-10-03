package student.management.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckRegex {
    public static boolean validateName(String regex) {
        String ACCOUNT_REGEX = "^([AÀẢÃÁẠĂẰẮẲẴẶÂẤẦẨẪẬBCDĐEÈÉẺẼẸÊỀẾỂỄỆFGHIÍÌỈĨỊJKLMNOÒÓỎÕỌÔỒỐỔỖỘƠỜỚỞỠỢPQRSTUÙÚỦŨỤƯỪỨỬỮỰVWXYÝỲỶỸỴZ]" +
                "[aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+[ ]*)+$";
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateMail(String regex) {
        String ACCOUNT_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher  matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateAcc(String regex) {
        String ACCOUNT_REGEX = "^[_a-z0-9]{6,}$";
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher  matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateDob(String regex) {
        String ACCOUNT_REGEX = "([0-2]?[0-9]|(3)[0-1])[-|/](((0)?[0-9])|((1)[0-2]))[-|/](((1)(9)[9][0-9])|((2)(0)[0-1][0-5]))";
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher  matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            float d = Float.parseFloat(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
