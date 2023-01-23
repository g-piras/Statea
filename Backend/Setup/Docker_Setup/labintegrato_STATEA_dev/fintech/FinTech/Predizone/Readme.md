# Analysis and prediction

For the predictive model were used official data provided by the [ISTAT](http://dati.istat.it/viewhtml.aspx?il=blank&vh=0000&vf=0&vcq=1100&graph=0&view-metadata=1&lang=it&QueryId=25864) website regarding arrivals in the region of Sardinia and in the various provinces by both foreign and Italian tourists; these data start from January 2008.

We used the data excluding the years during which there was the Covid epidemic (2020-22) because then the forecasts would not provide consistent data given the halt in tourism during that period.

In 2016 there was a redistribution of provinces in Sardinia, from the old 8 provinces of Olbia-Tempio, Sassari, Nuoro, Oristano, Ogliastra, Cagliari, Medio Campidano and Carbonia-Iglesias to the new 5 of Sassari, Nuoro, Oristano, South Sardinia, and Cagliari.

---

a python file is imported into the notebook file with functions that are used to receive dataframes:

```
import db_function_aut as linked
```

These functions include:

```
get_dataFrame_by_table(table)
```

which given the db table name as a parameter restores the dataframe

## Useful commands:

Select specific values:

```
df_filtered = df[df.eval("observation_type_id == 'AR' and accommodation_type_id == 'OTHER' and origin_id == 'WRL_X_ITA'")]

df_filtered = df[df.eval("observation_type_id == 'AR' and accommodation_type_id == 'ALL' and origin_id == 'WRL_X_ITA'")]
```

# Provinces with correct data from 2008 to 2020 (last year of forecast)(08_20)

lags 20/30

- Sardegna (the whole region) = ITG2
- Oristano = ITG28

# Provinces with 3-year peaks from 2017 to 2020(17_20)

lags = 15/13

- Sud-Sardegna = IT111
- Sassari = ITG25
- Nuoro = ITG26

# Data available only up to 2017(08_17)

- Cagliari = ITG27
- Olbia-Tempio = ITG29
- Ogliastra = ITG2A
- Medio Campidano = ITG2B
- Carbonia-Iglesias = ITG2C
