import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1863_종교 {
	static int [] parents;
	static int [] rank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parents = new int[n+1];
		rank = new int[n+1];

		for(int i = 1; i<=n; i++) {
			parents[i] = i;
		}

		for(int i = 0; i<m; i++) {
			st = new StringTokenizer( br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}

		int cnt = 0;
		for(int i = 1; i<=n; i++) {
			if(i == parents[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	public static int find(int x) {
		if(x == parents[x]) {
			return x;
		}
		parents[x] = find(parents[x]);
		return parents[x];
	}

	public static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(rank[px]<rank[py]) {
			parents[px] = py;
		}
		else {
			parents[py] = px;
			if(rank[px] == rank[py]) {
				rank[px]++;
			}
		}
	}

}