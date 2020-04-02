package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_9760_PokerGame {

    static int[] cardList;
    static Map<String, Integer> shapeMap;
    static StringBuilder ans;

    public static void main(String[] args) throws Exception {
        // 입력
        System.setIn(new FileInputStream("res/swea/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        top:
        for (int testcase = 1; testcase <= T; testcase++) {
            ans = new StringBuilder();
            cardList = new int[15];
            shapeMap = new HashMap<>();
            shapeMap.put("S", 0);
            shapeMap.put("D", 0);
            shapeMap.put("H", 0);
            shapeMap.put("C", 0);

            StringTokenizer st = new StringTokenizer(br.readLine());
            getList(st);

            int cnt = 0;
            for (int i = 1; i < 15; i++) {
                if (cardList[i] == 1)
                    cnt++;
                else
                    cnt = 0;
                if (cnt == 5) {
                    ans.append(" Straight");
                    break;
                }
            }
            if (ans.length() != 0) {
                if (shapeMap.get("S") == 5 || shapeMap.get("D") == 5 || shapeMap.get("H") == 5 || shapeMap.get("C") == 5) {
                    ans.append(" Flush");
                }
                System.out.println("#" + testcase + ans.toString());
                continue;
            }
            // 2. four card
            for (int i = 1; i <= 14; i++) {
                if (cardList[i] == 4) {
                    ans.append(" Four of a Kind");
                    System.out.println("#" + testcase + ans.toString());
                    continue top;
                }
            }

            // 3. Full House
            boolean three = false;
            boolean two = false;
            for (int i = 1; i <= 14; i++) {
                if (cardList[i] == 3) {
                    three = true;
                } else if (cardList[i] == 2) {
                    two = true;
                }
            }
            if (three && two) {
                ans.append(" Full House");
                System.out.println("#" + testcase + ans.toString());
                continue;
            }

            // 4. Flush
            if (shapeMap.get("S") == 5 || shapeMap.get("D") == 5 || shapeMap.get("H") == 5 || shapeMap.get("C") == 5) {
                ans.append(" Flush");
                System.out.println("#" + testcase + ans.toString());
                continue top;
            }
            // 5. Straight
            // 1번에서 검사함

            // 6. Three of a kind
            for (int i = 1; i < 14; i++) {
                if (cardList[i] == 3) {
                    ans.append(" Three of a kind");
                    System.out.println("#" + testcase + ans.toString());
                    continue top;
                }
            }

            // 7. Two pair
            two = false;
            for (int i = 1; i < 14; i++) {
                if (cardList[i] == 2) {
                    if (two == true) {
                        ans.append(" Two pair");
                        System.out.println("#" + testcase + ans.toString());
                        continue top;
                    } else {
                        two = true;
                    }

                }
            }
            // 8. One pair
            for (int i = 1; i < 14; i++) {
                if (cardList[i] == 2) {
                    ans.append(" One pair");
                    System.out.println("#" + testcase + ans.toString());
                    continue top;
                }
            }
            System.out.println("#" + testcase + " High card");
        }
        /*
            1. Straight Flush : 모두 동일한 슈트에 랭크(값)가 모두 연속적이다(여기서는 로얄 플러쉬를 포함한다. 로얄 플러쉬는 모두 동일한 슈트에 T, J, Q, K, A를 갖는다).
            2. Four of a Kind : 5장 중 4개의 랭크(값)가 모두 같다.
            3. Full House : 3장의 동일한 랭크(값)와 다른 랭크(값)의 동일한 2장으로 구성된다.
            4. Flush : 5장이 모두 동일한 슈트다.
            5. Straight : 다른 슈트가 섞여있으며 랭크(값)가 모두 연속적이다.
            6. Three of a kind : 동일한 랭크(값)가 3장이다(1,2,3,3,3).
            7. Two pair : 동일한 랭크(값) 2장씩 두개의 랭크다(2,6,6,3,3).
            8. One pair : 동일한 랭크가 2장이다(2,4,5,5,7).
            9. High card : 1~8번에 해당하지 않는다.
         */
    }

    private static void getList(StringTokenizer st) {
        for (int i = 0; i < 5; i++) {
            String[] line = st.nextToken().split("");
            switch (line[1]) {
                case "A":
                    shapeMap.put(line[0], shapeMap.get(line[0]) + 1);
                    cardList[1]++;
                    cardList[14]++;
                    break;
                case "T":
                    shapeMap.put(line[0], shapeMap.get(line[0]) + 1);
                    cardList[10]++;
                    break;
                case "J":
                    shapeMap.put(line[0], shapeMap.get(line[0]) + 1);
                    cardList[11]++;
                    break;
                case "Q":
                    shapeMap.put(line[0], shapeMap.get(line[0]) + 1);
                    cardList[12]++;
                    break;
                case "K":
                    shapeMap.put(line[0], shapeMap.get(line[0]) + 1);
                    cardList[13]++;
                    break;
                default:
                    shapeMap.put(line[0], shapeMap.get(line[0]) + 1);
                    cardList[Integer.parseInt(line[1])]++;
                    break;
            }
        }
    }
}
