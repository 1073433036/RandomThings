a=15

t=True
b=2
if a==1:
    print(False)
else:
    while b*b<=a:
        if a%b==0:
            t=False
            break
        b+=1
    print(t)
