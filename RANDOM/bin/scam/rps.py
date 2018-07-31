import random
from sklearn import svm
input_data=[[1,2],[2,3]]
output_data=[3,2]

c=0
prev1=3
prev2=2
while not c==-1:
    model=svm.SVC()
    model.fit(input_data,output_data)
    c=model.predict([[prev1,prev2]])[0]
    i= int(input("Input (1) rock, (2) paper, (3) scissors   "))
    print(c)
    if c==1:
        c=2
    elif c==2:
        c=3
    else:
        c=1
        
    if i==1:
        if c==1:
            print("tie")
        elif c==2:
            print("lose")
        else:
            print("win")
    elif i==2:
        if c==2:
            print("tie")
        elif c==3:
            print("lose")
        else:
            print("win")
    elif i==3:
        if c==3:
            print("tie")
        elif c==1:
            print("lose")
        else:
            print("win")
    else:
        c=-1
    input_data.append([prev2,prev1])
    output_data.append(i)
    prev2=prev1
    prev1=i

