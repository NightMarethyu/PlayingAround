#include <iostream>
#include <fstream>
#include <vector>
#include "PersonData.h"

using namespace std;

// Declare functions for later implementation
vector<string> parseString(string, char);
PersonData* newPerson(vector<string>);
void mergeSort(int, int);
void merge(int, int, int);
void printIDs();

// This will store all the people/employee data from the file as PersonData objects
vector<PersonData*> people;

int comparisons = 0;

int main(int argc, char** argv)
{

    // If you are testing my code on a different system you will probably need to change this
    string path = "C:\\codeBase\\PlayingAround\\Winter2023\\CIS301\\SelectionSort\\";

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

    int dataCount = stoi(gl);

    // I loop over the lines in the file, parse the input string, then generate a new PersonData object for each
    for (int i = 0; i < dataCount; i++) {
        string person;
        getline(ifs, person);
        auto vect = parseString(person, '|');
        auto p = newPerson(vect);
        people.push_back(p);
    }

    // Here comes the sorting
    mergeSort(0, people.size());

    cout << "It took " << comparisons << " comparisons to sort this list" << endl;

    ofstream ofs;
    ofs.open(path + "sorted.txt");
    ofs << people.size() << endl;

    for (auto person : people) {
        string str = person->toString();
        ofs << str << endl;
    }

    ofs.close();

}

// Here is my implementation of the given pseudocode
void mergeSort(int low, int high) {
    if (low >= high) {
        return;
    }
    int mid = (low + high) / 2;
    mergeSort(low, mid);
    mergeSort(mid + 1, high);
    merge(low, mid, high);
}

void merge(int low, int mid, int high) {
    int nl = mid - low + 1;
    int nr = high - mid;
    vector<PersonData*> L;
    vector<PersonData*> R;

    for (int i = 0; i < nl; i++) {
        L.push_back(people.at(low + i));
    }
    for (int i = 0; i < nr; i++) {
        if (mid + i + 1 == people.size()) {
            R.push_back(people.at(people.size() - 1));
        }
        else {
            R.push_back(people.at(mid + i + 1));
        }
    }
    int i = 0;
    int j = 0;
    int k = low;

    while (i < nl && j < nr) {
        comparisons++;
        if (L.at(i)->lessEqual(R.at(j))) {
            people.at(k) = L.at(i);
            i++;
        }
        else {
            people.at(k) = R.at(j);
            j++;
        }
        k++;
    }
    while (i < nl) {
        comparisons++;
        people.at(k) = L.at(i);
        i++;
        k++;
    }
    while (j < nr) {
        comparisons++;
        people.at(k) = R.at(j);
        j++;
        k++;
    }
    printIDs();
}

// This will print the IDs of the array, I broke it out of the bubblesort function because it's easier to comment out and 
// its easier to point out the big-O with it outside
void printIDs() {
    for (auto person : people) {
        cout << person->getID() << " ";
    }
    cout << endl;
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