from skforecast.utils import load_forecaster
import pandas as pd
import numpy as np
import json
import datetime
import time
from os import listdir
from os.path import isfile, join


def convert_date(date_s):
    date_time = datetime.datetime.fromtimestamp(date_s/1000.0)
    date_time = date_time.strftime("%d/%m/%Y")
    return date_time

def create_json(result):
    json_obj = result.to_json()
    # write the json object to a file
    with open("data.json", "w") as outfile:
        json.dump(json_obj, outfile)
    # print(json_obj)
    obj_con = json.loads(json_obj)
    # print(obj_con)
    return obj_con



def get_array_date(result):
    obj_json = create_json(result)
    date = []
    date_conv = []
    for x in obj_json:
        # print(x)
        date.append(x)
    # print(date)
    for x in date:
        date_conv.append(convert_date(float(x)))
    return date_conv
        
    
def add_values_date(result,true_js):
    array_date = get_array_date(result)
    for x in array_date:
        true_js["date"].append(x)
    print("date is added")


def add_value(result,true_js):
    for x in range(0,len(result)):
        true_js["value"].append(result[x])
    print("value is added")
        

def get_json(result,name):
    test = {
    "name": name,
    "error": "unknown",
    "date": [],
    "value" : []
    }
    add_values_date(result,test)
    add_value(result,test)
    print(test)




def get_prediction_json(path_file,name,num_month):
    #load 
    forecaster_loaded = load_forecaster(path_file+name)
    # Predict
    result = forecaster_loaded.predict(steps=num_month)
    get_json(result,name)

    return


def get_name_file(path):
    onlyfiles = [f for f in listdir(path) if isfile(join(path, f))]
    return onlyfiles



path_file = 'FinTech/Predizone/generate all prediction/script/AR/'
name = "Sassari_IT_AR_HOTELLIKE"

#print all json
for x in range (0,len(get_name_file(path_file))):
    get_prediction_json(path_file,get_name_file(path_file)[x],10)


