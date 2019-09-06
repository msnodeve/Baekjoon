#include <iostream>
#include <string>
#include <vector>

using namespace std;
int main() {
	int N, M;
	cin >> N >> M;
	// 뿌요 블럭
	string al;
	cin >> al;
	
	al += '!';
		
	vector<pair<char, int>> v;
	for(int i = 0; i < al.size(); i++){
		if(v.empty()){
			v.push_back({al[i], 1});
		}
		else if(v.back().first == al[i]){
			v.back().second += 1;
		}
		else{
			if(v.back().second >= M){
				v.pop_back();
				--i;
			}else{
				v.push_back({al[i], 1});
			}
		}
	}
	
	v.pop_back();
	
	if(v.empty()){
		cout << "CLEAR!";
		return 0;
	}
	
	for (auto &i : v){
		cout << string(i.second, i.first);
	}
	return 0;
}