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
	void print();
	string toString();
	int getID();
	bool lessthen(PersonData*);
	bool greaterthen(PersonData*);
	bool operator>(const PersonData&);
	bool operator<(const PersonData&);
	bool operator>=(const PersonData&);
	bool operator<=(const PersonData&);
	bool operator==(const PersonData&);
	bool operator!=(const PersonData&);
};