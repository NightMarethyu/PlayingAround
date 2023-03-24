#include <iostream>
#include <fstream>
#include <vector>
#include "PersonData.h"

using namespace std;

// Declare functions for later implementation
vector<string> parseString(string, char);
PersonData newPerson(vector<string>);
int sequentialSearch(int);

// This will store all the people/employee data from the file as PersonData objects
vector<PersonData> people;

int main(int argc, char **argv)
{
    // Check if the correct number of arguments are being used
    if (argc != 2) {
        cout << "Usage: \'FileInput.exe [filepath]\'" << endl;
        exit(1);
    }
    
    // create and open the file
    ifstream ifs;
    ifs.open(argv[1], ios::in);
    // Check if the file is opened properly
    if (!ifs) {
        cout << "Error: File not found" << endl;
        exit(2);
    }

    // I need to get the first line of the file and convert it to an integer
    string gl;
    getline(ifs, gl);

    int count = stoi(gl);

    // I loop over the lines in the file, parse the input string, then generate a new PersonData object for each
    for (int i = 0; i < count; i++) {
        string person;
        getline(ifs, person);
        auto vect = parseString(person, '|');
        auto p = newPerson(vect);
        people.push_back(p);
    }

    getline(ifs, gl);
    count = stoi(gl);
    double totalSearch = 0;

    for (int i = 0; i < count; i++) {
        string idStr;
        getline(ifs, idStr);
        int idNum = stoi(idStr);
        totalSearch += sequentialSearch(idNum);
    }
}

int sequentialSearch(int num) {
    int count = 0;
    for (auto person : people) {
        count++;
        if (person.checkID(num)) {
            cout << "FOUND: " << person.toString() << endl << count << " Comparisions" << endl;
            break;
        }
    }
    return count;
}

// This will separate the string given and return a vector of the string's data
// this function will take a few comments so I don't forget what I did
vector<string> parseString(string s, char c) {

    // I need a vector to store the data from the string
    vector<string> vals;

    // We need to start at the beginning of the string
    size_t pos = 0;

    // We will use this to hold the substrings we make
    string token;

    // Time to loop over the string, the npos variable is a special constant the c++ uses differently
    // depending on the context, here we are making sure we haven't gone outside of the string's length
    while ((pos = s.find(c)) != string::npos) {

        // generate a substring from the beginning of the string to where we found the character
        token = s.substr(0, pos);

        // add the substring to the vector
        vals.push_back(token);

        // remove the substring and the reference character and repeat
        s.erase(0, pos + 1);
    }
    // add anything left in the string to the vector
    vals.push_back(s);
    return vals;
}

// This will generate a new person given a vector containing the appropriate strings
PersonData newPerson(vector<string> v) {
    string name = v.at(0);
    int id = stoi(v.at(1));
    int age = stoi(v.at(2));
    string job = v.at(3);
    int year = stoi(v.at(4));
    PersonData p(name, id, age, job, year);
    return p;
}