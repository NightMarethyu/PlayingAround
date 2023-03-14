#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

struct Employee {
    string name;
    int id;
    int age;
    string job;
    int year;
};

int main(int argc, char* argv[]) {
    if (argc != 2) {
        cout << "Usage: " << argv[0] << " filename\n";
        return 1;
    }

    string filename = argv[1];
    ifstream infile(filename);
    if (!infile) {
        cout << "Error: could not open file " << filename << endl;
        return 1;
    }

    int m, n;
    infile >> m >> n;

    vector<Employee> employees(n);

    int collisions = 0;
    vector<Employee*> hash_table(m, nullptr);

    for (int i = 0; i < n; i++) {
        Employee& employee = employees[i];
        infile >> employee.name >> employee.id >> employee.age >> employee.job >> employee.year;

        int index = employee.id % m;
        Employee* p = hash_table[index];

        if (p == nullptr) {
            hash_table[index] = &employee;
        }
        else {
            cout << "Collision at index " << index << ": " << employee.name << " (ID " << employee.id << ") collides with " << p->name << " (ID " << p->id << ")" << endl;
            collisions++;
        }
    }

    cout << "Total collisions: " << collisions << endl;

    return 0;
}
