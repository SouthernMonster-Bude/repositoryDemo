#include <stdlib.h>
#include <iostream>

using namespace std;

typedef struct {
	int x;
	int y;

}Coord;


//1
//int main(void) {
//	Coord c;
//	Coord& c1 = c;
//	c1.x = 10;
//	c1.y = 20;
//
//	cout<<c1.x<<","<<c1.y<<endl;
//	return 0;
//}


//2
//int main(void) {
//	int a = 3;
//	int *p = &a;
//	int*&q = p;
//	*q = 5;
//	cout << a << endl;
//	system("pause");
//	
//	
//	return 0;
//}


//3
v/*oid fun(int &a,int &b) {
	int c = 0;
	c = a;
	a = b;
	b = c;
}
int main() {
	int x = 10;
	int y = 20;
	cout << "x " << x << " y " << y << endl;
	fun(x, y);
	cout << "x " << x << " y " << y << endl;
	return 0;
}*/