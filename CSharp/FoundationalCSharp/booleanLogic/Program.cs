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