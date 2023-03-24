#include <iostream>
#include <string>

int main() {
	// I'm using Unicode characters so I need to set the locale to accept Unicode
	setlocale(LC_ALL, "");

	// Here are the unique stanzas of the poem
	std::string firstStanza = "Une fourmi de dix-huit mètres\nAvec un chapeau sur la tête\,\n";
	std::string secondStanza = "Une fourmi traînant un char\nPlein de pingouins et de canards\n";
	std::string thirdStanza = "Une fourmi parlant français\nParlant latin et javanais\n";

	// Every stanza includes this at line so I will reuse it
	std::string stanzaEnd = "Ça n'existe pas\, ça n'existe pas\n";

	// With everything set up, now time to print to the console
	std::cout << firstStanza << stanzaEnd << std::endl;
	std::cout << secondStanza << stanzaEnd << std::endl;
	std::cout << thirdStanza << stanzaEnd << "Et pourquoi pas?" << std::endl;

}