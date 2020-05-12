package VitaalgoSeason1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_0302_인싸가되고싶은민수 {

    static int a, b;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/etc/sample.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        if(a != b){
            System.out.println(2);
        }else{
            System.out.println(getOptimal(b));
        }
    }

    private static int getOptimal(int num) {
        int sqrtNum = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrtNum; i++) {
            if(num % i == 0)
                return i;
        }
        return num;
    }
}
