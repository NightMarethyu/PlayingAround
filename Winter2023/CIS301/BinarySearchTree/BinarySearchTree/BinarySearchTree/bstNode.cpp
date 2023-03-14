#include "bstNode.h"
#include <cstddef>

bstNode::bstNode() {
	head = NULL;
	left = NULL;
	right = NULL;
	value = 0;
}

bstNode::bstNode(int val) {
	bstNode();
	value = val;
}