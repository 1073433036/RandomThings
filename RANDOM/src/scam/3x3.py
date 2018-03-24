print("Enter three lines of three words:")
words=[]
for i in range(3):
    t=input()
    arr=str(t).split(" ")
    words.append(arr)
word=input("Enter one word to lookup:")
found=False
for j in range(3):
    if not found:
        for i in range(3):
            if word in words[j][i]:
                t=words[j][i].index(word)
                print("\""+word+"\" found at line "+str(j+1)+", word "+str(i+1)+", character "+str(t+1))
                found=True
                break
    else:
        break
