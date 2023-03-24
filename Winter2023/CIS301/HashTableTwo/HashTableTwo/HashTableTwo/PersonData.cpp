#include "PersonData.h"
#include <iostream>

using namespace std;

PersonData::PersonData() { 
	name = "empty";
	id = -1;
	age = -1;
	job = "empty";
	year = -1;
}

// The constructor, make a new PersonData object
PersonData::PersonData(string _name, int _id, int _age, string _job, int _year) {
	name = _name;
	id = _id;
	age = _age;
	job = _job;
	year = _year;
}

// converts object data to a string for printing
string PersonData::toString() {
	return name + "|" + to_string(id) + "|" + to_string(age) + "|" + job + "|" + to_string(year);
}

// This will print out the PersonData object in a nice human-readable format
void PersonData::print() {
	cout << "Name:\t\t" << name << endl;
	cout << "ID:\t\t" << id << endl;
	cout << "Age:\t\t" << age << endl;
	cout << "Job:\t\t" << job << endl;
	cout << "Hire year:\t" << year << endl;
	cout << "****************************" << endl;
}

int PersonData::getID() {
	return id;
}

string PersonData::getName() {
	return name;
}

bool PersonData::lessthen(PersonData* other) {
	return id < other->id;
}

bool PersonData::greaterthen(PersonData* other) {
	return id > other->id;
}

bool PersonData::lessEqual(PersonData* other) {
	return id <= other->id;
}

bool PersonData::greaterEqual(PersonData* other) {
	return id >= other->id;
}