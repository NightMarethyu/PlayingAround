#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

// This struct is the foundation of the BST, it points to the other nodes in the tree and contains
// the integer data.
struct Node {
    Node* head;
    Node* left;
    Node* right;
    int value;
};

// This is the head of the search tree, that's why I've named it searchTree. The first node added will be here
Node* searchTree = NULL;

// Creating a new node is easier with a simple function like this. This points each of the node's pointers to null
// this makes it easier for the other functions to work properly
Node* newNode(int n) {
    Node* temp = new Node;
    temp->head = NULL;
    temp->left = NULL;
    temp->right = NULL;
    temp->value = n;
    return temp;
}

// this will split a string based on the char provided
vector<string> split(string s, char c) {
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

// This is the add pseudo-code implementation from the book. The new node will be added based on it's relative
// value to the other nodes.
void add(Node* n) {
    Node* current = searchTree;
    Node* previous = NULL;
    while (current != NULL) {
        previous = current;
        if (n->value < current->value) {
            current = current->left;
        }
        else {
            current = current->right;
        }
    }
    n->head = previous;
    if (previous == NULL) {
        searchTree = n;
    }
    else if (n->value < previous->value) {
        previous->left = n;
    }
    else {
        previous->right = n;
    }
}

// This is the find pseudo-code implementation. It will print the found once it has located the correct node.
void find(int n) {
    auto current = searchTree;
    while (current != NULL && current->value != n) {
        cout << current->value << " ";
        if (n < current->value) {
            current = current->left;
        }
        else {
            current = current->right;
        }
    }

    if (current) {
        cout << "Found " << current->value << endl;
    }
    else {
        cout << "Could not find " << n << endl;
    }
}

void clearTree(Node* current) {
    if (current) {
        clearTree(current->left);
        clearTree(current->right);
        delete current;
    }
}

// This will print the nodes in preorder traversal
void preorder(Node* n) {
    if (n != NULL) {
        cout << n->value << " ";
        preorder(n->left);
        preorder(n->right);
    }
}

// This will print the nodes in inorder traversal
void inorder(Node* n) {
    if (n != NULL) {
        inorder(n->left);
        cout << n->value << " ";
        inorder(n->right);
    }
}

// This will print the nodes in postorder traversal
void postorder(Node* n) {
    if (n != NULL) {
        postorder(n->left);
        postorder(n->right);
        cout << n->value << " ";
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

    // Get the first line from the file and turn it into an integer
    string command;
    getline(ifs, command);

    int commands = stoi(command);

    // Loop through the file for the number of commands given and follow the instructions in the commands.
    for (int i = 0; i < commands; i++) {
        getline(ifs, command);
        auto c = split(command, ' ');

        // this is my really big if-else tree, it processes each command as it comes from the file.
        if (c[0] == "ADD") {
            cout << "Adding " << c[1] << endl;
            add(newNode(stoi(c[1])));
        }
        else if (c[0] == "FIND") {
            cout << "Looking for " << c[1] << "...";
            if (searchTree) {
                find(stoi(c[1]));
            }
            else {
                cout << "Could not find " << c[1] << endl;
            }
        }
        else if (c[0] == "CLEAR") {
            cout << "(tree deleted)" << endl;
            if (searchTree) {
                clearTree(searchTree);
                searchTree = NULL;
            }
        }
        else if (c[0] == "PREORDER") {
            if (searchTree) {
                cout << "PREORDER: ";
                preorder(searchTree);
                cout << endl;
            }
        }
        else if (c[0] == "INORDER") {
            if (searchTree) {
                cout << "INORDER: ";
                inorder(searchTree);
                cout << endl;
            }
        }
        else if (c[0] == "POSTORDER") {
            if (searchTree) {
                cout << "POSTORDER: ";
                postorder(searchTree);
                cout << endl;
            }
        }
    }
}
