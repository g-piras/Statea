# import library
import mysql.connector
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
import os
sns.set_theme()

#library for machine learning
from sklearn.linear_model import LinearRegression
from sklearn.linear_model import Lasso
from sklearn.ensemble import RandomForestRegressor
from sklearn.metrics import mean_squared_error
from sklearn.preprocessing import StandardScaler
from sklearn.pipeline import make_pipeline

from skforecast.ForecasterAutoreg import ForecasterAutoreg
from skforecast.ForecasterAutoregCustom import ForecasterAutoregCustom
from skforecast.ForecasterAutoregDirect import ForecasterAutoregDirect
from skforecast.model_selection import grid_search_forecaster
from skforecast.model_selection import backtesting_forecaster
from skforecast.utils import save_forecaster
from skforecast.utils import load_forecaster

from sklearn.preprocessing import StandardScaler
from sklearn.preprocessing import PolynomialFeatures
from sklearn.linear_model import Ridge
from sklearn.pipeline import make_pipeline


from sklearn.metrics import mean_squared_error
from sklearn.metrics import r2_score


# import my function
import db_function_aut as linked
import df_modify as mod

# sardegna,Oristano
def get_prediction_scriptSAR(df,df_filtered):
        
    # filter by date
    df = mod.filter_by_date(df_filtered,"2008-01-01","2019-12-01")


    df_filtered['date'] = pd.to_datetime( df_filtered['date'], format="%Y-%m-%d")
    df_select_date = df_filtered['date'].between('2008-01-01','2019-12-01')
    data = df_filtered[df_select_date]
    # remove useless columns for the train/test
    data.drop(['observation_type_id', 'destination_id', 'origin_id', 'accommodation_type_id'], axis=1, inplace=True)


    data.columns = data.columns.str.replace('observation', 'y')
    data['date'] = pd.to_datetime(data['date'], format='%Y/%m/%d')
    data = data.set_index('date')
    data = data.asfreq('MS')
    f_train = data[:-36]
    f_test  = data[-36:]

    f_train_y = f_train['y']
    f_test_y  = f_test['y']



    # the 36 months of testing plus the 60 unknowns
    steps = 36 + 60


    # Create and train forecaster
    forecaster = ForecasterAutoreg(
                    regressor =  Ridge(),
                    transformer_y = StandardScaler(),
                    lags      = 30 # la finestra temporale che definisce le righe della matrice di feature
                )

    forecaster.fit(y=f_train_y)


    # prediction
    f_pred = forecaster.predict(steps=steps)



    # Test error and accuracy
    mse_all = mean_squared_error(f_test_y, f_pred[:-60])
    r2_all  = r2_score(f_test_y, f_pred[:-60])
    print(" MSE:", mse_all, "  R2:", r2_all) 

    # Create and train forecaster
    fa_autoreg = ForecasterAutoreg(regressor = Ridge(alpha=0.001),
                                transformer_y = StandardScaler(),
                                lags = 20)

    fa_autoreg.fit(y=f_train_y)

    # prediction
    fa_pred = fa_autoreg.predict(steps=steps)

    # Test error and accuracy
    mse_all = mean_squared_error(f_test_y, fa_pred[:-60])
    r2_all  = r2_score(f_test_y, fa_pred[:-60])
    print(" MSE:", mse_all, "  R2:", r2_all) 
        

    # Create forecaster
    forecaster = ForecasterAutoreg(RandomForestRegressor(random_state=123), lags=3)
    forecaster.fit(y=data['y'])
    forecaster.predict(steps=3)

   
    
    return forecaster


