def answer(n):
    cells = int(n)

    count = 0
    while cells != 1:
        if cells % 4 == 1:
            count += 1
            cells -= 1
        elif cells % 4 == 3:
            # better to -1
            if cells == 3:
                count += 1
                cells -= 1
            else:
                count += 1
                cells += 1
        else:
            count += 1
            cells /= 2
    return count


print(answer("15"))
