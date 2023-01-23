from skforecast.utils import load_forecaster

path_file = '/home/kindaglia/Documents/GitHub/Statea/FinTech/Predizone/presenze.py'
#load
forecaster_loaded = load_forecaster(path_file)
# Predict
x = forecaster_loaded.predict(steps=60)

print(x,"\n")

#restitisce solo il value seguendo l'array
print(x[0],"\n")

