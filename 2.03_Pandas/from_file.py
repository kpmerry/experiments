import csv
import pandas as pd


def read_csv_file(filename):
    file_data = []
    with open(filename) as csvfile:
        fin = csv.reader(csvfile)
        for line in fin:
            file_data.append(line)
    table_name = file_data[0][0][3:]
    columns = file_data[1]
    data = file_data[2:]

    return (table_name, columns, data)


def sort_by_column(data, columns, col_name):
    if col_name not in columns:
        raise Exception("Not Found")
    col_index = columns.index(col_name)
    return sorted(data, key=lambda x: x[col_index])


def table_data(filename, sort=None):
    table_name, columns, data = read_csv_file(filename)
    if sort:
        data = sort_by_column(data, columns, sort)
    return table_name, pd.DataFrame(data, columns=columns)


def main():
    name, table = table_data("movie_data.csv", "IMDb Rating")
    print(name)
    print(table)


if __name__ == "__main__":
    main()
