import java.util.Scanner;
public class wildcard {
    public static void main (String args[ ]) {
        Scanner cin = new Scanner(System.in);
        int n= cin.nextInt();
        cin.nextLine();  // 读取并丢弃行尾的换行符
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