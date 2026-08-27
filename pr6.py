import os
import shlex
import sqlite3
from pathlib import Path


# Prefer environment variables over hardcoded secrets in production.
app_password = os.environ.get("APP_PASSWORD")


def find_user(username):
    conn = sqlite3.connect("users.db")
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM users WHERE username = ?", (username,))
    rows = cursor.fetchall()
    conn.close()
    return rows


def run_command(user_input):
    if not user_input:
        raise ValueError("Command cannot be empty.")

    parts = shlex.split(user_input)
    allowed_commands = {"echo", "date", "whoami"}

    if not parts or parts[0] not in allowed_commands:
        raise ValueError("Command is not allowed.")

    # Do not execute arbitrary commands from user input.
    # This function only validates that the requested command is in the allowlist.
    return {"command": parts[0], "args": parts[1:]}


def read_file(filename):
    base_dir = Path("uploads").resolve()
    safe_path = (base_dir / filename).resolve()

    try:
        safe_path.relative_to(base_dir)
    except ValueError:
        raise ValueError("Invalid file path.")

    if not safe_path.is_file():
        raise FileNotFoundError(f"File not found: {filename}")

    return safe_path.read_text(encoding="utf-8")


username = input("Username: ")
print(find_user(username))

command = input("Command: ")
print(run_command(command))

filename = input("Filename: ")
print(read_file(filename))