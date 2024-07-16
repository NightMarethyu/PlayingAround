// This is for the Foundational C# course. These are my notes for Part 3 of the course.

// Module 1: Evaluate Boolean expressions
Console.WriteLine("Module 1: Evaluate Boolean expressions\n");

Console.WriteLine("a" == "a");
Console.WriteLine("a" == "A");
Console.WriteLine(1 == 2);

string myValue = "a";
Console.WriteLine(myValue == "a");
Console.WriteLine();

string value1 = " a";
string value2 = "A ";
Console.WriteLine(value1.Trim().ToLower() == value2.Trim().ToLower());
Console.WriteLine();

string pangram = "The quick brown fox jumps over the lazy dog.";
Console.WriteLine(!pangram.Contains("fox"));
Console.WriteLine(!pangram.Contains("cow"));
Console.WriteLine();

int saleAmount = 0;
Console.Write("Enter a number: ");
string input = Console.ReadLine() ?? "0";
int.TryParse(input, out saleAmount);
int discount = saleAmount > 1000 ? 100 : 50;
Console.WriteLine($"Discount: {discount}");
Console.WriteLine();

// programming challenge: Display the results of a coin flip
Random random = new Random();
Console.WriteLine(random.Next(0, 2) == 0 ? "Heads" : "Tails");
Console.WriteLine();

// Programming challenge 2: Permission level
string permission = "Admin|Manager";
int level = 55;

if (permission.Contains("Admin"))
{
  Console.WriteLine(level > 55 ? "Welcome, Super Admin user." : "Welcome, Admin user.");
}
else if (permission.Contains("Manager") && level > 20)
{
  Console.WriteLine("Contact an Admin for access.");
}
else
{
  Console.WriteLine("You do not have sufficient privileges.");
}

//Module 2 Control Variable Scope
Console.WriteLine("\nModule 2: Control Variable Scope\n");
bool flag = true;
if (flag)
{
  int value = 10;
  Console.WriteLine($"Inside the code block: {value}");
}

flag = true;
if (flag) Console.WriteLine(flag);

string name = "steve";

if (name == "bob")
  Console.WriteLine("Found Bob");
else if (name == "steve")
  Console.WriteLine("Found Steve");
else
  Console.WriteLine("Found Chuck");

Console.WriteLine();

// Programming challenge: update problematic code
int[] numbers = { 4, 8, 15, 16, 23, 42 };
int total = 0;
bool found = false;

foreach (int number in numbers)
{
  total += number;

  if (number == 42)
    found = true;
}

if (found)
  Console.WriteLine("Set contains 42");

Console.WriteLine($"Total: {total}");

// Module 3: switch-case control flow
Console.WriteLine("\nModule 3: switch-case control flow\n");

Console.Write("Enter Employee Level: ");
string employeeLevelStr = Console.ReadLine();
employeeLevelStr = string.IsNullOrWhiteSpace(employeeLevelStr) ? "200" : employeeLevelStr;
int employeeLevel = 0;
int.TryParse(employeeLevelStr, out employeeLevel);

Console.Write("Enter Employee Name: ");
string employeeName = Console.ReadLine();
employeeName = string.IsNullOrWhiteSpace(employeeName) ? "John Smith" : employeeName;

string title = "";

switch (employeeLevel)
{
  case 100:
    title = "Junior Associate";
    break;
  case 200:
    title = "Senior Associate";
    break;
  case 300:
    title = "Manager";
    break;
  case 400:
    title = "Senior Manager";
    break;
  default:
    title = "Associate";
    break;
}

Console.WriteLine($"{employeeName}, {title}");

// Programming Challenge: refactor using switch-case
Console.WriteLine();

// SKU = Stock Keeping Unit. 
// SKU value format: <product #>-<2-letter color code>-<size code>
string sku = "01-MN-L";

string[] product = sku.Split('-');

string type = "";
string color = "";
string size = "";

switch (product[0])
{
  case "01":
    type = "Sweat shirt";
    break;
  case "02":
    type = "T-Shirt";
    break;
  case "03":
    type = "Sweat pants";
    break;
  default:
    type = "Other";
    break;

}

