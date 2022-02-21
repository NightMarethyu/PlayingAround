from random import randint

def main():
    print("You may bid on up to 5 valuable paintings.")
    print("You start with $5000.")
    print("You will then try to sell them all for a profit.")
    
    # Game variables
    numPaintings = 5
    oBidLow = 150
    oBidHigh = 1150
    offCountL = 1
    offCountH = 6
    offerLow = 500
    offerHigh = 2500
    
    # setup variables
    inCash = 5000
    paintings = 0
    
    # user variables
    cash = inCash
    ownedPaintings = paintings
    bids = []
    
    # Time to buy paintings
    for i in range(numPaintings):
        print("You have: {0}".format(cash))
        print("You are bidding on painting {0}".format(i+1))
        bid = int(input("What will you bid? "))
        while (bid > cash):
            print("Sorry, you don't have the money for that, bid again")
            bid = int(input("New bid: "))
        oBid = randint(oBidLow, oBidHigh)
        if (bid >= oBid):
            print("You won the bid!")
            ownedPaintings += 1
            cash -= bid
            bids.append(bid)
        else:
            print("Sorry, your opponent bid {0}, you lost this one".format(oBid))

    # Time to sell the paintings, hopefullly for a profit
    for i in range(len(bids)):
        print("You may now sell painting {0}".format(i+1))
        offCount = randint(offCountL, offCountH)
        
        for j in range(offCount):
            offer = randint(offerLow, offerHigh)
            print("You are being offered {0} for this painting".format(offer))
            print("You originally paid {0}".format(bids[i]))
            accept = input("Do you accept (y/n): ").lower()
            if (accept == "y" or accept == "yes"):
                cash += offer
                break
            else:
                if((j + 1) < offCount):
                    continue
                else:
                    print("Sorry that was your last offer. You will have to keep that painting.")
    
    # Endgame, time to report how much the player made
    print("You started with ${0}. You finished with ${1}".format(inCash, cash))
    again = input("Play again? (y/n): ").lower()
    if(again == "y" or again == "yes"):
        main()

if __name__ == "__main__":
    main()