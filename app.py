import sqlite3

conn = sqlite3.connect("DB.sqlite")
cursor = conn.cursor()

name = "Krishna"

query = "SELECT * FROM user WHERE name = ?"
cursor.execute(query, (name,))

for row in cursor:
    print(row)

conn.close()
