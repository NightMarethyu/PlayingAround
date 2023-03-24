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
	PersonData();
	PersonData(string, int, int, string, int);
	void print();
	string toString();
	int getID();
	string getName();
	bool lessthen(PersonData*);
	bool greaterthen(PersonData*);
	bool lessEqual(PersonData*);
	bool greaterEqual(PersonData*);
};