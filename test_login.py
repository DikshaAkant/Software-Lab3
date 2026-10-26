from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


BASE_URL = "https://the-internet.herokuapp.com/login"


def open_login_page():
    options = Options()
    options.add_argument("--start-maximized")
    driver = webdriver.Chrome(options=options)
    wait = WebDriverWait(driver, 10)

    driver.get(BASE_URL)
    wait.until(EC.visibility_of_element_located((By.ID, "username")))
    wait.until(EC.visibility_of_element_located((By.ID, "password")))

    return driver, wait


def test_successful_login():
    driver, wait = open_login_page()

    try:
        driver.find_element(By.ID, "username").send_keys("tomsmith")
        driver.find_element(By.ID, "password").send_keys("SuperSecretPassword!")
        driver.find_element(By.CSS_SELECTOR, "button[type='submit']").click()

        success_message = wait.until(EC.visibility_of_element_located((By.CLASS_NAME, "flash")))
        assert "You logged into a secure area!" in success_message.text
        assert "secure" in driver.current_url.lower()
    finally:
        driver.quit()


def test_invalid_password():
    driver, wait = open_login_page()

    try:
        driver.find_element(By.ID, "username").send_keys("tomsmith")
        driver.find_element(By.ID, "password").send_keys("wrongpassword")
        driver.find_element(By.CSS_SELECTOR, "button[type='submit']").click()

        error_message = wait.until(EC.visibility_of_element_located((By.ID, "flash")))
        assert "Your password is invalid!" in error_message.text
        assert "login" in driver.current_url.lower()
    finally:
        driver.quit()


if __name__ == "__main__":
    test_successful_login()
    test_invalid_password()
    print("All login tests passed.")
