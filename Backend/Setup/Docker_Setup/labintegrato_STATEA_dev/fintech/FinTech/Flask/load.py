from skforecast.utils import load_forecaster
import pandas as pd
import numpy as np
import json
import datetime
import time
import os
from os import listdir
from os.path import isfile, join
from datetime import datetime, timedelta
import sys
sys.path.append("FinTech/Predizone/generate all prediction/controller")
import get_all as script #this generate forecast



def create_date_array(num_months):
    start_date = pd.to_datetime("2023-01-01")
    end_date = start_date + pd.DateOffset(months=num_months)
    date_range = pd.date_range(start=start_date, end=end_date, freq='MS')
    return [date.strftime("%Y-%m-%d") for date in date_range]



#convert date type from secondo to more read date
def convert_date(date_s):
    date_time = datetime.datetime.fromtimestamp(date_s/1000.0)
    date_time = date_time.strftime("%Y-%m-%d")
    return date_time

#create a obj from  forecast result for use this to create a json
def create_json_date(result):
    json_obj = result.to_json()
    # write the json object to a file
    with open("data.json", "w") as outfile:
        json.dump(json_obj, outfile)
    # print(json_obj)
    obj_con = json.loads(json_obj)
    # print(obj_con)
    return obj_con


#convert date to array for to make it easier
def get_array_date(result):
    obj_json = create_json_date(result)
    date = []
    date_conv = []
    for x in obj_json:
        # print(x)
        date.append(x)
    # print(date)
    for x in date:
        date_conv.append(convert_date(float(x)))
    return date_conv
        
#get name from directory where are the files
def get_name_file(path):
    onlyfiles = [f for f in listdir(path) if isfile(join(path, f))]
    return onlyfiles


# load forecast from file
def get_result(path_file,name,num_month):
    #load 
    forecaster_loaded = load_forecaster(path_file+name)
    # Predict
    result = forecaster_loaded.predict(steps=num_month)
    return result



# get json with all information orgin destinanion.....
def get_info(name):
    name = name.replace(".py", "")
    data_array = name.split("-")
    return data_array
    
# get json final for api 
def getter_main(result,array_names,start_date):
    final_json = []
    for x in range(0,len(result)):
        json_file = {
        "destination": array_names[0],
        "origin_id": array_names[1],
        "observation_type_id": array_names[2],
        "accommodation_type_id": array_names[3]
        }
        json_file["value"] = result[x]
        json_file["date"] = create_date_array(start_date)[x]
        print("value is added")
        print(json_file)
        final_json.append(json_file) 
    return final_json


def get_names_in_directory(directory):
    files = os.listdir(directory)
    return files





################################################################################################

def generate_date_yeaer(start, steps):
    return [start + i for i in range(steps)]


def get_pred_ann_17_20(names,steps):
    #testing
    ab = (get_info(names))
    query = (f" accommodation_type_id == '{ab[3]}'  and destination_id == '{ab[0]}'  and origin_id == '{ab[1]}' and observation_type_id == '{ab[2]}'")
    flag = 2023
    result = []
    for x in range(0,steps):
        x_test = [[flag]]
        if names.find("ITG27") != -1 or names.find("ITG29") != -1 or names.find("ITG2A") != -1 or names.find("ITG2B") != -1 or names.find("ITG2C") != -1:
            y_pred = script.pred_ann_08_17(query).predict(x_test)
        elif names.find("ITG25") != -1 or names.find("ITG26") != -1 or names.find("IT111") != -1:
            y_pred = script.pred_ann_17_20(query).predict(x_test)
        else:
            y_pred = script.pred_ann_08_20(query).predict(x_test)
        result.append(y_pred[0])
        flag = flag+1
        # print(y_pred)
    return result




# get json final for api 
def getter_main_year(result,array_names,steps):
    final_json = []
    for x in range(0,len(result)):
        json_file = {
        "destination": array_names[0],
        "origin_id": array_names[1],
        "observation_type_id": array_names[2],
        "accommodation_type_id": array_names[3]
        }
        json_file["value"] = result[x]
        final_json.append(json_file) 
        json_file["value"] = result[x]
        json_file["date"] = generate_date_yeaer(2023,steps)[x]
        print("value is added")
    return final_json


names = "ITG2B-KR-AR-ALL"
# get_num_year = (get_pred_ann_17_20(names,5))
# print(getter_main_year(get_num_year,get_info(names)))


def verify_exist(names):
    ab = (get_info(names))
    query = (f" accommodation_type_id == '{ab[3]}'  and destination_id == '{ab[0]}'  and origin_id == '{ab[1]}' and observation_type_id == '{ab[2]}'")
    result = script.get_df_to_check(query)
    return result




