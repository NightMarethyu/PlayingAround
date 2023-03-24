#include <iostream>
#include <string>

// namespace makes things easier to type, since these are all working in std, I declared it here
using namespace std;

// Here I declare a function I want to use, I add what it does later in the code
void power();

int main()
{
    string ans;

    // I'm using a do while loop because each time the program is run it will need to do these things at least once
    do {
        cout << "The time has come to see who has TEEN POWER ..." << endl;
        cout << "... and who does NOT." << endl << endl;

        cout << "How old are you? ";

        // Here I make the call to the function I declared earlier
        power();

        cout << endl << "Play again? (y/n) ";
        
        cin >> ans;
    } while (ans == "y");
    

    return 0;
}

// Here is the function with all the stuff in it
void power()
{
    // I get the user's age from cin and store it in an int here
    int age;
    cin >> age;

    // Now I can compare the value the user put in
    // this first condition is if they are a teen, 13 <= age <= 19
    if (age < 20 && age > 12) {
        // Loop their age times and print out "TEEN POWER!!!"
        for (int i = 0; i < age; i++) {
            cout << i + 1 << " TEEN POWER!!!" << endl;
        }
    }
    // If they are younger than a teenager I tell them they can try again when they are a teen
    else if (age <= 12) {
        cout << "No teen power for you." << endl;
        cout << "Try again in " << 13 - age << " years." << endl;
    }
    // If they are older than a teenager I tell them they are too old
    else if (age >= 20) {
        cout << "No teen power for you." << endl;
        cout << "You lost your teen power " << age - 19 << " years ago." << endl;
    }

}