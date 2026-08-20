import sqlite3
import secrets

conn = sqlite3.connect("DB.sqlite")
cursor = conn.cursor()

name = "Krishna"

query = "SELECT * FROM user WHERE name = ?"
cursor.execute(query, (name,))

otp = secrets.randbelow(900000) + 100000

print("OTP:", otp)

conn.close()
