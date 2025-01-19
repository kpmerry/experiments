import pandas as pd
import numpy as np

spending = {}

categories = ["Groceries", "Eating Out", "Rent", "Bills", "Health"]
for category in categories:
    spending[category] = 0


def spend(category: str, amount: int):
    if category in spending:
        spending[category] += amount
    else:
        spending[category] = amount


def print_spending(spending):
    count = 0
    for category in spending:
        count += spending[category]
    spending["Sum"] = count
    return print(pd.Series(spending))


jan_spend = [
    ("Groceries", 45),
    ("Rent", 450),
    ("Eating out", 63.43),
    ("Bills", 20),
    ("Groceries", 12.43),
    ("Health", 18.16),
    ("Maintenance", 3.49),
    ("Groceries", 2.31),
]

for c, a in jan_spend:
    spend(c, a)

print_spending(spending)
