using System;

// initialize variables - graded assignments 
int currentAssignments = 5;

Dictionary<string, int[]> studentScores = new Dictionary<string, int[]>();

studentScores["Sophia"] = new int[] { 90, 86, 87, 98, 100, 94, 90 };
studentScores["Andrew"] = new int[] { 92, 89, 81, 96, 90, 89 };
studentScores["Emma"] = new int[] { 90, 85, 87, 98, 68, 89, 89, 89 };
studentScores["Logan"] = new int[] { 90, 95, 87, 88, 96, 96 };
studentScores["Becky"] = new int[] { 92, 91, 90, 91, 92, 92, 92 };
studentScores["Chris"] = new int[] { 84, 86, 88, 90, 92, 94, 96, 98 };
studentScores["Eric"] = new int[] { 80, 90, 100, 80, 90, 100, 80, 90 };
studentScores["Gregor"] = new int[] { 91, 91, 91, 91, 91, 91, 91 };

Console.WriteLine("Student\t\tGrade\n");

foreach (var student in studentScores)
{
  decimal average = calculateGrades(student.Value);
  Console.WriteLine($"{student.Key}\t\t{average.ToString("#.#")}\t{getLetterGrade(average)}");
}

string getLetterGrade(decimal score)
{
  if (score >= 97)
    return "A+";
  else if (score >= 93)
    return "A";
  else if (score >= 90)
    return "A-";
  else if (score >= 87)
    return "B+";
  else if (score >= 83)
    return "B";
  else if (score >= 80)
    return "B-";
  else if (score >= 77)
    return "C+";
  else if (score >= 73)
    return "C";
  else if (score >= 70)
    return "C-";
  else if (score >= 67)
    return "D+";
  else if (score >= 63)
    return "D";
  else if (score >= 60)
    return "D-";
  else
    return "F";
}

decimal calculateGrades(int[] scores)
{
  int total = 0;
  int gradedAssignments = 0;
  foreach (int score in scores)
  {
    if (gradedAssignments < currentAssignments)
    {
      total += score;
      gradedAssignments++;
    }
    else
    {
      total += score / 10;
    }
  }
  return (decimal)total / currentAssignments;
}

Console.WriteLine("\n\rPress any key to exit.");
Console.ReadLine();