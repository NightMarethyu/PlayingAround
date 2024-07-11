Random dice = new();
for (int i = 0; i < 20; i++)
{
  int roll = dice.Next(1, 21);
  Console.WriteLine(roll);
}