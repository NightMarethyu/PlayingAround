# The alphabet in a list, so I can use it as reference
ALPHABET = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z"]


def main():
    # Read the input from the console
    encodingString = input()
    # This line is to be used for reference with the other lines
    print(f"ciphertext: %s" % encodingString)
    # There are only as many keys as there are letters in the alphabet so this loop takes care of that
    for i in range(len(ALPHABET)):
        # Call the function that decodes things and print out the attempt
        attempt = decode(encodingString, i)
        print(f"key: %d decodes to: %s" % (i, attempt))


# This function will decode a message given a key and the message
def decode(mes, key):
    # a variable to store the message as the loop progresses
    output = ""
    # loop through the message and decode
    for char in mes:
        # Spaces aren't coded so they will stay the same
        if char == " ":
            output += char
            continue
        # Add to the output the character that corresponds to the character at the given key
        output += ALPHABET[(ALPHABET.index(char) - key) % len(ALPHABET)]
    # the output has the decoded message at the given key
    return output


# This makes the code more modular, I can import this into other apps with fewer headaches using this syntax
if __name__ == '__main__':
    main()
