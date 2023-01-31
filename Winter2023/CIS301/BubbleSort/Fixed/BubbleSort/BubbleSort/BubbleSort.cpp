#include <iostream>
#include <fstream>
#include <vector>
#include "PersonData.h"

using namespace std;

// Declare functions for later implementation
vector<string> parseString(string, char);
PersonData* newPerson(vector<string>);
int bubbleSort();

// This will store all the people/employee data from the file as PersonData objects
vector<PersonData*> people;

int main(int argc, char** argv)
{

    // If you are testing my code on a different system you will probably need to change this
    string path = "C:\\codeBase\\PlayingAround\\Winter2023\\CIS301\\BubbleSort\\";

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

    // Here comes the sorting
    int comparisons = bubbleSort();

    cout << "It took " << comparisons << " comparisons to sort this list" << endl;

    ofstream ofs;
    ofs.open(path + "test.txt");
    ofs << people.size() << endl;

    for (auto person : people) {
        string str = person->toString();
        ofs << str << endl;
    }

    ofs.close();

}

// Here is my implementation of the given pseudocode
int bubbleSort() {
    int count = 0;
    for (int i = 0; i < people.size(); i++) {
        for (auto j = people.size(); j > (i + 1); j--) {
            count++;
            if (people.at(j - 1)->lessthen(people.at(j - 2))) {
                auto temp = people.at(j - 1);
                people.at(j - 1) = people.at(j - 2);
                people.at(j - 2) = temp;
            }
            for (auto person : people) {
                cout << person->getID() << " ";
            }
            cout << endl;
        }
    }
    return count;
}

// This will separate the string given and return a vector of the string's data
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