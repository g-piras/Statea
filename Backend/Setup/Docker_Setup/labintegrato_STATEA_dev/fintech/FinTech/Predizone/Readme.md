# Analysis and prediction

## Summary

For the predictive model were used official data provided by the [ISTAT](http://dati.istat.it/viewhtml.aspx?il=blank&vh=0000&vf=0&vcq=1100&graph=0&view-metadata=1&lang=it&QueryId=25864) website regarding arrivals in the region of Sardinia and in the various provinces by both foreign and Italian tourists; these data start from January 2008.

We used the data excluding the years during which there was the Covid epidemic (2020-22) because then the forecasts would not provide consistent data given the halt in tourism during that period.

⚠️ In 2016 there was a redistribution of provinces in Sardinia, from the old 8 provinces of Olbia-Tempio, Sassari, Nuoro, Oristano, Ogliastra, Cagliari, Medio Campidano and Carbonia-Iglesias to the new 5 of Sassari, Nuoro, Oristano, South Sardinia, and Cagliari.⚠️

---

## Satabase connection

In controller folder ("FinTech/Predizone/generate all prediction/controller") there is
a python file is imported into the notebook file with functions that are used to receive dataframes:

```
import db_function_aut as linked
```

These functions include:

```
get_dataFrame_by_table(table)
```

which given the db table name as a parameter restores the dataframe

## Get all predictions

For get all predictions there is a file in a controller that allows you to create all the necessary predictions

example:

This get all prediction for Caglairi and Oristano

```
get_prediction_scriptCAGLI(df,df_filtered)
```

## Model used:

The model that is used in the function is a customized version of the "ForecasterAutoreg" class called "ForecasterAutoregCustom."

ForecasterAutoreg is a time series forecasting model class that uses autoregressive regression to make forecasts. Autoregressive regression (AR) is a forecasting technique based on the analysis of historical data. The model uses past time series data to make predictions about future data.

In this case, the model uses a linear regression model called Ridge as the regressor. Ridge is a variant of linear regression that uses lax regression to avoid overfitting.

In summary, ForecasterAutoregCustom is a forecasting model based on autoregressive regression using a Ridge regressor.

### Provinces with correct data from 2008 to 2020 (last year of forecast)(08_20)

- Sardegna (the whole region) = ITG2
- Oristano = ITG28

### Provinces with 3-year peaks from 2017 to 2020(17_20)

- Sud-Sardegna = IT111
- Sassari = ITG25
- Nuoro = ITG26

### Data available only up to 2017(08_17)

- Cagliari = ITG27
- Olbia-Tempio = ITG29
- Ogliastra = ITG2A
- Medio Campidano = ITG2B
- Carbonia-Iglesias = ITG2C
