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


# import my function from "FinTech/Predizone/generate all prediction/controller"
import db_function_aut as linked # this use for link to database
import df_modify as mod #this use for modding dataframe
import get_all as script #this generate forecast


# set filtrarion "mask" for use a particolar coloumns from dataframe
def script_by_filt(destination,origin_id,observation_type_id,accommodation_type_id):
    df_filtered = df[df.eval(f" accommodation_type_id == '{accommodation_type_id}'  and destination_id == '{destination}'  and origin_id == '{origin_id}' and observation_type_id == '{observation_type_id}'")]
    return [df_filtered,f"{destination}-{origin_id}-{observation_type_id}-{accommodation_type_id}"] 

# save forecast in a particolar directory
def save_file(df,df_filtered,name,flag):   
    if flag == 1:
        #generate script with file  from "FinTech/Predizone/generate all prediction/controller/get_all.py"
        forecaster = script.get_prediction_scriptSAR(df,df_filtered)
    elif flag == 2:
        forecaster = script.get_prediction_scriptSAS(df,df_filtered)
    elif flag == 3:
        forecaster = script.get_prediction_scriptCAGLI(df,df_filtered)
    # Save model
    if name.find("AR") != -1:
        path_save = "FinTech/Predizone/generate all prediction/script/AR/"
    else:
        path_save = "FinTech/Predizone/generate all prediction/script/NI/"
    save_forecaster(forecaster, file_name=path_save+name+".py", verbose=False)

    print("all script has been generate")

# creates all combinations of script
def create_all_fr_by_flags(destination,flag):
    for i in range(0,len(destination)):
        for j in range(0,len(origin_id)):
            for z in range(0,len(observation_type_id)):
                for d in range(0,len(observation_type_id)):
                    df_filtered = script_by_filt(destination[i],origin_id[j],observation_type_id[z],accommodation_type_id[d])[0]
                    name = script_by_filt(destination[i],origin_id[j],observation_type_id[z],accommodation_type_id[d])[1]
                    save_file(df,df_filtered,name,flag)
    return "done"


def create_all_fr():
    destination1 = ['ITG2','ITG28']
    destination2 = ['ITG25','ITG26','IT111']
    destination3 = ['ITG27','ITG29','ITG2A','ITG2B','ITG2C']
    flag = [1,2,3]
    create_all_fr_by_flags(destination1,flag[0])
    create_all_fr_by_flags(destination2,flag[1])
    create_all_fr_by_flags(destination3,flag[2])
    return "done"




#selection table from db
table = "observation_month_custom_view"
df  = linked.get_dataFrame_by_table(table)

# set true name of city, but isn t necessary
#mod.replace_name(df)

#all values

origin_id = ['WORLD','IT','WRL_X_ITA']
origin_id_year = ['AR','AT','AU','BE','BG','BR','CA','CN','CY','CZ','DE','DK','EE','EG'
 'ES','FI','FR','GR','HR','HU','IE','IL','IN','IS','IT','JP','KR','LT'
 'LU','LV','MT','MX','NL','NO','NZ','PL','PT','RO','RU','SE','SI','SK'
 'TR','US','VE','WORLD','WRL_X_ITA','ZA']
observation_type_id = ["AR","NI"]
accommodation_type_id = ['ALL','HOTELLIKE','OTHER']


