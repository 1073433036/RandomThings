num=str(input("Input num:"))
placeval=len(num)
digits=["one","two","three","four","five","six","seven","eight","nine"]
tens=["one","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"]
teens=["eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"]
out=""
places=["","","hundred","thousand"]
while placeval>0:
    if not int(num[len(num)-placeval])==0:
        if placeval==2:
            if int(num[len(num)-placeval])==1:
                out+=teens[int(num[len(num)-placeval+1])-1]
                placeval-=1
            else:
                out+=tens[int(num[len(num)-placeval])-1]+" "
        else:
            out+=digits[int(num[len(num)-placeval])-1]+" "
            out+=places[placeval-1]+" "
    placeval-=1
    
print(out)
