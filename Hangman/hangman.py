# Hangman game recreation
import random
import time


def import_words(filename):
    words = []

    with open(filename, "r") as file:
        for line in file:
            words.append(line.strip().lower())

    return words


def choose_diff():
    """Returns number of lives.
    Based on difficulty choice of player.
    """
    diff = input("Choose a difficulty level from 1-3")
    # Assign and return no. of lives based on choice.
    valid = ["1", "2", "3"]
    if not diff in valid:
        print("Invalid choice.")
        return choose_diff()
    if diff == "1":
        no_lives = 10
    if diff == "2":
        no_lives = 7
    if diff == "3":
        no_lives = 4
    return no_lives


def check_guess(word, guess):
    indexes = []
    for i in range(0, len(word)):
        if word[i] == guess:
            indexes.append(i)
    return indexes


def hangman(word, lives):
    """Performs single game of hangman."""
    # Assign blank word, guessed, correct guesses, and turn count.
    blank = list("_" * len(word))
    guesses = []
    turn_count = 1
    print(f"You have {lives} lives to guess the word.")

    while ("_" in blank) and (lives > 0):
        # Print player statistics.
        print(f"{lives} lives\tTurn no.{turn_count}")
        print(f"Your guesses so far: {", ".join(guesses)}")
        print(" ".join(blank))

        guess = input("Guess a letter: ")
        guess.lower()

        # Checks for invalid input guess.
        if guess in guesses:
            print("You've guessed that already!")
            continue
        if len(guess) != 1:
            print("Your guess should be a single letter only!")
            continue
        if not guess.isalpha():
            print("Your guess should contain a letter only!")
            continue

        turn_count += 1
        guesses.append(guess)

        indexes = check_guess(word, guess)
        if not indexes:
            print("Sorry, that guess was incorrect.")
            print("Try again!")
            lives -= 1
            continue
        for i in indexes:
            blank[i] = guess

    # If player loses or wins.
    if lives == 0:
        print(f"Oops, you didn't guess the word was {word}, better luck next time!")
    else:
        print(f"Well done!")
        print(f"You guessed {word} was the word in {turn_count} turns.")
        print(f"You had {lives} lives left!")
    return play_again()


def generate_word(words):
    """Generates a random word from list."""
    return random.choice(words)


def initialise():
    """Chooses difficulty and new word, returns game function."""
    lives = choose_diff()

    words = import_words("words.txt")
    word = generate_word(words)

    return hangman(word, lives)


def play_again():
    """Lets player choose to play again."""
    ans = input("Would you like to play again? (Y/N): ")
    valid = ["Y", "N"]
    if not ans in valid:
        print("Invalid input! 'Y' or 'N' please.")
        return play_again()
    elif ans == "N":
        print("Thank you for playing!")
        time.sleep(2)
        exit
    print("Yay!")
    return initialise()


print("Welcome to hangman!")

initialise()
