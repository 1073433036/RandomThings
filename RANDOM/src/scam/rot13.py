encrypt=input("Input string:")
decrypt=""
for i in range(len(encrypt)):
    curr=ord(encrypt[i])
    if curr==32:
        decrypt+=" "
    elif curr<78:
        decrypt+=chr(curr+13)
    else:
        decrypt+=chr(curr-13)
print(decrypt)
