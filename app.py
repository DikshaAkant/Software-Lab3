#Practical 6 : Identify vulnerabilities in code using bandit and fix them
#using Github copilot
import sqlite3

#------Code with vulnerability-------0
# def get_username(name):
#     conn = sqlite3.connect("db.sqlite")
#     cursor = conn.cursor()
#     cursor.execute("SELECT * FROM user WHERE name = _+name+_")

def get_username(name):
    conn = sqlite3.connect("db.sqlite")
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM user WHERE name = ?", (name,))
    row = cursor.fetchone()
    conn.close()
    return row

#windsurf rectified code
cursor = conn.cursor()
cursor.execute("SELECT * FROM user WHERE name = %s", (name,))  # use ? for sqlite3


