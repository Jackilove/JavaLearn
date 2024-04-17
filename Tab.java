import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Tab {
    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        int n=cin.nextInt();
        cin.nextLine(); //处理换行符
        String s;
        Tab_get t=new Tab_get();
        Tab_get.num=n;
        for(int i=0;i<n;i++)
        {
            s= cin.nextLine();
            t.list[i]=s;
        }
        t.list[n]= cin.nextLine();
        t.Auto_Tab();
    }
}

class Tab_get {
    static int num;
    String[] list = new String[100];
    static String s;

    public void Auto_Tab() {
        ArrayList<String> resList = new ArrayList<>();
        s= list[num];
        for (int j = 0; j < num; j++) {
            if (list[j].startsWith(s)) {
                resList.add(list[j]);
            }
        }
        String[] res = resList.toArray(new String[0]);
        Arrays.sort(res);
        for (String str : res) {
            System.out.println(str);
        }
    }
}