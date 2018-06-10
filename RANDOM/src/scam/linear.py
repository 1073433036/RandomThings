from flask import Flask
from sklearn import linear_model
from sklearn.linear_model import Ridge
from sklearn.preprocessing import PolynomialFeatures
from sklearn.pipeline import make_pipeline

app=Flask(__name__)

@app.route("/")
def hello():
    return "Hello World!"

hourandday=[[5,1],[6,1],[7,1],[8,1],[9,1],[10,1],[11,1],[12,1],[5,6],[6,6],[7,6],[8,6],[9,6],[10,6],[11,6],[12,6]]
traffic=[1,4,7,9,10,8,6,4.5,1,1,3,4,5,6,8,9]

#model=linear_model.LinearRegression()
model2=make_pipeline(PolynomialFeatures(2),Ridge())


@app.route("/train")
def training():
    #train the model
    #model.fit(hourandday,traffic)
    model2.fit(hourandday,traffic)
    return "Training finished"

@app.route("/predict/<time>/<day>")
def prediction(time, day):
    #call the prediction and return the predicted value
    #res=int(model.predict([[time,day]]))
    res=int(model2.predict([[time,day]]))
    return 'Result %f' %res



training()

prediction(5,1)


if __name__ == '__main__':
    app.run(host='0.0.0.0')
