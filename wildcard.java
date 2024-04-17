import java.util.Scanner;
public class wildcard {
    public static void main (String args[ ]) {
        Scanner cin = new Scanner(System.in);
        int n= cin.nextInt();
        cin.nextLine();  // 读取并丢弃行尾的换行符，需要注意的是Scanner类的nextInt()方法可以读取输入中的下一个整数。这个方法会跳过任何前导的空白字符，然后读取连续的数字字符，直到遇到一个非数字字符。

如果输入中的下一个字符不是数字字符，nextInt()方法会抛出InputMismatchException。如果没有更多的输入，nextInt()方法会抛出NoSuchElementException。

注意，nextInt()方法不会消耗非数字字符，包括换行符。这意味着，如果你在调用nextInt()方法后调用nextLine()方法，nextLine()方法可能会立即返回一个空字符串，因为它读取并消耗了nextInt()方法留下的换行符。
        Judge a=new Judge();
        for(int i=0;i<n;i++)
        {
            String str = cin.nextLine();
            String[] parts = str.split(" ");
            String string1 = parts[0];
            String string2 = parts[1];
            int result=a.judge(string1,string2);
            if(result==1)
            {
                System.out.println("yes");
            }
            else
            {
                System.out.println("no");
            }

        }
    }
}

class Judge{

    public int  judge(String s1,String s2)
    {
        StringBuilder regex = new StringBuilder();
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)=='_')
            {
                regex.append("[^_]");
            }
            else if(s1.charAt(i)=='%')
            {
                regex.append("[^%]*");
            }
            else
            {
                regex.append(s1.charAt(i));
            }
        }
        if(s2.matches(regex.toString()))
        {
            return 1;
        }
        else
        {
            return 0;
        }

    }
}
