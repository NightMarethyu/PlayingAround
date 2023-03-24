#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <map>

using namespace std;

struct Node;
struct Edge;
Edge* getBestEdge();
void DraperMST(Node*);
vector<string> split(string, char);
Node* newNode(char);
Edge* newEdge(Node*, Node*, int);
void printEdge(Edge*);

vector<Edge*> bucket;
map<char, Node*> nodes;

int main(int argc, char** argv)
{
    // Check if the correct number of arguments are being used
    if (argc != 2) {
        cout << "Usage: \'MST.exe [filepath]\'" << endl;
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

    string names;
    getline(ifs, names);

    // Create nodes for all the characters in the input string
    for (char let : names) {
        nodes[let] = newNode(let);
    }

    // This is the node that we will start with
    char start = names[0];

    getline(ifs, names);
    int c = stoi(names);

    // Create edges with the lines in the file
    for (int i = 0; i < c; i++) {
        getline(ifs, names);
        auto edgeInfo = split(names, ' ');
        int w = stoi(edgeInfo[2]);
        newEdge(nodes[edgeInfo[0][0]], nodes[edgeInfo[1][0]], w);
    }

    // This function will do the bulk of the work
    DraperMST(nodes[start]);

}

// Here are my node and edge definitions
struct Node {
    char name;
    vector<Edge*> edges;
    bool visited;
};

struct Edge {
    Node* one;
    Node* two;
    int weight;
};

// This is based on Brother Draper's Pseudocode that he gave us. I found it fairly simple to implement
// It will loop until it has found all the possible best edges in the Tree
void DraperMST(Node* start) {
    vector<Edge*> mst_edges;
    int totalWeight = 0;
    bucket.insert(end(bucket), begin(start->edges), end(start->edges));
    Edge* e = getBestEdge();
    while (e) {
        e->one->visited = true;
        bucket.insert(end(bucket), begin(e->one->edges), end(e->one->edges));
        e->two->visited = true;
        bucket.insert(end(bucket), begin(e->two->edges), end(e->two->edges));
        totalWeight += e->weight;
        mst_edges.push_back(e);
        e = getBestEdge();
    }
    cout << "Total Weight: " << totalWeight << endl << "Edges are:" << endl;
    for (auto e : mst_edges) {
        printEdge(e);
    }
}

// This method will loop through the bucket and return the edge with the lowest weight who's nodes
// are not both visited. It will return a null pointer if it can't find an edge that fits that definition
Edge* getBestEdge() {
    Edge* best = nullptr;
    while (best == nullptr && !bucket.empty()) {
        best = bucket[0];
        int bestIndex = 0;
        for (int i = 0; i < bucket.size(); i++) {
            auto e = bucket[i];
            if (e->weight < best->weight) {
                best = e;
                bestIndex = i;
            }
        }
        if (best->one->visited && best->two->visited) {
            bucket.erase(bucket.begin() + bestIndex);
            best = nullptr;
        }
    }
    return best;
}

// this is a string spliting function that I've been using all semester
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

// This will generate a node that hasn't been visited with a name based on the input char
Node* newNode(char n) {
    Node* temp = new Node;
    temp->name = n;
    temp->visited = false;
    return temp;
}

// This will generate a new edge and place that edge within the vectors of the nodes its connected to
Edge* newEdge(Node* first, Node* second, int w) {
    Edge* temp = new Edge;
    temp->one = first;
    temp->two = second;
    temp->weight = w;

    first->edges.push_back(temp);
    second->edges.push_back(temp);

    return temp;
}

// this prints out the information about an edge in an easy to read format
void printEdge(Edge* e) {
    cout << "Edge: " << e->one->name << " " << e->two->name << endl;
}