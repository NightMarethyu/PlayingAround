export const quiz = {
  title: 'Create Your Own Summer Vacation',
  questions: [
    {
      id: 1,
      chooseOne: true,
      title: "Companion",
      prompt: "Choose Your Travel Buddy",
      options: [
        {
          title: "Mascot",
          points: 2
        },
        {
          title: "Dog",
          points: 5
        },
        {
          title: "Death Cloud",
          points: -1
        }
      ]
    },
    {
      id: 2,
      chooseOne: true,
      title: "Destination",
      prompt: "Pick a Place to Visit",
      options: [
        {
          title: "The Beach",
          points: 5
        },
        {
          title: "Grandma's House",
          points: 1
        },
        {
          title: "Outer Universe",
          points: 2
        }
      ]
    },
    {
      id: 3,
      chooseOne: false,
      title: "Packing",
      prompt: "Choose as many as you like!",
      options: [
        {
          title: "Pet Snake",
          points: -1
        },
        {
          title: "Shorts",
          points: 3
        },
        {
          title: "Sword",
          points: -2
        },
        {
          title: "Raygun",
          points: -5
        },
        {
          title: "Toothbrush",
          points: 1
        },
        {
          title: "Suncream",
          points: 2
        },
        {
          title: "Snorkle",
          points: 2
        },
        {
          title: "DVD",
          points: -1
        }
      ]
    },
    {
      id: 4,
      chooseOne: true,
      title: "Travelling",
      prompt: "How's the journey?",
      options: [
        {
          title: "You watch a movie then have a long nap",
          points: 4
        },
        {
          title: "Your seat is too small and you get travel sick",
          points: -2
        }
      ]
    },
    {
      id: 5,
      chooseOne: false,
      choiceLimit: 2,
      title: "Activities",
      prompt: "You can choose two!",
      options: [
        {
          title: "Go Surfing",
          points: 5
        },
        {
          title: "Destroy Planets",
          points: -50
        },
        {
          title: "Go Sight-Seeing",
          points: 3
        },
        {
          title: "Play Scabble",
          points: -1
        }
      ]
    },
    {
      id: 6,
      chooseOne: true,
      title: "Final Night",
      prompt: "How will your vacation end?",
      options: [
        {
          title: "You finish the holiday with an all you can eat buffet",
          points: 4
        },
        {
          title: "You finish the holiday with food poisoning",
          points: -2
        }
      ]
    }
  ]
}

export const results = [
  {
    title: "Holiday Hero",
    text: "Dwayne Johnson just called to see if he could come with you next time",
    minValue: 20
  },
  {
    title: "Suitcase Slugger",
    text: "Nice Work! Your pictures got thousands of likes on the 'Gram",
    maxValue: 20,
    minValue: 0
  },
  {
    title: "Summer Bummer",
    text: "Was that the best you could do? Next time, just stay at home",
    maxValue: 0,
    minValue: -20
  },
  {
    title: "Astro-Naught",
    text: "You wrecked havoc across the univers, enjoy space jail",
    maxValue: -20
  }
]