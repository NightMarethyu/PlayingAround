# The alphabet in a list, so I can use it as reference
ALPHABET = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z"]


def main():
    # Read the input from the console
    encodingString = input()
    key = int(input())
    # declare and initialize the variable that will hold the final message
    output = ""
    # Loop through the characters in the string
    for char in encodingString:
        # I don't want to encode the spaces, so I basically just skip over them
        if char == " ":
            output += char
            continue
        # Add the character from the alphabet shifted based on the included key
        output += ALPHABET[(ALPHABET.index(char) - key) % len(ALPHABET)]
    # Display the new message to the user
    print(output)


# This makes the code more modular, I can import this into other apps with fewer headaches using this syntax
if __name__ == '__main__':
    main()
