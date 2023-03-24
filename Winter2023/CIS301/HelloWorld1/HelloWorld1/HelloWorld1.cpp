#include <iostream>
#include <string>

int main() {
	// I'm using Unicode characters so I need to set the locale to accept Unicode
	setlocale(LC_ALL, "");

	// Here are the unique stanzas of the poem
	std::string firstStanza = "Une fourmi de dix-huit m�tres\nAvec un chapeau sur la t�te\,\n";
	std::string secondStanza = "Une fourmi tra�nant un char\nPlein de pingouins et de canards\n";
	std::string thirdStanza = "Une fourmi parlant fran�ais\nParlant latin et javanais\n";

	// Every stanza includes this at line so I will reuse it
	std::string stanzaEnd = "�a n'existe pas\, �a n'existe pas\n";

	// With everything set up, now time to print to the console
	std::cout << firstStanza << stanzaEnd << std::endl;
	std::cout << secondStanza << stanzaEnd << std::endl;
	std::cout << thirdStanza << stanzaEnd << "Et pourquoi pas?" << std::endl;

}