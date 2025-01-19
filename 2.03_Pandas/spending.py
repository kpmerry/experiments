import pandas as pd
import numpy as np


# Functions for showing Series of spending:
def spending_periodically(period_expenses):
    """Shows spending categories for a period of spending."""
    unindexed_expenses = []
    for key in period_expenses:
        unindexed_expenses += period_expenses[key]
    global periodical_spending
    periodical_spending = {}
    for c, a in unindexed_expenses:
        spend(c, a)
    return show_spending(periodical_spending)


def spend(category: str, amount: int):
    """Adds an expense to a category for a series."""
    global periodical_spending
    if category in periodical_spending:
        periodical_spending[category] += amount
    else:
        periodical_spending[category] = amount


def show_spending(spending):
    """Shows spending as a series of data."""
    count = 0
    for category in spending:
        count += spending[category]
    spending["Sum"] = count
    return pd.Series(spending)


# Functions for showing a Data Frame of spending by month.
def show_spending_indexed(expense_dict: dict):
    all_expenses = []
    indexes = []
    for key in expense_dict:
        indexes.append(key)
        all_expenses += add_index(expense_dict[key], key)
    return pd.DataFrame(spend_with_index(all_expenses), index=indexes)


def spend_with_index(expenses: list[tuple]):
    """Show spendings with categories and an index, such as Month."""
    spending = {}
    for c, a, m in expenses:
        if not c in spending:
            spending[c] = {m: a}
        elif not m in spending[c]:
            spending[c][m] = a
        else:
            spending[c][m] += a
    return spending


def add_index(expenses: list[tuple], index: str):
    indexed_expenses = []
    for c, a in expenses:
        indexed_expenses.append((c, a, index))
    return indexed_expenses


def main():
    jan_spend = [
        ("Groceries", 45.21),
        ("Rent", 450.01),
        ("Eating out", 63.43),
        ("Bills", 20.13),
        ("Groceries", 12.43),
        ("Health", 18.16),
        ("Maintenance", 3.49),
        ("Groceries", 2.31),
    ]

    feb_spend = [
        ("Groceries", 35.45),
        ("Rent", 450),
        ("Eating out", 23.99),
        ("Bills", 20),
        ("Groceries", 12.43),
        ("Health", 19.22),
        ("Going out", 7.89),
        ("Groceries", 5.86),
        ("Groceries", 12.32),
    ]

    total_spending = {"Jan": jan_spend, "Feb": feb_spend}

    print("\nSpending Overall:")
    print(spending_periodically(total_spending))
    print("\nSpending By Month:")
    print(show_spending_indexed(total_spending))


if __name__ == "__main__":
    main()
