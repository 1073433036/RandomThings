from sklearn import svm

input_data = [[2000, 2400, 8, 4], [2016, 1800, 9, 3], [2002, 2350, 7, 2], [1980, 1000, 1, 1], [
    1900, 2000, 5, 4], [2001, 2230, 4, 4], [1957, 2300, 8, 4], [2016, 1800, 9, 3], [2001, 2230, 1, 4]]
output_data = [0, 1, 0, 1, 0, 0, 1, 1, 0]

model = svm.SVC()
model.fit(input_data, output_data)

print(model.predict([[2008, 2305, 10, 5]]))
