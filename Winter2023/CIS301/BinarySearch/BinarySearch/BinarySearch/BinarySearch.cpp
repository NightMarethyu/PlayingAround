#include <iostream>
#include <fstream>
#include <vector>
#include "PersonData.h"

using namespace std;

// Declare functions for later implementation
vector<string> parseString(string, char);
PersonData* newPerson(vector<string>);
int binarySearch(int);

// This will store all the people/employee data from the file as PersonData objects
vector<PersonData*> people;

int main(int argc, char** argv)
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

    // gets the number of ID searches to perform
    getline(ifs, gl);
    count = stoi(gl);
    double totalSearch = 0;

    // loops through the document to search for given ID numbers
    for (int i = 0; i < count; i++) {
        string idStr;
        getline(ifs, idStr);
        int idNum = stoi(idStr);
        totalSearch += binarySearch(idNum);
    }

    // prints out the average number of searches per input number
    cout << "Done! Average amount of work per query: ";
    double average = totalSearch / count;
    cout << average << " comparisons." << endl;
}

// Here is my implementation of the given pseudocode
// num is the given ID number to be found
int binarySearch(int num) {
    int count = 0;
    int low = 0;
    int high = people.size() - 1;
    while (low < high) {
        int mid = (low + high) / 2;
        count++;
        if (people.at(mid)->compareID(num)) {
            high = mid;
        }
        else {
            low = mid + 1;
        }
    }
    cout << "Found: " << people.at(high)->toString() << endl << "at index " << high << " after " << count << " Comparisons" << endl;
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
PersonData* newPerson(vector<string> v) {
    string name = v.at(0);
    int id = stoi(v.at(1));
    int age = stoi(v.at(2));
    string job = v.at(3);
    int year = stoi(v.at(4));
    PersonData* p = new PersonData(name, id, age, job, year);
    return p;
}