import os
import sqlite3
from getpass import getpass

conn = sqlite3.connect("DB.sqlite")
cursor = conn.cursor()

name = "Krishna"
password = os.environ.get("APP_PASSWORD") or getpass("Enter password: ")

query = "SELECT * FROM user WHERE name = ? AND password = ?"
cursor.execute(query, (name, password))

row = cursor.fetchone()

if row:
    print("Login successful for:", name)
else:
    print("Invalid username or password")

conn.close()
