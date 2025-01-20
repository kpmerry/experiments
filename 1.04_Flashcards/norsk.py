import numpy as np
from pandas import read_csv


def pick_random(vocab):
    index = np.random.randint(len(vocab["English"]))
    return (vocab["English"][index], vocab["Norsk"][index])


def multiple_choice(word_dict):
    en, no = pick_random(word_dict)
    w1 = pick_random(word_dict)[1]
    w2 = pick_random(word_dict)[1]
    w3 = pick_random(word_dict)[1]
    choices = [no, w1, w2, w3]
    np.random.shuffle(choices)
    choice_dict = {}
    for i in range(len(choices)):
        choice_dict[i] = choices[i]

    print(f"What is the Norwegian for {en}?")
    print(f"Your choices are:")
    for key in choice_dict:
        print(f"{key + 1}: {choice_dict[key]}")
    ans = input("Pick the answer you think is correct (1, 2, 3, 4):")
    if int(ans) - 1 == choices.index(no):
        print("Well done!")
    else:
        print(f"Oops, the answer was {no}")
    return another_mult_choice(word_dict)


def another_mult_choice(w_dict):
    ans = input("Do another multiple choice question? (Y/N)")
    if ans.upper() == "Y":
        return multiple_choice(w_dict)
    else:
        pick_revision_type(w_dict)


def flashcards(word_dict):
    en, no = pick_random(word_dict)
    print("\n", no)
    input("\nPress enter to see the English translation.\n")
    print(en, "\n")
    return another_flashcard(word_dict)


def another_flashcard(w_dict):
    ans = input("Do another Flashcard? (Y/N)")
    if ans.upper() == "Y":
        return flashcards(w_dict)
    else:
        pick_revision_type(w_dict)


def pick_revision_type(vocab):
    choice = input(
        "Choose if you would like to play flashcards (F), multiple choice (M), or exit (E):"
    )
    if choice == "F":
        flashcards(vocab)
    elif choice == "M":
        multiple_choice(vocab)
    elif choice == "E":
        exit()
    else:
        print("Invalid choice!")
        return pick_revision_type(vocab)


def main(filename):
    vocab = read_csv(filename)
    pick_revision_type(vocab)


if __name__ == "__main__":
    main("no_en_vocab.csv")
