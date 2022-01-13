from sys import argv, exit

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

def checkStatement(file):
    ns = " NOT A STATEMENT"
    pronouns = ["he", "she", "it", "they", "his", "her", "him", "them", "hers", "theirs", "their", "herself", "himself", "themselves", "itself", ""]
    interogatives = ["who", "what", "when", "where", "why", "how"]
    for line in file:
        line = line.strip()
        lineArr = line.lower().split(" ")
        if (line[-1] == "?"):
            print(line + ns)
            continue
        if (len(lineArr) == 1):
            print(line + ns)
            continue
        if any(x in lineArr for x in pronouns):
            print(line + ns)
            continue
        if any(x in interogatives for x in lineArr):
            print(line + ns)
            continue
        print(line + " STATEMENT")

if __name__ == "__main__":
    main()