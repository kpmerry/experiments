import unittest
import calc


class TestCalc(unittest.TestCase):

    def test_add(self):
        self.assertEqual(calc.add(10, 5), 15)
        self.assertEqual(calc.add(-10, 5), -5)
        self.assertEqual(calc.add(-3, -5), -8)
        self.assertEqual(calc.add(5, -5), 0)

        with self.assertRaises(ValueError):
            calc.add("ab", "f")

    def test_subtract(self):
        self.assertEqual(calc.subtract(10, 5), 5)
        self.assertEqual(calc.subtract(10, -15), 25)
        self.assertEqual(calc.subtract(-15, 10), -25)

    def test_divide(self):
        self.assertEqual(calc.divide(10, 2), 5)
        self.assertEqual(calc.divide(15, 2), 7.5)
        self.assertEqual(calc.divide(10, -2), -5)

        with self.assertRaises(ZeroDivisionError):
            calc.divide(10, 0)

    def test_multiply(self):
        self.assertEqual(calc.multiply(10, 5), 50)


if __name__ == "__main__":
    unittest.main()
