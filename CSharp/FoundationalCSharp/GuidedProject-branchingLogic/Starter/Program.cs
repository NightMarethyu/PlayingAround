// the ourAnimals array will store the following: 
string animalSpecies = "";
string animalID = "";
string animalAge = "";
string animalPhysicalDescription = "";
string animalPersonalityDescription = "";
string animalNickname = "";

// variables that support data entry
int maxPets = 8;
string? readResult;
string menuSelection = "";

// array used to store runtime data, there is no persisted data
string[,] ourAnimals = new string[maxPets, 6];

// TODO: Convert the if-elseif-else construct to a switch statement

// create some initial ourAnimals array entries
for (int i = 0; i < maxPets; i++)
{
  switch (i)
  {
    case 0:
      animalSpecies = "dog";
      animalID = "d1";
      animalAge = "2";
      animalPhysicalDescription = "medium sized cream colored female golden retriever weighing about 65 pounds. housebroken.";
      animalPersonalityDescription = "loves to have her belly rubbed and likes to chase her tail. gives lots of kisses.";
      animalNickname = "lola";
      break;
    case 1:
      animalSpecies = "dog";
      animalID = "d2";
      animalAge = "9";
      animalPhysicalDescription = "large reddish-brown male golden retriever weighing about 85 pounds. housebroken.";
      animalPersonalityDescription = "loves to have his ears rubbed when he greets you at the door, or at any time! loves to lean-in and give doggy hugs.";
      animalNickname = "loki";
      break;
    case 2:
      animalSpecies = "cat";
      animalID = "c3";
      animalAge = "1";
      animalPhysicalDescription = "small white female weighing about 8 pounds. litter box trained.";
      animalPersonalityDescription = "friendly";
      animalNickname = "Puss";
      break;
    case 3:
      animalSpecies = "cat";
      animalID = "c4";
      animalAge = "?";
      animalPhysicalDescription = "";
      animalPersonalityDescription = "";
      animalNickname = "";
      break;
    default:
      animalSpecies = "";
      animalID = "";
      animalAge = "";
      animalPhysicalDescription = "";
      animalPersonalityDescription = "";
      animalNickname = "";
      break;
  }
  ourAnimals[i, 0] = "ID #: " + animalID;
  ourAnimals[i, 1] = "Species: " + animalSpecies;
  ourAnimals[i, 2] = "Age: " + animalAge;
  ourAnimals[i, 3] = "Nickname: " + animalNickname;
  ourAnimals[i, 4] = "Physical description: " + animalPhysicalDescription;
  ourAnimals[i, 5] = "Personality: " + animalPersonalityDescription;
}

