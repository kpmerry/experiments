# Noughts and Crosses
import random


class Cell:
    def __init__(self, name, value="-"):
        self.name = name
        self.value = value

    def __str__(self):
        return self.value


class Grid:
    # Change later to linked list?
    def __init__(self, cells):
        self.cells = cells

    def __str__(self):
        res = "\\  a b c \n__ _ _ _"
        for i in range(0, 7, 3):
            res += "\n"
            res += str(i // 3 + 1) + " |"
            res += self.cells[i].value + " "
            res += self.cells[i + 1].value + " "
            res += self.cells[i + 2].value
        return res


def player_turn(grid):
    pos = input("Enter your choice: ")
    for obj in pos_list:
        if obj.name == pos:
            if pos in empty_cell_names:
                obj.value = "X"
                empty_cell_names.remove(pos)
            else:
                print("try again")
                return player_turn(grid)
    return print(grid)


def computer_turn(grid):
    pos2 = random.choice(empty_cell_names)
    for obj in pos_list:
        if obj.name == pos2:
            obj.value = "O"
            empty_cell_names.remove(pos2)
    return print(grid)


def did_player_win():
    # eight conditions for a player win
    if (
        a1.value == "X"
        and a2.value == "X"
        and a3.value == "X"
        or b1.value == "X"
        and b2.value == "X"
        and b3.value == "X"
        or c1.value == "X"
        and c2.value == "X"
        and c3.value == "X"
        or a1.value == "X"
        and b1.value == "X"
        and c1.value == "X"
        or a2.value == "X"
        and b2.value == "X"
        and c2.value == "X"
        or a3.value == "X"
        and b3.value == "X"
        and c3.value == "X"
        or a3.value == "X"
        and b2.value == "X"
        and c1.value == "X"
        or a1.value == "X"
        and b2.value == "X"
        and c3.value == "X"
    ):
        return True
    else:
        return False


def did_comp_win():
    # eight more for computer win
    if (
        a1.value == "O"
        and a2.value == "O"
        and a3.value == "O"
        or b1.value == "O"
        and b2.value == "O"
        and b3.value == "O"
        or c1.value == "O"
        and c2.value == "O"
        and c3.value == "O"
        or a1.value == "O"
        and b1.value == "O"
        and c1.value == "O"
        or a2.value == "O"
        and b2.value == "O"
        and c2.value == "O"
        or a3.value == "O"
        and b3.value == "O"
        and c3.value == "O"
        or a3.value == "O"
        and b2.value == "O"
        and c1.value == "O"
        or a1.value == "O"
        and b2.value == "O"
        and c3.value == "O"
    ):
        return True
    else:
        return False


a1 = Cell("a1")
a2 = Cell("a2")
a3 = Cell("a3")
b1 = Cell("b1")
b2 = Cell("b2")
b3 = Cell("b3")
c1 = Cell("c1")
c2 = Cell("c2")
c3 = Cell("c3")

pos_list = [a1, b1, c1, a2, b2, c2, a3, b3, c3]

grid = Grid(pos_list)

print(grid)
print("\nChoose a cell to place a cross.\n")

count = 0

global empty_cell_names
empty_cell_names = ["a1", "b1", "c1", "a2", "b2", "c2", "a3", "b3", "c3"]


while count < 10:
    player_turn(grid)
    count += 1

    play_win = did_player_win()
    if play_win == True:
        print("You win! Nice :)")
        break
    if count == 9:
        break

    computer_turn(grid)
    count += 1

    comp_win = did_comp_win()
    if comp_win == True:
        print("GAME OVER")
        print("You lose :(")
        break
