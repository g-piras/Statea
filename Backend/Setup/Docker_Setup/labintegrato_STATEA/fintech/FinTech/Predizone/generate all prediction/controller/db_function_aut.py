import mysql.connector
import pandas as pd

# Function to connect to the database
def connector():
  mydb = mysql.connector.connect(
  host="db",
  user = "stateadb_read",
  password = "kS4YSErXgO8A*ssJ",
  port="3306",
  database="stateadb"
  )
  
  return mydb

# function to receive data from a specific table
def get_table_By_name(name):
  
  mydb = connector()
  mycursor = mydb.cursor()
  name_table = name
  mycursor.execute(f"SELECT * FROM {name_table}")

  myresult = mycursor.fetchall()

  return myresult

def get_table_name(name):
  mydb = connector()
  mycursor = mydb.cursor()
  name_table = name
  name_database = 'stateadb'
  query = f"SELECT column_name FROM information_schema.columns WHERE table_name = '{name_table}' AND table_schema = '{name_database}'"
  # Query execution
  mycursor.execute(query)
  # Extraction of results
  columns = [column[0] for column in mycursor]
  return columns

# Transfer data from the database into a dataframe
def get_dataFrame_by_table(name):
  df = pd.DataFrame(get_table_By_name(name))
  df.columns =get_table_name(name)
  return df


df = get_dataFrame_by_table("observation_month")



#TESTING: ---
# print(df)
