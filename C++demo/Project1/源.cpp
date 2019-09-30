#include <stdlib.h>
#include <iostream>
using namespace std;


int main() {

	const int x = 3;
	int y = 6;
	int z = 9;
	int const* p = &y;
	const int* q = &y;
	int* const t = &y;

	system("puase");
	return 0;
}