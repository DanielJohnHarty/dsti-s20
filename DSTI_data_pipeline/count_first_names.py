def count_first_name(input: str, separator: str = " "):
    """
    Function defined to count the number of first name present in a txt file

    Parameters
    ----------
    - input: str, file name
    - separator: str, separator used in your file to separate first and last
      name
    Return
    ------
    - int: count of first names
    """
    file = open(input, "r")
    first_names = [line.strip().split(separator)[0] for line in file]
    return len(first_names)

count = count_first_name('input.txt')
print(count)
