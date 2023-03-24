#pragma once
#include <string>

using namespace std;

class PersonData
{
private:
	string name;
	int id;
	int age;
	string job;
	int year;
public:
	PersonData(string, int, int, string, int);
	bool checkID(int);
	void print();
	string toString();
};