import java.util.Scanner;
import java.util.regex.*;

public class Identifier {
    public static void main (String args[ ]){
        Scanner cin=new Scanner(System.in);
        String s1=cin.nextLine();
        String s2=cin.nextLine();
        String regex = s1;

        String newStr1 = s1.replace("*", ".*?");
        String newStr2 = s1.replace("*", ".*");
        Pattern patternLazy = Pattern.compile(newStr1);
        Matcher matcherLazy = patternLazy.matcher(s2);
        matcherLazy.find();
        System.out.println(matcherLazy.group());

        Pattern patternGreedy = Pattern.compile(newStr2);
        Matcher matcherGreedy = patternGreedy.matcher(s2);
        matcherGreedy.find();
        System.out.println(matcherGreedy.group());

    }
}
