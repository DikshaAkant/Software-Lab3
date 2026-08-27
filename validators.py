import re


def is_valid_email(email: str) -> bool:
    """Validate email format using regular expressions."""
    # Pattern for standard email format username@domain.extension
    pattern = r"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$"

    # re.match checks if the string matches the pattern from the beginning
    return bool(re.match(pattern, email.strip()))


# --- Main Program ---
if __name__ == "__main__":
    user_email = input("Enter an email address: ")

    if is_valid_email(user_email):
        print(f"'{user_email}' is a valid email address.")
    else:
        print(f"'{user_email}' is NOT a valid email address.")