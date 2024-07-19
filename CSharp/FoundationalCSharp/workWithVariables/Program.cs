// Get Started with C# part 4 - Work with Variable Data
// Choose the correct data type in your C# Code
/* Console.WriteLine("C# part 4 - Work with Variable Data");
Console.WriteLine("\nChoose the correct data type in your C# Code\n");

Console.WriteLine("Signed integral types:");

Console.WriteLine($"sbyte  : {sbyte.MinValue} to {sbyte.MaxValue}");
Console.WriteLine($"short  : {short.MinValue} to {short.MaxValue}");
Console.WriteLine($"int    : {int.MinValue} to {int.MaxValue}");
Console.WriteLine($"long   : {long.MinValue} to {long.MaxValue}");

Console.WriteLine("\nUnsigned integral types:");

Console.WriteLine($"byte   : {byte.MinValue} to {byte.MaxValue}");
Console.WriteLine($"ushort : {ushort.MinValue} to {ushort.MaxValue}");
Console.WriteLine($"uint   : {uint.MinValue} to {uint.MaxValue}");
Console.WriteLine($"ulong  : {ulong.MinValue} to {ulong.MaxValue}"); 

Console.WriteLine("Floating point types:");
Console.WriteLine($"float  : {float.MinValue} to {float.MaxValue} (with ~6-9 digits of precision)");
Console.WriteLine($"double : {double.MinValue} to {double.MaxValue} (with ~15-17 digits of precision)");
Console.WriteLine($"decimal: {decimal.MinValue} to {decimal.MaxValue} (with 28-29 digits of precision)"); */

// Convert Data types in C#
/*Console.WriteLine("Convert Data types in C#\n");

string[] values = { "12.3", "45", "ABC", "11", "DEF" };
string output = "";
decimal total = 0;

foreach (var value in values)
{
  decimal number = 0;
  if (decimal.TryParse(value, out number))
  {
    total += number;
  }
  else
  {
    output += value;
  }
}

Console.WriteLine($"Message:\t{output}");
Console.WriteLine($"Total:\t\t{total}");*/

/*int value1 = 11;
decimal value2 = 6.2m;
float value3 = 4.3f;

// Your code here to set result1
// Hint: You need to round the result to nearest integer (don't just truncate)
int result1 = value1 / Convert.ToInt32(value2);
Console.WriteLine($"Divide value1 by value2, display the result as an int: {result1}");

decimal result2 = value2 / (decimal)value3;
Console.WriteLine($"Divide value2 by value3, display the result as a decimal: {result2}");

float result3 = value3 / value1;
Console.WriteLine($"Divide value3 by value1, display the result as a float: {result3}");*/

/*Console.WriteLine("Perform Operations on Arrays Using Helper Methods\n");
string[] pallets = { "B14", "A11", "B12", "A13" };

Console.WriteLine("Sorted...");
Array.Sort(pallets);
foreach (var pallet in pallets)
{
  Console.WriteLine($"-- {pallet}");
}

Console.WriteLine("\nReversed...");
Array.Reverse(pallets);
foreach (var pallet in pallets)
{
  Console.WriteLine($"-- {pallet}");
}

string[] pallets = { "B14", "A11", "B12", "A13" };
Console.WriteLine("");

Array.Clear(pallets, 0, 2);
Console.WriteLine($"Clearing 2 ... count: {pallets.Length}");
foreach (var pallet in pallets)
{
  Console.WriteLine($"-- {pallet}");
}

Console.WriteLine("");
Array.Resize(ref pallets, 6);
Console.WriteLine($"Resizing 6 ... count: {pallets.Length}");

pallets[4] = "C01";
pallets[5] = "C02";

foreach (var pallet in pallets)
{
  Console.WriteLine($"-- {pallet}");
}

Console.WriteLine("");
Array.Resize(ref pallets, 3);
Console.WriteLine($"Resizing 3 ... count: {pallets.Length}");

foreach (var pallet in pallets)
{
  Console.WriteLine($"-- {pallet}");
}*/

/*string pangram = "The quick brown fox jumps over the lazy dog";
string[] words = pangram.Split(' ');
for (int i = 0; i < words.Length; i++)
{
  char[] letters = words[i].ToCharArray();
  Array.Reverse(letters);
  words[i] = new string(letters);
}
string reversed = string.Join(" ", words);
Console.WriteLine(reversed);

string orderStream = "B123,C234,A345,C15,B177,G3003,C235,B179";
string[] orders = orderStream.Split(',');
Array.Sort(orders);
foreach (var order in orders)
{
  if (order.Length != 4)
  {
    Console.WriteLine($"{order}\t- Error");
  }
  else
  {
    Console.WriteLine(order);
  }
}*/

Console.WriteLine("Format Alphanumeric Data for Presentation\n");

