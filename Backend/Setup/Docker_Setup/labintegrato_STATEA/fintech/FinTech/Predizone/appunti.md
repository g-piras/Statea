# Appunti con funzioni inutilizzate

### Percentuale arrivi/presenze

```
import matplotlib.pyplot as plt

# Seleziona le colonne 'observation_type_id' e 'observation' dal dataframe
data = df[['observation_type_id', 'observation']]

# Filtra i dati per ottenere solo i valori di AR e NI
ar_data = data[data['observation_type_id'] == 'AR']
ni_data = data[data['observation_type_id'] == 'NI']

# Somma le osservazioni per ottenere il totale per AR e NI
ar_total = ar_data['observation'].sum()
ni_total = ni_data['observation'].sum()

# Crea un grafico a torta con i dati di AR e NI
labels = ['Arrivi', 'Notti']
sizes = [ar_total, ni_total]
colors = ['#ff9999','#66b3ff']

fig1, ax1 = plt.subplots()
ax1.pie(sizes, labels=labels, colors=colors, autopct='%1.1f%%', startangle=90)

# Imposta il titolo del grafico
plt.title('Percentule')

# Mostra il grafico
plt.show()
```

# (error) primo test di predizione

```
steps = 36

# train
df_train = df[:-steps]
train_x = df_train["destination_id"]
train_y = df_train['observation']

# test
df_test  = df[-steps:]
test_x = df_test["destination_id"]
test_y = df_test['observation']


# plot
fig, ax=plt.subplots(figsize=(12, 6))
train_y.plot(ax=ax, label='train')
test_y.plot(ax=ax, label='test')
ax.legend();
plt.show()


```

# Codifica one-hot di scikit-learn

```
from sklearn.preprocessing import OneHotEncoder
import numpy as np

# Immaginiamo di avere un array numpy con le destinazioni
destinations = np.array(["Sardenga", "Sassari", "Nuoro", "Cagliari", "Oristano"])

# Creiamo l'oggetto OneHotEncoder
encoder = OneHotEncoder()

# Utilizziamo l'oggetto per fare la codifica one-hot delle destinazioni
one_hot = encoder.fit_transform(destinations.reshape(-1, 1))

# Stampiamo il risultato
print(one_hot.toarray())
```

# Salvare/caricare un modello addestrato

https://github.com/FabioGagliardiIts/ai_ml_python/blob/main/Lezione_16/model_persistence_pmml.ipynb

# Import librerie per la predizione

#lezione 17

# https://github.com/FabioGagliardiIts/ai_ml_python/blob/main/Lezione_17/ml_forecasting.ipynb

```
# regression
from sklearn.preprocessing import StandardScaler
from sklearn.preprocessing import PolynomialFeatures
from sklearn.linear_model import Ridge
from sklearn.pipeline import make_pipeline

# metrics
from sklearn.metrics import mean_squared_error
from sklearn.metrics import r2_score

# forecasting
from skforecast.ForecasterAutoreg import ForecasterAutoreg
from skforecast.model_selection import grid_search_forecaster
from skforecast.model_selection import backtesting_forecaster
```

# delete column

```
data = df.drop(['observation_type_id', 'destination_id', 'origin_id', 'accommodation_type_id'], axis=1, inplace=True)
```

```
from statsmodels.tsa.arima_model import ARIMA
from sklearn.metrics import mean_absolute_error
import pandas as pd

# Caricare i dati in un dataframe
data = pd.read_csv("data.csv")

# Dividere i dati in set di addestramento e di test
train_data = data[:int(len(data)*0.8)]
test_data = data[int(len(data)*0.8):]

# Creare e addestrare il modello ARIMA
model = ARIMA(train_data, order=(1,1,1))
model_fit = model.fit()

# Fare previsioni sui dati di test
predictions = model_fit.predict(start=len(train_data), end=len(data)-1, typ='levels')

# Calcolare l'errore assoluto medio
mae = mean_absolute_error(test_data, predictions)
print("MAE: ", mae)
```

for i in range(0,len(destinanion)):
for j in range(0,len(origin_id)):
for z in range(0,len(observation_type_id)):
for x in range(0,len(accommodation_type_id)):
df_filtered = script_by_filt(destinanion[i],origin_id[j],observation_type_id[z],accommodation_type_id[x])[0]
name = script_by_filt(destinanion[i],origin_id[j],observation_type_id[z],accommodation_type_id[x])[1]
save_file(df,df_filtered,name)
