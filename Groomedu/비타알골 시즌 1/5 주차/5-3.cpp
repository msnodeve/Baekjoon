#include <iostream>
using namespace std;
int main() {
	int N, M;
	cin >> N >> M;
	
	int hs[200][200]{};
	for(int i = 0; i < M; i++){
		int a, b;
		cin >> a >> b;
		
		hs[a-1][b-1] = 1;
		hs[b-1][a-1] = -1;
	}
	
	for(int i = 0; i < N; i++){
		for(int j = 0; j < N; j++){
			if(hs[i][j]){
				for(int k = 0; k < N; k++){
					if(!hs[j][k] && hs[j][i] == hs[i][k]){
						hs[j][k] = hs[j][i];
						hs[k][j] = hs[i][j];
					}
				}
			}
		}
	}
	
	for(int i = 0; i < N; i++){
		int l = 0, s = 0;
		for(int j = 0; j < N; j++){
			if(i != j){
				if(hs[i][j] == 1){
					s++;
				}
				if(hs[j][i] == 1){
					l++;
				}
			}
		}
		cout << l << ' ' << s << endl;
	}
	
	return 0;
}