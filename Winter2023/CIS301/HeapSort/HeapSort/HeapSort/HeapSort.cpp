#include <iostream>
#include <fstream>
#include <vector>
#include "PersonData.h"

using namespace std;

// Declare functions for later implementation
vector<string> parseString(string, char);
PersonData* newPerson(vector<string>);
void heapSort();
void maxHeapify(int);
void buildMaxHeap();
void printIDs();
void exchange(int, int);

// This will store all the people/employee data from the file as PersonData objects
vector<PersonData*> people;

int comparisons = 0;
int heapSize;

int main(int argc, char** argv)
{

    // If you are testing my code on a different system you will probably need to change this
    string path = "C:\\codeBase\\PlayingAround\\Winter2023\\CIS301\\HeapSort\\";

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

    ifs.close();

    // Here comes the sorting
    heapSort();

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
void heapSort() {
    //printIDs();
    buildMaxHeap();
    for (int i = people.size() - 1; i >= 1; i--) {
        //printIDs();
        exchange(0, i);
        heapSize--;
        maxHeapify(0);
    }
    //printIDs();
}

// maxHeapify will build a max heap of a portion of the binary tree
void maxHeapify(int val) {
    int largest = val;
    int left = (2 * val) + 1;
    int right = 2 * (val + 1);
    comparisons++;
    if (left <= heapSize && people.at(left)->greaterthen(people.at(val))) {
        largest = left;
    }
    comparisons++;
    if (right <= heapSize && people.at(right)->greaterthen(people.at(largest))) {
        largest = right;
    }
    if (largest != val) {
        exchange(val, largest);
        maxHeapify(largest);
    }
}

// buildMaxHeap will turn the array of data into a max heap by repeatedly calling maxHeapify
void buildMaxHeap() {
    heapSize = people.size() - 1;
    for (int i = people.size() / 2; i >= 0; i--) {
        maxHeapify(i);
    }
}

// This will print the IDs of the array, I broke it out of the bubblesort function because it's easier to comment out and 
// its easier to point out the big-O with it outside
void printIDs() {
    for (auto person : people) {
        cout << person->getID() << " ";
    }
    cout << endl;
}

// I added this small method to cut down on the number of times I need to write this in my code
// all it does it takes two integers representing the index of two objects in the people vector
// and swaps them.
void exchange(int one, int two) {
    auto temp = people.at(one);
    people.at(one) = people.at(two);
    people.at(two) = temp;
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