/* var first = "Hello";
var second = "There";
var third = "General Kenobi";
string result = string.Format("{0} {1}\n{2}", first, second, third);
Console.WriteLine(result);
Console.WriteLine("{0} {0} {0}\n", first, second, third);
Console.WriteLine($"{first} {second}\n{third}");

Console.WriteLine("\n");
decimal price = 123.45m;
int discount = 50;
Console.WriteLine($"Price: {price:C} (Save {discount:C})\n");

decimal measurement = 123456.78912m;
Console.WriteLine($"Measurement: {measurement:N}\n");

Console.WriteLine("Exercise - Explore string interpolation\n");
int invoiceNumber = 1201;
decimal productShares = 25.4568m;
decimal subtotal = 2750.00m;
decimal taxPercentage = .15825m;
decimal total = 3185.19m;

Console.WriteLine($"Invoice Number:\t\t\t{invoiceNumber}");
Console.WriteLine($"\tShares:\t\t\t{productShares:N3} Product");
Console.WriteLine($"\t\tSub Total:\t{subtotal:C}");
Console.WriteLine($"\t\t\tTax:\t{taxPercentage:P2}");
Console.WriteLine($"\t\tTotal:\t\t{total:C}"); */

/* Console.WriteLine("Exercise - Form Letter Formatting\n");

string customerName = "Ms. Barros";

string currentProduct = "Magic Yield";
int currentShares = 2975000;
decimal currentReturn = 0.1275m;
decimal currentProfit = 55000000.0m;

string newProduct = "Glorious Future";
decimal newReturn = 0.13125m;
decimal newProfit = 63000000.0m;

string greeting = "Dear " + customerName + ",\n";
string firstLine = $"As a customer of {currentProduct} offering we are excited to tell you about a new financial product that would dramatically increase your return.\n";

Console.WriteLine(greeting + firstLine);

Console.WriteLine($"Currently, you own {currentShares:N2} at a return of {currentReturn:P2}.\n");
Console.WriteLine($"Our new product, {newProduct} offers a return of {newReturn:P2}. Given your current volume, your potential profit would be {newProfit:C}.\n");

Console.WriteLine("Here's a quick comparison:\n");

string comparisonMessage = "";

comparisonMessage += currentProduct.PadRight(20) + $"{currentReturn:P2}  {currentProfit:C}\n";
comparisonMessage += newProduct.PadRight(20) + $"{newReturn:P2}  {newProfit:C}\n";

Console.WriteLine(comparisonMessage); */

Console.WriteLine("Modify Strings using built-in data type methods\n");

// string message = "Find what is (inside the parentheses)";

// int openingPosition = message.IndexOf('(');
// int closingPosition = message.IndexOf(')');

// // Console.WriteLine(openingPosition);
// // Console.WriteLine(closingPosition);

// int length = closingPosition - openingPosition;
// Console.WriteLine(message.Substring(openingPosition, length));

// string message = "What is the value <span>between the tags</span>?";

// const string openSpan = "<span>";
// const string closeSpan = "</span>";

// int openingPosition = message.IndexOf(openSpan);
// int closingPosition = message.IndexOf(closeSpan);

// openingPosition += openSpan.Length;
// int length = closingPosition - openingPosition;
// Console.WriteLine(message.Substring(openingPosition, length));

/* string message = "Help (find) the {opening symbols}";
Console.WriteLine($"Searching THIS Message: {message}");
char[] openSymbols = { '[', '{', '(' };
int startPosition = 5;
int openingPosition = message.IndexOfAny(openSymbols);
Console.WriteLine($"Found WITHOUT using startPosition: {message.Substring(openingPosition)}");

openingPosition = message.IndexOfAny(openSymbols, startPosition);
Console.WriteLine($"Found WITH using startPosition {startPosition}:  {message.Substring(openingPosition)}"); */

/*string data = "12345John Smith          5000  3  ";
string updatedData = data.Remove(5, 20);
Console.WriteLine(updatedData);

string message = "This--is--ex-amp-le--da-ta";
message = message.Replace("--", " ");
message = message.Replace("-", "");
Console.WriteLine(message);*/

const string input = "<div><h2>Widgets &trade;</h2><span>5000</span></div>";

string quantity = "";
string output = "";

const string openSpan = "<span>";
const string closeSpan = "</span>";
int openSpanPosition = input.IndexOf(openSpan);
int closeSpanPosition = input.IndexOf(closeSpan);
string spanContent = input.Substring(openSpanPosition + openSpan.Length, closeSpanPosition - openSpanPosition - openSpan.Length);

quantity = $"Quantity: {spanContent}";
output = "Output: " + input.Replace("&trade;", "&reg;");
output = output.Replace("<div>", "");
output = output.Replace("</div>", "");

Console.WriteLine(quantity);
Console.WriteLine(output);