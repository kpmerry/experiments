import random
import time


def simple_random():
    print(
        "Simple Random Number Generator will now generate a random number based on a given range!"
    )
    low = int(input("Choose the lowest number: "))
    high = int(input("Choose the highest number: "))
    return print(f"Your number: {random.randint(low, high)}")


def random_multiple():
    print("Random Multiple Generator will generate a random multiple for you!")
    low = int(input("Choose the lowest number you want: "))
    high = int(input("Choose the highest number you want: "))
    mult = int(input("Choose the multiple you want!"))
    if low % mult != 0:
        low = (low // mult) + mult
    if high % mult == 0:
        high += 1
    return print(f"Your random multiple is {random.randrange(low, high, mult)}!")


def random_choice():
    print("Random choice will pick a random element from a list you enter!")
    choices = input("Add the list of elements separated by a space: ")
    choices.split(" ")
    return print(f"I chose: {random.choice(choices)}")


def countdown_letters():
    """Simulates the game countdown."""
    print("Let's play countdown! Choose nine letters :)")
    VOWELS = "a e i o u".upper().split(" ")
    CONSONANTS = "b c d f g h j k l m n p q r s t v w x y z".upper().split(" ")
    ALPHABET = "a b c d e f g h i j k l m n o p q r s t u v w x y z".upper().split(" ")
    letters = []
    for _ in range(9):
        choice = input("Vowel (V) or consonant (C)?: ")
        if choice.upper() == "V":
            letter = random.choice(VOWELS)
        elif choice.upper() == "C":
            letter = random.choice(CONSONANTS)
        else:
            print(
                "Oops, we didn't recognise your command so we just added a random letter :/"
            )
            letter = random.choice(ALPHABET)
        letters.append(letter)
    print(f"Your letters are: {letters}")
    for i in range(30, 0, -1):
        print(i)
        time.sleep(1)
    print("Times up!!")
    return


def countdown_numbers():
    """Simulates the maths round on a game of countdown."""
    pass


def main():
    print("Welcome to the Random Number Generator!")
    return random_multiple()


if __name__ == "__main__":
    main()
