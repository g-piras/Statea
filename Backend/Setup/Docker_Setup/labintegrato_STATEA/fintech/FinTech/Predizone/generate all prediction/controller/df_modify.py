import pandas as pd

# Change province codes to their real names
def replace_city_name(origin,new,df):
    df.destination_id.replace(origin, new, inplace=True)
    
def replace_name(df):
  replace_city_name("ITG2","Sardenga",df)
  replace_city_name("ITG25","Sassari",df)
  replace_city_name("ITG27","Cagliari",df)
  replace_city_name("ITG28","Oristano",df)
  replace_city_name("ITG29","Olbia_Tempio",df)
  replace_city_name("ITG2A","Ogliastra",df)
  replace_city_name("ITG2B","Medio_Campidano",df)
  replace_city_name("ITG26","Nuoro",df)
  replace_city_name("ITG2C","Carbonia_Iglesias",df)

# Date selection
def filter_by_date(df,start,end):
  start_date = pd.to_datetime(f"{start}")
  end_date = pd.to_datetime(f"{end}")
  df_selection = df.loc[(df['date'] >= start_date) & (df['date'] <= end_date)]
  return df_selection