# Sassari,Nuoro
def get_prediction_scriptSAS(df,df_filtered):
        
    # filter by date
    df = mod.filter_by_date(df_filtered,"2017-01-01","2019-12-01")


    df_filtered['date'] = pd.to_datetime( df_filtered['date'], format="%Y-%m-%d")
    df_select_date = df_filtered['date'].between('2017-01-01','2019-12-01')
    data = df_filtered[df_select_date]
    # remove useless columns for the train/test
    data.drop(['observation_type_id', 'destination_id', 'origin_id', 'accommodation_type_id'], axis=1, inplace=True)


    data.columns = data.columns.str.replace('observation', 'y')
    data['date'] = pd.to_datetime(data['date'], format='%Y/%m/%d')
    data = data.set_index('date')
    data = data.asfreq('MS')
    f_train = data[:-12]
    f_test  = data[-12:]

    f_train_y = f_train['y']
    f_test_y  = f_test['y']


    # the 24 months of testing plus the 12 unknowns
    steps = 24 + 12


    # Create and train forecaster
    forecaster = ForecasterAutoreg(
                    regressor =  Ridge(),
                    transformer_y = StandardScaler(),
                    lags      = 15 # la finestra temporale che definisce le righe della matrice di feature
                )

    forecaster.fit(y=f_train_y)


    # prediction
    f_pred = forecaster.predict(steps=steps)



    # Test error and accuracy
    mse_all = mean_squared_error(f_test_y, f_pred[:-24])
    r2_all  = r2_score(f_test_y, f_pred[:-24])
    print(" MSE:", mse_all, "  R2:", r2_all) 

    # Create and train forecaster
    fa_autoreg = ForecasterAutoreg(regressor = Ridge(alpha=0.001),
                                transformer_y = StandardScaler(),
                                lags = 10)

    fa_autoreg.fit(y=f_train_y)

    # prediction
    fa_pred = fa_autoreg.predict(steps=steps)

    # Test error and accuracy
    mse_all = mean_squared_error(f_test_y, fa_pred[:-24])
    r2_all  = r2_score(f_test_y, fa_pred[:-24])
    print(" MSE:", mse_all, "  R2:", r2_all) 
        

    # Create forecaster
    forecaster = ForecasterAutoreg(RandomForestRegressor(random_state=123), lags=11)
    forecaster.fit(y=data['y'])
    forecaster.predict(steps=3)

   
    
    return forecaster


# Cagliari,Olbia-Tempio,Ogliastra,Medio Campidano,Carbonia-Iglesias
def get_prediction_scriptCAGLI(df,df_filtered):
        
    # filter by date
    df = mod.filter_by_date(df_filtered,"2008-01-01","2016-12-01")


    df_filtered['date'] = pd.to_datetime( df_filtered['date'], format="%Y-%m-%d")
    df_select_date = df_filtered['date'].between('2008-01-01','2016-12-01')
    data = df_filtered[df_select_date]
    # remove useless columns for the train/test
    data.drop(['observation_type_id', 'destination_id', 'origin_id', 'accommodation_type_id'], axis=1, inplace=True)


    data.columns = data.columns.str.replace('observation', 'y')
    data['date'] = pd.to_datetime(data['date'], format='%Y/%m/%d')
    data = data.set_index('date')
    data = data.asfreq('MS')
    f_train = data[:-12]
    f_test  = data[-12:]

    f_train_y = f_train['y']
    f_test_y  = f_test['y']


    # the 24 months of testing plus the 12 unknowns
    steps = 24 + 12


    # Create and train forecaster
    forecaster = ForecasterAutoreg(
                    regressor =  Ridge(),
                    transformer_y = StandardScaler(),
                    lags      = 30 # la finestra temporale che definisce le righe della matrice di feature
                )

    forecaster.fit(y=f_train_y)


    # prediction
    f_pred = forecaster.predict(steps=steps)



    # Test error and accuracy
    mse_all = mean_squared_error(f_test_y, f_pred[:-24])
    r2_all  = r2_score(f_test_y, f_pred[:-24])
    print(" MSE:", mse_all, "  R2:", r2_all) 

    # Create and train forecaster
    fa_autoreg = ForecasterAutoreg(regressor = Ridge(alpha=0.001),
                                transformer_y = StandardScaler(),
                                lags = 13)

    fa_autoreg.fit(y=f_train_y)

    # prediction
    fa_pred = fa_autoreg.predict(steps=steps)

    # Test error and accuracy
    mse_all = mean_squared_error(f_test_y, fa_pred[:-24])
    r2_all  = r2_score(f_test_y, fa_pred[:-24])
    print(" MSE:", mse_all, "  R2:", r2_all) 
        

    # Create forecaster
    forecaster = ForecasterAutoreg(RandomForestRegressor(random_state=123), lags=3)
    forecaster.fit(y=data['y'])
    forecaster.predict(steps=3)

   
    
    return forecaster


