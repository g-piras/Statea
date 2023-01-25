# start env 

from flask import Flask, jsonify, request
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

from skforecast.utils import load_forecaster
import pandas as pd
import numpy as np
import json
import datetime
import time
from os import listdir
from os.path import isfile, join
from datetime import datetime, timedelta


import sys
sys.path.append("FinTech/Predizone/generate all prediction")
import load as load_py
import main as main_py

app = Flask(__name__)
#all values
path_file = 'FinTech/Predizone/generate all prediction/script/AR/'

@app.route('/prediction', methods=['POST'])
def get_pred():
    json_data = request.get_json()
    name = json_data["name"]
    if load_py.verify_exist(name) == True:
        return []
    else:
        if ".py" in name:
            print("si")
            month = json_data["quantity"]
            result = load_py.get_result(path_file,name,month)
            array_names = load_py.get_info(name)
            return jsonify(load_py.getter_main(result,array_names,month))
            
        else:
            json_data = request.get_json()
            name = json_data["name"]
            year = json_data["quantity"]
            get_num_year = load_py.get_pred_ann_17_20(name,year)
            return jsonify(load_py.getter_main_year(get_num_year,load_py.get_info(name),year))


@app.route('/update', methods=['GET'])
def update_script():
    main_py.create_all_fr()
    return "the scripts have been updated"

@app.route('/names', methods=['GET'])
def get_names():
    names = load_py.get_names_in_directory(path_file)
    return names

@app.route('/names_years', methods=['GET'])
def get_names_years():
    origin_id_year = ['AR','AT','AU','BE','BG','BR','CA','CN','CY','CZ','DE','DK','EE','EG',
    'ES','FI','FR','GR','HR','HU','IE','IL','IN','IS','IT','JP','KR','LT',
    'LU','LV','MT','MX','NL','NO','NZ','PL','PT','RO','RU','SE','SI','SK',
    'TR','US','VE','WORLD','WRL_X_ITA','ZA']
    observation_type_id = ["AR","NI"]
    accommodation_type_id = ['ALL','HOTELLIKE','OTHER']
    destination = ['ITG2','ITG28','ITG25','ITG26','IT111','ITG27','ITG29','ITG2A','ITG2B','ITG2C']
    test = []
    for i in range(0,len(destination)):
        for j in range(0,len(origin_id_year)):
            for z in range(0,len(observation_type_id)):
                for d in range(0,len(observation_type_id)):
                    test.append(f"{destination[i]}-{origin_id_year[j]}-{observation_type_id[z]}-{accommodation_type_id[d]}")
    return test


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)



