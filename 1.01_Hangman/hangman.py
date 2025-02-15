# Hangman game recreation
import random
import time

DELAY = 0.5


def import_words(filename):
    """Imports words for hangman."""
    words = []

    with open(filename, "r") as file:
        for line in file:
            words.append(line.strip().lower())

    return words


def choose_diff():
    """Returns number of lives based on player's chosen difficulty."""
    diff = input("Choose a difficulty level from 1-3: ")
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
    return no_lives, diff


def check_guess(word, guess):
    """Finds indexes of guess in word. Returns empty if none."""
    indexes = []
    for i in range(0, len(word)):
        if word[i] == guess:
            indexes.append(i)
    return indexes


def hangman(word, lives, diff):
    """Performs single game of hangman."""
    # Assign blank word, guessed, correct guesses, and turn count.
    blank = list("_" * len(word))
    guesses = []
    turn_count = 1
    print(f"You have {lives} lives to guess the word.")

    while ("_" in blank) and (lives > 0):
        # Print player statistics.
        time.sleep(DELAY)
        print("\n~ ~ ~ ~ ~ * ~ ~ ~ ~ ~")
        print(f"\n{lives} lives left\tTurn no.{turn_count}")
        print(f"Your guesses so far: {", ".join(guesses)}")
        print(" ".join(blank))

        guess = input("Guess a letter: ").lower()

        # Checks for invalid input guess.
        if guess in guesses:
            print("You've guessed that already!")
            time.sleep(DELAY)
            continue
        if len(guess) != 1:
            print("Your guess should be a single letter only!")
            time.sleep(DELAY)
            continue
        if not guess.isalpha():
            print("Your guess should contain a letter only!")
            time.sleep(DELAY)
            continue

        turn_count += 1
        guesses.append(guess)

        indexes = check_guess(word, guess)
        if not indexes:
            print("Sorry, that guess was incorrect.")
            lives -= 1
            if lives > 0:
                print("Try again!")
            time.sleep(DELAY)
            continue
        print("Correct guess!")
        time.sleep(DELAY)
        for i in indexes:
            blank[i] = guess

    # If player loses or wins.
    if lives == 0:
        print(f"Oops, you didn't guess the word was {word}, better luck next time!")
    else:
        print(f"Well done!\n")
        time.sleep(DELAY)
        print(f"You guessed {word} was the word in {turn_count} turns.")
        print(f"You had {lives} lives left!\n")
        global score
        score += (26 - turn_count) * lives * int(diff)
    print(
        f"Game score: {(26 - turn_count) * lives * int(diff)}\t\tTotal score: {score}\n"
    )
    time.sleep(DELAY)
    return play_again()


def generate_word(words):
    """Generates a random word from list."""
    word = random.choice(words)
    if word in chosen_words:
        return generate_word(words)
    chosen_words.append(word)
    return word


def play_again():
    """Lets player choose to play again."""
    ans = input("Would you like to play again? (Y/N): ")
    valid = ["Y", "N"]
    if not ans.upper() in valid:
        print("Invalid input! 'Y' or 'N' please.")
        time.sleep(DELAY)
        return play_again()
    elif ans.upper() == "N":
        print("Thank you for playing!")
        print(f"\nTotal Score: {score}")
        time.sleep(DELAY)
        exit
    else:
        print("Yay!")
        time.sleep(DELAY)
        return main()


def main():
    """Chooses difficulty and new word, returns game function."""
    lives, diff = choose_diff()

    words = import_words("words.txt")
    word = generate_word(words)

    return hangman(word, lives, diff)


if __name__ == "__main__":
    # Assign values for session data: player score and words already chosen.
    global score
    score = 0
    chosen_words = []

    print("Welcome to hangman!")
    main()
