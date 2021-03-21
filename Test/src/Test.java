import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public StringBuilder stringCheck(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.matches("[a-z0-9\\[\\]]*")) {
            Pattern pattern = Pattern.compile("\\d*\\[[a-z]*\\]");
            while (s.contains("[")) {
               Matcher matcher = pattern.matcher(s);
                while (matcher.find()) {
                    String s1 = matcher.group();
                    char c = s1.charAt(0);
                    String s2 = s1.substring(1).replaceAll("\\[", "")
                            .replaceAll("\\]", "");
                    int i = Integer.parseInt(String.valueOf(c));
                    s = s.replace(s1, s2.repeat(Math.max(0, i)));
                }
            }
            sb.append(s);
        } else {
            System.out.println("Не верный формат строки");
        }
        return sb;
    }
    public static void main(String[] args) {
        Test test = new Test();
//        System.out.println(test.stringCheck("qwe2[kiu3[w2[rer]qer]]asdf4[sdf2[s2[jfg]df]]kh3[uy]yr"));
//        System.out.println(test.stringCheck("12345"));
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(test.stringCheck(text));
    }
}
