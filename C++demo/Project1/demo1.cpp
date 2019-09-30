#include <stdlib.h>
#include <iostream>

using namespace std;


namespace A {
	int x = 1;
	void func() {
		cout<<"this is A func"<<endl;
	}
}
namespace B {
	int x = 2;
	void func1() {
		cout << "this is B func1" << endl;
	}
	void func2() {
		cout << "this is B func2" << endl;
	}
}
int main1() {

	cout<<"hello"<<endl;
	cout <<"A::x==>"<< A::x << endl;
	cout << "B::x==>" <<B::x<<endl;
	A::func();
	B::func1();
	B::func2();
	return 0;
}