do
{
  // display the top-level menu options

  Console.Clear();

  Console.WriteLine("Welcome to the Contoso PetFriends app. Your main menu options are:");
  Console.WriteLine(" 1. List all of our current pet information");
  Console.WriteLine(" 2. Add a new animal friend to the ourAnimals array");
  Console.WriteLine(" 3. Ensure animal ages and physical descriptions are complete");
  Console.WriteLine(" 4. Ensure animal nicknames and personality descriptions are complete");
  Console.WriteLine(" 5. Edit an animal’s age");
  Console.WriteLine(" 6. Edit an animal’s personality description");
  Console.WriteLine(" 7. Display all cats with a specified characteristic");
  Console.WriteLine(" 8. Display all dogs with a specified characteristic");
  Console.WriteLine();
  Console.WriteLine("Enter your selection number (or type Exit to exit the program)");

  readResult = Console.ReadLine();
  if (readResult != null)
  {
    menuSelection = readResult.ToLower();
  }

  // Console.WriteLine($"You selected menu option {menuSelection}.");
  // Console.WriteLine("Press the Enter key to continue");

  // // pause code execution
  // readResult = Console.ReadLine();

  switch (menuSelection)
  {
    case "1":
      // List all of our current pet information
      for (int i = 0; i < maxPets; i++)
      {
        if (ourAnimals[i, 0] != "ID #: ")
        {
          Console.WriteLine();
          for (int j = 0; j < 6; j++)
          {
            Console.WriteLine(ourAnimals[i, j]);
          }
        }
      }
      Console.WriteLine("\n\rPress the Enter key to continue");
      readResult = Console.ReadLine();
      break;
    case "2":
      // Add a new animal friend to the ourAnimals array
      string anotherPet = "y";
      int petCount = 0;
      for (int i = 0; i < maxPets; i++)
      {
        if (ourAnimals[i, 0] == "ID #: ")
        {
          petCount += i;
        }
      }
      if (petCount < maxPets)
      {
        Console.WriteLine($"We currently have {petCount} pets that need homes. We can manage {(maxPets - petCount)} more.");
      }
      while (anotherPet == "y" && petCount < maxPets)
      {
        bool validEntry = false;

        // get species - string animalSpecies is required
        do
        {
          Console.WriteLine("\n\rEnter the species of the animal (dog or cat): ");
          readResult = Console.ReadLine();
          if (readResult != null)
          {
            animalSpecies = readResult.ToLower();
            if (animalSpecies == "dog" || animalSpecies == "cat")
            {
              validEntry = true;
            }
            else
            {
              Console.WriteLine("Invalid entry. Please enter dog or cat.");
            }
          }
        } while (!validEntry);

        animalID = animalSpecies.Substring(0, 1) + (petCount + 1).ToString();

        do
        {
          int petAge;
          Console.WriteLine("Enter the age of the animal: ");
          readResult = Console.ReadLine();
          if (readResult != null)
          {
            animalAge = readResult;
            if (animalAge != "?")
            {
              validEntry = int.TryParse(animalAge, out petAge);
            }
            else
            {
              validEntry = true;

            }
          }
        } while (!validEntry);

        do
        {
          Console.WriteLine("Enter the physical description of the animal: ");
          readResult = Console.ReadLine();
          if (readResult != null)
          {
            animalPhysicalDescription = readResult;
            if (animalPhysicalDescription == "")
            {
              animalPhysicalDescription = "tbd";
            }
          }
        } while (animalPhysicalDescription == "");

        do
        {
          Console.WriteLine("Enter the personality description of the animal: ");
          readResult = Console.ReadLine();
          if (readResult != null)
          {
            animalPersonalityDescription = readResult;
            if (animalPersonalityDescription == "")
            {
              animalPersonalityDescription = "tbd";
            }
          }
        } while (animalPersonalityDescription == "");

        do
        {
          Console.WriteLine("Enter the nickname of the animal: ");
          readResult = Console.ReadLine();
          if (readResult != null)
          {
            animalNickname = readResult;
            if (animalNickname == "")
            {
              animalNickname = "tbd";
            }
          }
        } while (animalNickname == "");

        ourAnimals[petCount, 0] = "ID #: " + animalID;
        ourAnimals[petCount, 1] = "Species: " + animalSpecies;
        ourAnimals[petCount, 2] = "Age: " + animalAge;
        ourAnimals[petCount, 3] = "Nickname: " + animalNickname;
        ourAnimals[petCount, 4] = "Physical description: " + animalPhysicalDescription;
        ourAnimals[petCount, 5] = "Personality: " + animalPersonalityDescription;

        petCount++;

        if (petCount < maxPets)
        {
          Console.WriteLine("Do you want to add another pet? (y/n)");
          do
          {
            readResult = Console.ReadLine();
            if (readResult != null)
            {
              anotherPet = readResult.ToLower();
            }
          } while (anotherPet != "y" && anotherPet != "n");
        }
      }

      if (petCount >= maxPets)
      {
        Console.WriteLine("We have reached our maximum capacity for pets. Please come back later.");
        Console.WriteLine("Press the Enter key to continue");
        readResult = Console.ReadLine();
      }
      break;
    case "3":
      // Ensure animal ages and physical descriptions are complete
      for (int i = 0; i < maxPets; i++)
      {
        bool updateRequired = false;
        string currentID = ourAnimals[i, 0].Replace("ID #: ", "");
        if (currentID == "") continue; // Skip if ID is default value

        // Check for missing or incomplete data
        if (ourAnimals[i, 2] == "Age: ?" || ourAnimals[i, 2] == "Age: " || ourAnimals[i, 4] == "Physical description: ")
        {
          Console.WriteLine($"\nIncomplete data for Pet ID {currentID}. Please update the following:");
          updateRequired = true;
        }

        // Validate and update animalAge
        if (ourAnimals[i, 2] == "Age: ?" || ourAnimals[i, 2] == "Age: ")
        {
          string newAge;
          do
          {
            Console.WriteLine($"Current Age for {currentID}: {ourAnimals[i, 2].Replace("Age: ", "")}");
            Console.Write("Enter a valid age: ");
            newAge = Console.ReadLine();
          } while (!int.TryParse(newAge, out _)); // Repeat until a valid number is entered
          ourAnimals[i, 2] = "Age: " + newAge;
        }

        // Validate and update animalPhysicalDescription
        if (ourAnimals[i, 4] == "Physical description: ")
        {
          string newDescription;
          do
          {
            Console.WriteLine($"Current Physical Description for {currentID}: {ourAnimals[i, 4].Replace("Physical description: ", "")}");
            Console.Write("Enter a valid physical description: ");
            newDescription = Console.ReadLine();
          } while (string.IsNullOrWhiteSpace(newDescription)); // Repeat until a non-empty string is entered
          ourAnimals[i, 4] = "Physical description: " + newDescription;
        }

        if (updateRequired)
        {
          Console.WriteLine($"Data for Pet ID {currentID} has been updated.");
        }
      }
      Console.WriteLine("\nAll animal ages and physical descriptions are now complete.");
      Console.WriteLine("Press the Enter key to continue");
      readResult = Console.ReadLine();
      break;
    case "4":
      // Ensure animal nicknames and personality descriptions are complete
      for (int i = 0; i < maxPets; i++)
      {
        bool needsUpdate = false;
        string id = ourAnimals[i, 0].Replace("ID #: ", "");
        if (id == "") continue; // Skip if ID is the default value
        if (ourAnimals[i, 3].Replace("Nickname: ", "").Trim() == "" || ourAnimals[i, 5].Replace("Personality: ", "").Trim() == "")
        {
          needsUpdate = true;
          Console.WriteLine($"Animal ID {id} needs an update.");
        }
        if (needsUpdate)
        {
          // Update Nickname
          Console.WriteLine($"Enter a new nickname for animal ID {id}:");
          string newNickname = Console.ReadLine();
          while (string.IsNullOrWhiteSpace(newNickname))
          {
            Console.WriteLine("Invalid nickname. Please enter a valid string.");
            newNickname = Console.ReadLine();
          }
          ourAnimals[i, 3] = "Nickname: " + newNickname;

          // Update Personality Description
          Console.WriteLine($"Enter a new personality description for animal ID {id}:");
          string newPersonality = Console.ReadLine();
          while (string.IsNullOrWhiteSpace(newPersonality))
          {
            Console.WriteLine("Invalid personality description. Please enter a valid string.");
            newPersonality = Console.ReadLine();
          }
          ourAnimals[i, 5] = "Personality: " + newPersonality;
        }
      }
      Console.WriteLine("All animals have been updated with nicknames and personality descriptions.");
      Console.WriteLine("Press the Enter key to continue");
      readResult = Console.ReadLine();
      break;
    case "5":
      // Edit an animal’s age
      Console.WriteLine("Press the Enter key to continue");
      readResult = Console.ReadLine();
      break;
    case "6":
      // Edit an animal’s personality description
      Console.WriteLine("Press the Enter key to continue");
      readResult = Console.ReadLine();
      break;
    case "7":
      // Display all cats with a specified characteristic
      Console.WriteLine("Press the Enter key to continue");
      readResult = Console.ReadLine();
      break;
    case "8":
      // Display all dogs with a specified characteristic
      Console.WriteLine("Press the Enter key to continue");
      readResult = Console.ReadLine();
      break;
  }


} while (menuSelection != "exit");