ALPHABET = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z"]


def main():
    encodingString = input()
    print(f"ciphertext: %s" % encodingString)
    for i in range(len(ALPHABET)):
        attempt = decode(encodingString, i)
        print(f"key: %d decodes to: %s" % (i, attempt))


def decode(mes, key):
    output = ""
    for char in mes:
        if char == " ":
            output += char
            continue
        output += ALPHABET[(ALPHABET.index(char) - key) % len(ALPHABET)]
    return output


if __name__ == '__main__':
    main()