switch (product[1])
{
  case "BL":
    color = "Black";
    break;
  case "MN":
    color = "Maroon";
    break;
  default:
    color = "White";
    break;
}

switch (product[2])
{
  case "S":
    size = "Small";
    break;
  case "M":
    size = "Medium";
    break;
  case "L":
    size = "Large";
    break;
  default:
    size = "One Size Fits All";
    break;
}

Console.WriteLine($"Product: {size} {color} {type}");

// Module 4: Iterate using for loops
Console.WriteLine("\nModule 4: Iterate using for loops\n");

for (int i = 1; i <= 100; i++)
{
  string output = "";
  if (i % 3 == 0)
    output += "Fizz";
  if (i % 5 == 0)
    output += "Buzz";
  if (string.IsNullOrEmpty(output))
    Console.WriteLine(i);

  else
    Console.WriteLine($"{i} - {output}");
}

// Module 5: Iterate using while and do-while loops
Console.WriteLine("\nModule 5: Iterate using while and do-while loops\n");

random = new Random();
int current = 0;

do
{
  current = random.Next(1, 11);
  Console.WriteLine(current);
} while (current != 7);

Console.WriteLine();

while (current >= 3)
{
  Console.WriteLine(current);
  current = random.Next(1, 11);
}
Console.WriteLine($"Last Number: {current}\n");

// Code Challenge: implement game rules using do-while or while loop
int heroHealth = 10;
int monsterHealth = 10;
do
{
  int heroAttack = random.Next(1, 11);
  monsterHealth -= heroAttack;
  Console.WriteLine($"Hero attacks monster for {heroAttack} damage. Monster health: {monsterHealth}");
  if (monsterHealth <= 0)
  {
    Console.WriteLine("Hero wins!");
    break;
  }
  int monsterAttack = random.Next(1, 11);
  heroHealth -= monsterAttack;
  Console.WriteLine($"Monster attacks hero for {monsterAttack} damage. Hero health: {heroHealth}");
  if (heroHealth <= 0)
  {
    Console.WriteLine("Monster wins!");
    break;
  }
} while (true);

// Practice Choosing the Correct Loop
Console.WriteLine();
string? userInput;
bool valid = true;
int userValue = 0;
do
{
  Console.WriteLine("Enter a number between 5 and 10");
  userInput = Console.ReadLine();
  if (int.TryParse(userInput, out userValue))
  {
    if (userValue >= 5 && userValue <= 10)
    {
      valid = false;
    }
  }
} while (valid);
Console.WriteLine($"Value: {userValue} accepted.\n");

string[] roles = ["administrator", "manager", "user"];
bool validRole = true;
string role = "";

Console.WriteLine("Enter your role (Administrator, Manager, or User): ");
do
{
  role = Console.ReadLine().Trim();
  if (roles.Contains(role.ToLower()))
  {
    validRole = false;
  }
  else
  {
    Console.WriteLine($"The role name, \"{role}\", is not valid. Please enter your role (Administrator, Manager, or User): ");
  }
} while (validRole);

Console.WriteLine($"Role: {role} accepted.\n");

string[] myStrings = new string[2] { "I like pizza. I like roast chicken. I like salad", "I like all three of the menu choices" };
int stringsCount = myStrings.Length;

string myString = "";
int periodLocation = 0;

for (int i = 0; i < stringsCount; i++)
{
  myString = myStrings[i];
  periodLocation = myString.IndexOf(".");

  string mySentence;

  // extract sentences from each string and display them one at a time
  while (periodLocation != -1)
  {

    // first sentence is the string value to the left of the period location
    mySentence = myString.Remove(periodLocation);

    // the remainder of myString is the string value to the right of the location
    myString = myString.Substring(periodLocation + 1);

    // remove any leading white-space from myString
    myString = myString.TrimStart();

    // update the comma location and increment the counter
    periodLocation = myString.IndexOf(".");

    Console.WriteLine(mySentence);
  }

  mySentence = myString.Trim();
  Console.WriteLine(mySentence);
}