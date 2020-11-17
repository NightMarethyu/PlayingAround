from playsound import playsound
import time

def main():
    userMinutes = int(input("Timer Minutes: "))
    seconds = int(input("Timer Seconds: "))
    totalTime = (userMinutes * 60) + seconds
    start = time.time()
    elapsed = 1
    while elapsed < totalTime:
        elapsed = time.time() - start
        time.sleep(1)
    playsound('./magic-spell.mp3')

if __name__ == "__main__":
    main()