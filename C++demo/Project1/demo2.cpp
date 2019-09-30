#include <stdlib.h>
#include <iostream>

using namespace std;

int getMaxOrMin(int *arr,bool isMax) {
	int len = sizeof(arr) / sizeof(arr[0]);
	int temp = arr[0];
	for (int i = 1; i < len;i++) {
		if (isMax) {
			if (temp<arr[i]) {
				temp = arr[i];
			}
		}
		else {
			if (temp > arr[i]) {
				temp = arr[i];
			}
		}
	}
	return temp;
}

int main2() {
	int arr[6] = {3,78,45,12,7,65};
	bool isMax = true;
	cin >> isMax;
	cout<< (isMax ?"最大值":"最小值")<<"是"<<
	getMaxOrMin(arr,isMax);
	return 0;
}