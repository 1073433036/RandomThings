from sklearn.cluster import KMeans

input_data=[[98],[85],[64],[70],[75],[99],[92],[83],[67],[74],[81],[55],[78],[92],[88]]

model=KMeans(4)
model.fit(input_data)

print(model.predict([[97]]))
print(model.predict([[93]]))
print(model.predict([[77]]))
print(model.predict([[75]]))
print(model.predict([[86]]))
print(model.predict([[82]]))
print(model.predict([[60]]))
print(model.predict([[59]]))
