import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_3009_네번째점 {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 입력
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if(map1.containsKey(num1)){
                map1.put(num1, map1.get(num1)+1);
            }else{
                map1.put(num1, 1);
            }
            if(map2.containsKey(num2)){
                map2.put(num2, map2.get(num2)+1);
            }else{
                map2.put(num2, 1);
            }
        }

        for (int i : map1.keySet()){
            if(map1.get(i) % 2 == 1){
                System.out.print(i + " ");
                break;
            }
        }
        for (int i : map2.keySet()){
            if(map2.get(i) % 2 == 1){
                System.out.print(i);
                break;
            }
        }
    }
}
