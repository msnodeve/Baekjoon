package silver4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_10816_숫자카드2 {
    static int N, M;
    static int[] cardList, nesCardList;
    static HashMap<Integer, Integer> carMap;
    static int[] result;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/baekjoon/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());
        cardList = new int[N];
        carMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(!carMap.containsKey(num)){
                carMap.put(num, 1);
            }else{
                carMap.put(num, carMap.get(num)+1);
            }
        }
        M = Integer.parseInt(br.readLine());
        result = new int[M];
        nesCardList = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            nesCardList[i] = Integer.parseInt(st.nextToken());
        }

        // 처리
        for (int i = 0; i < M; i++) {
            if(carMap.containsKey(nesCardList[i])){
                result[i] = carMap.get(nesCardList[i]);
            }else{
                result[i] = 0;
            }
        }

        // 출력
        for(int i : result){
            System.out.print(i + " ");
        }
    }
}
