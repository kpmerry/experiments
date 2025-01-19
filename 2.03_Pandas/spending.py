import pandas as pd
import numpy as np


# Functions for showing Series of spending:
def monthly_spending(month_expenses):
    global m_spending
    m_spending = {}
    for c, a in month_expenses:
        spend(c, a)
    return show_spending(m_spending)


def spend(category: str, amount: int):
    """Adds an expense to a category for a series."""
    global m_spending
    if category in m_spending:
        m_spending[category] += amount
    else:
        m_spending[category] = amount


def show_spending(spending):
    count = 0
    for category in spending:
        count += spending[category]
    spending["Sum"] = count
    return pd.Series(spending)


# Functions for showing a Data Frame of spending by month.
def spend_monthly(expenses: list[tuple]):
    spending = {}
    for c, a, m in expenses:
        if not c in spending:
            spending[c] = {m: a}
        elif not m in spending[c]:
            spending[c][m] = a
        else:
            spending[c][m] += a
    return spending


def add_month(expenses: list[tuple], month: str):
    month_expenses = []
    for c, a in expenses:
        month_expenses.append((c, a, month))
    return month_expenses


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

    jan = add_month(jan_spend, "Jan")
    feb = add_month(feb_spend, "Feb")
    quarterly_spending = spend_monthly(jan + feb)

    print("\nSpending in January:")
    print(monthly_spending(jan_spend))
    print("\nSpending Overall:")
    print(pd.DataFrame(quarterly_spending, index=["Jan", "Feb"]))


if __name__ == "__main__":
    main()
