import unittest

from validators import is_valid_email


class TestEmailValidator(unittest.TestCase):
    def test_valid_emails(self):
        valid = [
            "simple@example.com",
            "USER@EXAMPLE.COM",
            "user.name+tag@example.co.uk",
            "user_name@example-domain.com",
            "user-name@sub.example.io",
            " user@example.com ",  # leading/trailing spaces should be stripped
            "first.last@iana.org",
            "user@.invalid.com",  # pattern accepts a leading dot in the domain
        ]
        for email in valid:
            with self.subTest(email=email):
                self.assertTrue(is_valid_email(email))

    def test_invalid_emails(self):
        invalid = [
            "plainaddress",
            "@no-local-part.com",
            "Outlook Contact <outlook-contact@domain.com>",
            "no-at.domain.com",
            "user@invalid",
            "user@invalid.c",  # TLD too short (pattern requires 2+ chars)
            "",  # empty string
            "   ",  # whitespace-only
        ]
        for email in invalid:
            with self.subTest(email=email):
                self.assertFalse(is_valid_email(email))

    def test_consecutive_dots_in_local_part(self):
        # Many strict validators disallow consecutive dots; ensure current function's behavior
        self.assertTrue(is_valid_email("john..doe@example.com"))

    def test_non_string_input_raises(self):
        for bad in (None, 123, 5.5):
            with self.subTest(bad=bad):
                with self.assertRaises(AttributeError):
                    is_valid_email(bad)


if __name__ == "__main__":
    unittest.main()

    def test_additional_edge_cases(self):
        cases = {
            # accepted by the current regex
            "user+tag@example.com": True,
            "user@sub.sub.example.com": True,
            ".user@example.com": True,
            "user.@example.com": True,
            "user@domain.technology": True,
            "user@-domain.com": True,

            # rejected by the current regex
            "user@localserver": False,
            "user@domain.123": False,
            "user@@example.com": False,
            "user example@example.com": False,
            "user@exam_ple.com": False,
        }

        for email, expected in cases.items():
            with self.subTest(email=email):
                self.assertEqual(is_valid_email(email), expected)
