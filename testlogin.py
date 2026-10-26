
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


URL = "https://the-internet.herokuapp.com/login"


def test_login(password, expected_message, test_name):
    driver = None

    try:
        print(f"\nRunning: {test_name}")

        driver = webdriver.Chrome()
        wait = WebDriverWait(driver, 15)

        driver.get(URL)

        wait.until(
            EC.visibility_of_element_located((By.ID, "username"))
        ).send_keys("tomsmith")

        driver.find_element(By.ID, "password").send_keys(password)

        driver.find_element(
            By.CSS_SELECTOR, "button[type='submit']"
        ).click()

        message = wait.until(
            EC.visibility_of_element_located((By.ID, "flash"))
        ).text

        assert expected_message in message, (
            f"Expected '{expected_message}', got '{message}'"
        )

        print("PASS:", test_name)
        print("Verified message:", message.strip())

    except Exception as error:
        print("FAIL:", test_name)
        print("Reason:", error)
        raise

    finally:
        if driver:
            driver.quit()


if __name__ == "__main__":
    test_login(
        "SuperSecretPassword!",
        "You logged into a secure area!",
        "Valid login"
    )

    test_login(
        "WrongPassword123",
        "Your password is invalid!",
        "Invalid login"
    )

    print("\nAll Selenium tests passed!")
