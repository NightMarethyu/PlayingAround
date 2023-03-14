#include <iostream>
#include <fstream>
#include <vector>
#include <cmath>
#include "PersonData.h"

using namespace std;

// this is my string parsing function written for the sorting algorithms
vector<string> parseString(string s, char c) {
    vector<string> vals;
    size_t pos = 0;
    string token;
    while ((pos = s.find(c)) != string::npos) {
        token = s.substr(0, pos);
        vals.push_back(token);
        s.erase(0, pos + 1);
    }
    vals.push_back(s);
    return vals;
}

// Here is my hash function, it's similar to the hash function that Java uses, based on what we saw in class.
int stringHash(string name) {
    int hash = 0;
    int n = name.length();
    for (int i = 0; i < n; i++) {
        hash += (int)pow(name[i], n - i);
    }
    return (hash < 0) ? -hash : hash;
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

int main(int argc, char** argv) {
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

    const int arrSize = stoi(gl);

    // Convert the second line into an integer too
    getline(ifs, gl);

    int dataCount = stoi(gl);

    int collisions = 0;

    vector<vector<PersonData*>> niceHash;

    // fill the empty vector with more empty vectors
    for (int i = 0; i < arrSize; i++) {
        vector<PersonData*> temp;
        niceHash.push_back(temp);
    }

    // This will use the names to calculate the hash key and store them.
    for (int i = 0; i < dataCount; i++) {
        string person;
        getline(ifs, person);
        auto p = newPerson(parseString(person, '|'));
        int key = stringHash(p->getName()) % arrSize;

        cout << "Adding " << p->getName() << " at index " << key << " (" << niceHash.at(key).size() << ") collisions" << endl;

        niceHash.at(key).push_back(p);
    }

    cout << endl << endl;

    // skip the line of "***" and get the number of names to lookup
    getline(ifs, gl);
    getline(ifs, gl);

    dataCount = stoi(gl);

    // loop through the lookup data and print out the found values
    for (int i = 0; i < dataCount; i++) {
        string name;
        getline(ifs, name);
        int key = stringHash(name) % arrSize;
        PersonData* found = NULL;

        int col = 0;

        // This loop will check the internal vector for the desired value
        for (auto p : niceHash[key]) {
            col++;
            if (p->getName() == name) {
                found = p;
                break;
            }
        }

        collisions += col;

        cout << "Found " << name << " after " << col << " collisions at index " << key << endl;
        cout << "COMPLETE RECORD: " << found->toString() << endl;
    }

    cout << "Total collisions: " << collisions << endl;
}