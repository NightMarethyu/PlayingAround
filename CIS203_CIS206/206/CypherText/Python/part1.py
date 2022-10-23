ALPHABET = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z"]


def main():
    encodingString = input()
    key = int(input())
    output = ""
    for char in encodingString:
        if char == " ":
            output += char
            continue
        output += ALPHABET[(ALPHABET.index(char) + key) % len(ALPHABET)]
    print(output)


if __name__ == '__main__':
    main()
