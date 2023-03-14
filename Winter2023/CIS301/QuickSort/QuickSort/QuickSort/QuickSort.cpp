#include <iostream>
#include <fstream>
#include <vector>
#include <random>
#include "PersonData.h"

using namespace std;

// Declare functions for later implementation
vector<string> parseString(string, char);
PersonData* newPerson(vector<string>);
void quicksort(int, int);
int partition(int, int);
void randomizedQuicksort(int, int);
int randomizedPartition(int, int);
void treQuicksort(int, int);
void printIDs();
void exchange(int, int);

// This will store all the people/employee data from the file as PersonData objects
vector<PersonData*> people;

int comparisons = 0;

int main(int argc, char** argv)
{

    // If you are testing my code on a different system you will probably need to change this
    string path = "C:\\codeBase\\PlayingAround\\Winter2023\\CIS301\\QuickSort\\";

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
    quicksort(0, people.size() - 1);

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
void quicksort(int low, int high) {
    if (low < high) {
        auto mid = partition(low, high);
        quicksort(low, mid - 1);
        quicksort(mid + 1, high);
    }
}

// Partition will separate the array into an upper and a lower bounds based on the appropriate position of
// the last element in the array. I will move the last element into place and then return the index where
// that element is now located so the array can be further sorted.
int partition(int low, int high) {
    auto pivot = people.at(high);
    int leftArrIndex = low - 1;
    for (int i = low; i <= high - 1; i++) {
        comparisons++;
        if (people.at(i)->lessEqual(pivot)) {
            leftArrIndex++;
            exchange(leftArrIndex, i);
            //printIDs();
        }
    }
    exchange(leftArrIndex + 1, high);
    //printIDs();
    return leftArrIndex + 1;
}

// randomized quicksort calls itself and randomized partition to sort the array
void randomizedQuicksort(int low, int high) {
    if (low < high) {
        auto mid = randomizedPartition(low, high);
        randomizedQuicksort(low, mid - 1);
        randomizedQuicksort(mid + 1, high);
    }
}

// randomizedPartition will get a pseudorandom number between the low and high values, put the item at that
// index at the end of the array and then call the normal partition function to sort the array with the new
// pivot at the end.
int randomizedPartition(int low, int high) {
    random_device rd;
    mt19937 rng(rd());
    uniform_int_distribution<int> uni(low, high);

    auto randomInt = uni(rng);

    exchange(high, randomInt);
    return partition(low, high);
}

// tre-quicksort is an iterative version of quicksort. From the reading, it is likely that the compiler turns the
// normal version of quicksort into this version so as to be less memory heavy, since the second call to quicksort
// is somewhat redundant with an iterative approach.
void treQuicksort(int low, int high) {
    while (low < high) {
        auto part = partition(low, high);
        treQuicksort(low, part - 1);
        low = part + 1;
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