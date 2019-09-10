#include <iostream>
#include <algorithm>

using namespace std;
int main() {
	int N, M;
	cin >> N >> M;
	
	long long case1[2]={};
	long long case2[2]={};
	long long case3[2]={};
	
	case1[0] = N / 20;
	case1[1] = M / 40;
	case2[0] = M / 20;
	case2[1] = N / 40;
	case3[0] = N / 40;
	case3[1] = M / 40;
	long long result = (1LL * case1[0] * case1[1]) + (1LL * case2[0] * case2[1]) - (case3[0] * case3[1] * 2LL);
	cout << result;
	return 0;
}