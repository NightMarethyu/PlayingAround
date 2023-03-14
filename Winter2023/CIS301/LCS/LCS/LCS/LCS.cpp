#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

// This enum represents the arrows in the b array from the pseudocode
enum Arrow {
    up,
    leftArrow,
    corner
};

// Here are my arrays for keeping track of the calculations
int** cArr;
Arrow** bArr;

// This is the implementation of the pseudocode. This function will calculate the length of the 
// longest common subsequence.
void lcsLength(string strOne, string strTwo) {
    int m = strOne.length();
    int n = strTwo.length();

    cArr = new int* [m+1];
    bArr = new Arrow * [m + 1];

    // Each of the rows in the 2D array need data inside them. I decided that I need to fill in the 0s so I might as well add the
    // second dimension of the arrays here
    for (int i = 0; i <= m; i++) {
        cArr[i] = new int[n + 1];
        bArr[i] = new Arrow[n + 1];
        cArr[i][0] = 0;
    }

    for (int j = 0; j <= n; j++) {
        cArr[0][j] = 0;
    }

    // This nested loop will compare the characters of the strings to find the LCS
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (strOne[i - 1] == strTwo[j - 1]) {
                cArr[i][j] = cArr[i - 1][j - 1] + 1;
                bArr[i][j] = corner;
            }
            else if (cArr[i - 1][j] >= cArr[i][j - 1]) {
                cArr[i][j] = cArr[i - 1][j];
                bArr[i][j] = up;
            }
            else {
                cArr[i][j] = cArr[i][j - 1];
                bArr[i][j] = leftArrow;
            }
        }
    }
}

// This is the implementation of the pseudocode to print out an example of the LCS
void printLCS(string first, int i, int j) {
    if (i == 0 || j == 0) {
        return;
    }

    switch (bArr[i][j]) {
    case corner:
        printLCS(first, i - 1, j - 1);
        cout << first[i - 1];
        break;
    case up:
        printLCS(first, i - 1, j);
        break;
    default:
        printLCS(first, i, j - 1);
    }
}

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

    // Get both lines of the file and save them for later use
    string line1;
    string line2;
    getline(ifs, line1);
    getline(ifs, line2);

    cout << "Line 1: " << line1 << endl << "Line 2: " << line2 << endl << "LCS: ";

    // Here are the calls to the functions that will calculate the length and then print out the LCS
    lcsLength(line1, line2);
    printLCS(line1, line1.length(), line2.length());

    cout << endl;
    
}
