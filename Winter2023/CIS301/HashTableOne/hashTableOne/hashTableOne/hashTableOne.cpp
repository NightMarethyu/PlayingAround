#include <iostream>
#include <fstream>
#include <vector>
#include <random>
#include "PersonData.h"

using namespace std;

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

    vector<PersonData*> hash(arrSize, nullptr);

    vector<vector<PersonData*>> niceHash;

    for (int i = 0; i < arrSize; i++) {
        vector<PersonData*> temp;
        niceHash.push_back(temp);
    }

    const double A = (sqrt(5) - 1) / 2;

    // I loop over the lines in the file, parse the input string, generate a new person object for each
    // then add them to the hash array
    /*for (int i = 0; i < dataCount; i++) {
        string person;
        getline(ifs, person);
        auto p = newPerson(parseString(person, '|'));
        //int key = p->getID() % arrSize;
        int key = (int)(arrSize * (fmod(p->getID() * A, 1)));

        cout << "Attempting to store " << p->getName() << " at index " << key << "...";

        if (hash[key] == nullptr) {
            cout << "SUCCESS!" << endl;
            hash[key] = p;
        }
        else {
            collisions++;
            cout << "Collision! " << hash[key]->getName() << " already stored here" << endl;
        }
    }*/


    // Here I'll do the graceful collisions
    for (int i = 0; i < dataCount; i++) {
        string person;
        getline(ifs, person);
        auto p = newPerson(parseString(person, '|'));
        int key = p->getID() % arrSize;

        cout << "Adding " << p->getName() << " at index " << key << " (";
        if (!niceHash.at(key).empty()) {
            collisions++;
        }
        cout << niceHash.at(key).size() << ") collisions" << endl;

        niceHash.at(key).push_back(p);
    }

    cout << "Total collisions: " << collisions << endl;
}