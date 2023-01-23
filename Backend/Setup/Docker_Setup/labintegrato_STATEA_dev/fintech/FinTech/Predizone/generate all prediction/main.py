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


import sys
sys.path.append("FinTech/Predizone/generate all prediction/controller")


# import my function
import db_function_aut as linked
import df_modify as mod
import get_all as script


def script_by_filt(destinanion,origin_id,observation_type_id,accommodation_type_id):
    df_filtered = df[df.eval(f" accommodation_type_id == '{accommodation_type_id}'  and destination_id == '{destinanion}'  and origin_id == '{origin_id}' and observation_type_id == '{observation_type_id}'")]
    return [df_filtered,f"{destinanion}_{origin_id}_{observation_type_id}_{accommodation_type_id}"] 

def save_file(df,df_filtered,name):   
    #generate script
    forecaster = script.get_prediction_script(df,df_filtered)
    
    # Save model
    if name.find("AR") != -1:
        path_save = "FinTech/Predizone/generate all prediction/script/AR/"
    else:
        path_save = "FinTech/Predizone/generate all prediction/script/NI/"
    save_forecaster(forecaster, file_name=path_save+name+".py", verbose=False)

    print("all script has been generate")


def create_all_fr():
    for i in range(0,len(destinanion)):
        for j in range(0,len(origin_id)):
            for z in range(0,len(observation_type_id)):
                for d in range(0,len(observation_type_id)):
                    df_filtered = script_by_filt(destinanion[i],origin_id[j],observation_type_id[z],accommodation_type_id[d])[0]
                    name = script_by_filt(destinanion[i],origin_id[j],observation_type_id[z],accommodation_type_id[d])[1]
                    save_file(df,df_filtered,name)
    return "done"





#selection table from db
table = "observation_month_custom_view"
df  = linked.get_dataFrame_by_table(table)

# set true name of city
mod.replace_name(df)

#all values
destinanion = ['Sardenga','Sassari','Nuoro','Cagliari','Oristano','Olbia_Tempio','Ogliastra','Medio_Campidano','Carbonia_Iglesias']
origin_id = ['WORLD','IT','WRL_X_ITA']
observation_type_id = ["AR","NI"]
accommodation_type_id = ['ALL','HOTELLIKE','OTHER']

#generate all script in folder /AR and /NI
create_all_fr()


