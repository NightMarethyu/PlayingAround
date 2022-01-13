from sys import argv, exit

# This method will do some basic error checking, make sure the user
# added a command line argument and make sure the file exists
# it will then send the file to the checkStatement function
def main():
    if (len(argv) > 1):
        try:
            with open(argv[1]) as f:
                checkStatement(f)
        except:
            print("ERROR: File not Found")
            exit(1)
    else:
        print("ERROR: Please provide file as command line argument")
        exit(1)

# This function has a few different if statements each one will check for a different
# aspect that will make a line not a statement
def checkStatement(file):
    ns = " NOT A STATEMENT"
    pronouns = ["he", "she", "it", "they", "his", "her", "him", "them", "hers", "theirs", "their", "herself", "himself", "themselves", "itself", ""]
    interrogatives = ["who", "what", "when", "where", "why", "how"]
    for line in file:
        line = line.strip()
        lineArr = line.lower().split(" ")
        # check if the last character is a question mark
        if (line[-1] == "?"):
            print(line + ns)
            continue
        # Check if the line is only one word
        if (len(lineArr) == 1):
            print(line + ns)
            continue
        # check if the line contains pronouns
        if any(x in lineArr for x in pronouns):
            print(line + ns)
            continue
        # check if the line contains interrogatives
        if any(x in interrogatives for x in lineArr):
            print(line + ns)
            continue
        # We assume that if the line doesn't fail any of the tests it is a statement
        print(line + " STATEMENT")

if __name__ == "__main__":
    main()