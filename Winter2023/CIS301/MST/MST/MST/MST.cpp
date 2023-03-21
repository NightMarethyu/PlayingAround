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

    string names;
    getline(ifs, names);
    int later = 0;

    for (char let : names) {
        nodes[let] = newNode(let);
        later++;
    }

    char start = names[0];

    getline(ifs, names);
    int c = stoi(names);

    for (int i = 0; i < c; i++) {
        getline(ifs, names);
        auto edgeInfo = split(names, ' ');
        int w = stoi(edgeInfo[2]);
        newEdge(nodes[edgeInfo[0][0]], nodes[edgeInfo[1][0]], w);
    }

    DraperMST(nodes[start]);

}

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

void DraperMST(Node* start) {
    vector<Edge*> mst_edges;
    int totalWeight = 0;
    for (auto e : start->edges) {
        bucket.push_back(e);
    }
    Edge* e = getBestEdge();
    while (e) {
        e->one->visited = true;
        for (auto t : e->one->edges) {
            bucket.push_back(t);
        }
        e->two->visited = true;
        for (auto t : e->two->edges) {
            bucket.push_back(t);
        }
        totalWeight += e->weight;
        mst_edges.push_back(e);
        e = getBestEdge();
    }
    cout << "Total Weight: " << totalWeight << endl << "Edges are:" << endl;
    for (auto e : mst_edges) {
        printEdge(e);
    }
}

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

Node* newNode(char n) {
    Node* temp = new Node;
    temp->name = n;
    temp->visited = false;
    return temp;
}

Edge* newEdge(Node* first, Node* second, int w) {
    Edge* temp = new Edge;
    temp->one = first;
    temp->two = second;
    temp->weight = w;

    first->edges.push_back(temp);
    second->edges.push_back(temp);

    return temp;
}

void printEdge(Edge* e) {
    cout << "Edge: " << e->one->name << " " << e->two->name << endl;
}