def pred_ann_08_20(query):
    table = "observation_year"
    df  = linked.get_dataFrame_by_table(table)
    df_filtered = df[df.eval(query)]
    df_filtered = df_filtered.drop(df_filtered.query("year == 2021").index)
    df_filtered = df_filtered.drop(df_filtered.query("year == 2020").index)


    data = df_filtered
    # remove useless columns for the train/test
    data.drop(['observation_type_id', 'destination_id', 'origin_id', 'accommodation_type_id'], axis=1, inplace=True)
    data.columns = data.columns.str.replace('observation', 'y')
    data.columns = data.columns.str.replace('year', 'date')
    data
    from sklearn.linear_model import LinearRegression

    # Create a linear regression object
    reg = LinearRegression()

    # Divide the data into training and test data
    x_train = data['date'].values.reshape(-1, 1)
    y_train = data['y'].values

    # Train the linear regression model
    reg.fit(x_train, y_train)
    
    # Make a prediction for the year 2025
    # x_test = [[2025]]
    # y_pred = test_pred_year().predict(x_test)
    # print(y_pred)
    return reg


def pred_ann_08_17(query):
    table = "observation_year"
    df  = linked.get_dataFrame_by_table(table)
    df_filtered = df[df.eval(query)]


    data = df_filtered
    # remove useless columns for the train/test
    data.drop(['observation_type_id', 'destination_id', 'origin_id', 'accommodation_type_id'], axis=1, inplace=True)
    data.columns = data.columns.str.replace('observation', 'y')
    data.columns = data.columns.str.replace('year', 'date')
    data
    from sklearn.linear_model import LinearRegression

    # Create a linear regression object
    reg = LinearRegression()

    # Divide the data into training and test data
    x_train = data['date'].values.reshape(-1, 1)
    y_train = data['y'].values

    # Train the linear regression model
    reg.fit(x_train, y_train)
    
    # Make a prediction for the year 2025
    # x_test = [[2025]]
    # y_pred = test_pred_year().predict(x_test)
    # print(y_pred)
    return reg

def pred_ann_17_20(query):
    table = "observation_year"
    df  = linked.get_dataFrame_by_table(table)
    df_filtered = df[df.eval(query)]
    df_filtered = df_filtered.drop(df_filtered.query("year == 2021").index)
    df_filtered = df_filtered.drop(df_filtered.query("year == 2020").index)


    data = df_filtered
    # remove useless columns for the train/test
    data.drop(['observation_type_id', 'destination_id', 'origin_id', 'accommodation_type_id'], axis=1, inplace=True)
    data.columns = data.columns.str.replace('observation', 'y')
    data.columns = data.columns.str.replace('year', 'date')
    data
    from sklearn.linear_model import LinearRegression

    # Create a linear regression object
    reg = LinearRegression()

    # Divide the data into training and test data
    x_train = data['date'].values.reshape(-1, 1)
    y_train = data['y'].values

    # Train the linear regression model
    reg.fit(x_train, y_train)
    
    # Make a prediction for the year 2025
    # x_test = [[2025]]
    # y_pred = test_pred_year().predict(x_test)
    # print(y_pred)
    return reg


def is_df_empty(df):
    return len(df) == 0



def get_df_to_check(query):
    table = "observation_year"
    df  = linked.get_dataFrame_by_table(table)
    df_filtered = df[df.eval(query)]
    df_filtered = df_filtered.drop(df_filtered.query("year == 2021").index)
    df_filtered = df_filtered.drop(df_filtered.query("year == 2020").index)
    result = is_df_empty(df_filtered)
    return result

#testing
# x_test = [[2025]]
# query = "accommodation_type_id == 'ALL'  and destination_id == 'IT111'  and origin_id == 'GR' and observation_type_id == 'AR'"
# y_pred = pred_ann_17_20(query).predict(x_test)
# print(y_pred)

