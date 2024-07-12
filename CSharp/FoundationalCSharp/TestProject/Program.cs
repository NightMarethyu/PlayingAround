
// My notes from Unit 4 of "Get started with C#, Part 2/Call methods from the .NET Class Library using C#" on Microsoft Learn
Console.WriteLine("Module Name: Call methods from the .NET Class Library using C#");
Random dice = new();
for (int i = 0; i < 20; i++)
{
  Console.Write($"{dice.Next(1, 21)}, ");
}
Console.WriteLine(dice.Next(1, 21));

Console.WriteLine($"First role: {dice.Next()}");
Console.WriteLine($"Second role: {dice.Next(101)}");
Console.WriteLine($"Third role: {dice.Next(50, 101)}");

int bigNumber = 2147483647;
Console.WriteLine($"Big number: {bigNumber}");
Console.WriteLine($"Bigger number: {bigNumber + 1}");

// My notes from Unit 5 of "Get started with C#, Part 2/Call methods from the .NET Class Library using C#" on Microsoft Learn
int firstValue = 500;
int secondValue = 600;
int largerValue = Math.Max(firstValue, secondValue);

int advantage = Math.Max(dice.Next(1, 21), dice.Next(1, 21));

Console.WriteLine($"Roll with advantage: {advantage}\n");

// Starting The module "Add decision logic to your code using `if`, `else`, and `else if` statements in C#"
Console.WriteLine("Starting Module: Add decision logic to your code using `if`, `else`, and `else if` statements in C#\n");

int roll1 = dice.Next(1, 7);
int roll2 = dice.Next(1, 7);
int roll3 = dice.Next(1, 7);

int total = roll1 + roll2 + roll3;

Console.WriteLine($"Dice roll: {roll1} + {roll2} + {roll3} = {total}");

if ((roll1 == roll2) || (roll2 == roll3) || (roll1 == roll3))
{
  if ((roll1 == roll2) && (roll2 == roll3))
  {
    Console.WriteLine("You rolled triples! +6 bonus to total!");
    total += 6;
  }
  else
  {
    Console.WriteLine("You rolled doubles! +2 bonus to total!");
    total += 2;
  }
}

if (total >= 16)
{
  Console.WriteLine("You win a new car!");
}
else if (total >= 10)
{
  Console.WriteLine("You win a new laptop!");
}
else if (total == 7)
{
  Console.WriteLine("You win a trip for two!");
}
else
{
  Console.WriteLine("You win a kitten!");
}
Console.WriteLine();

// `if`, `else`, and `else if` "challenge" assignment
Random random = new Random();
int daysUntilExpiration = random.Next(12);
int discountPercentage = 0;

if (daysUntilExpiration == 0)
{
  Console.WriteLine("Your subscription has expired.");
}
else if (daysUntilExpiration == 1)
{
  discountPercentage = 20;
  Console.WriteLine($"Your subscription expires within a day!");
}
else if (daysUntilExpiration <= 5)
{
  discountPercentage = 10;
  Console.WriteLine($"Your subscription expires within {daysUntilExpiration} days.");
}
else if (daysUntilExpiration <= 10)
{
  Console.WriteLine($"Your subscription will expire soon. Renew now!");
}

if (discountPercentage > 0)
{
  Console.WriteLine($"Renew now and save {discountPercentage}%.\n");
}

// Notes from the Arrays module from "Get started with C#, Part 2" on Microsoft Learn
Console.WriteLine("Starting Module: Arrays\n");

/* string[] fraudulentOrderIDs = new string[3];

fraudulentOrderIDs[0] = "A123";
fraudulentOrderIDs[1] = "B456";
fraudulentOrderIDs[2] = "C789"; */
// fraudulentOrderIDs[3] = "D000"; // This will throw an IndexOutOfRangeException

string[] fraudulentOrderIDs = { "A123", "B456", "C789" };

Console.WriteLine($"First fraudulent order ID: {fraudulentOrderIDs[0]}");
Console.WriteLine($"Second fraudulent order ID: {fraudulentOrderIDs[1]}");
Console.WriteLine($"Third fraudulent order ID: {fraudulentOrderIDs[2]}\n");

fraudulentOrderIDs[0] = "F000";
Console.WriteLine($"Reassigning the first fraudulent order ID: {fraudulentOrderIDs[0]}\n");
Console.WriteLine($"The fraudulent order IDs array has {fraudulentOrderIDs.Length} elements.\n");

int[] inventory = { 200, 450, 700, 175, 250 };
int sum = 0;
int bin = 0;
foreach (int items in inventory)
{
  sum += items;
  bin++;
  Console.WriteLine($"Bin {bin} = {items} items (Running total: {sum})");
}
Console.WriteLine($"We have {sum} items in inventory.");

string[] orderNumbers = { "B123", "C234", "A345", "C15", "B177", "G3003", "C235", "B179" };
Console.WriteLine("Orders that start with 'B':");
foreach (string order in orderNumbers)
{
  if (order.StartsWith("B"))
  {
    Console.WriteLine(order);
  }
}
Console.WriteLine("\n");

// Notes from Readable Code module from "Get started with C#, Part 2" on Microsoft Learn

/*
  This code reverses the message, counts the number of times 
  the character 'o' appears, and then prints the results
  to the console window.
 */

string originalMessage = "The quick brown fox jumps over the lazy dog.";

char[] message = originalMessage.ToCharArray();
Array.Reverse(message);

int letterCount = 0;

foreach (char letter in message)
{
  if (letter == 'o')
  {
    letterCount++;
  }
}

string newMessage = new String(message);

Console.WriteLine(newMessage);
Console.WriteLine($"'o' appears {letterCount} times.");