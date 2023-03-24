#include "PersonData.h"
#include <iostream>

using namespace std;

// The constructor, make a new PersonData object
PersonData::PersonData(string _name, int _id, int _age, string _job, int _year) {
	name = _name;
	id = _id;
	age = _age;
	job = _job;
	year = _year;
}

// checks if given ID number is less then or equal
bool PersonData::compareID(int n) {
	return n <= id;
}


// checks if ID is equal
bool PersonData::checkID(int n) {
	return id == n;
}


// converts object data to a string for printing
string PersonData::toString() {
	return "Name: " + name + ", Age: " + to_string(age) + ", Job: " + job + ", Hired: " + to_string(year);
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