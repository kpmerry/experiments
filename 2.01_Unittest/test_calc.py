import unittest
import calc


class TestCalc(unittest.TestCase):
    def setUp(self):
        self.pos_num = 1
        self.neg_num = -1

    def test_add(self):
        self.assertEqual(calc.add(10, 5), 15)
        self.assertEqual(calc.add(-10, 5), -5)
        self.assertEqual(calc.add(-3, -5), -8)
        self.assertEqual(calc.add(5, -5), 0)
        self.assertEqual(calc.add(self.pos_num, self.neg_num), 0)

        with self.assertRaises(TypeError):
            calc.add("ab", "f")

    def test_subtract(self):
        self.assertEqual(calc.subtract(10, 5), 5)
        self.assertEqual(calc.subtract(10, -15), 25)
        self.assertEqual(calc.subtract(-15, 10), -25)

        with self.assertRaises(TypeError):
            calc.subtract("fm", 3)

    def test_divide(self):
        self.assertEqual(calc.divide(10, 2), 5)
        self.assertEqual(calc.divide(15, 2), 7.5)
        self.assertEqual(calc.divide(10, -2), -5)

        with self.assertRaises(ZeroDivisionError):
            calc.divide(10, 0)
        with self.assertRaises(TypeError):
            calc.divide("ab", "f")

    def test_multiply(self):
        self.assertEqual(calc.multiply(10, 5), 50)

        with self.assertRaises(TypeError):
            calc.multiply("ab", "f")

    def test_triangle_area(self):
        self.assertEqual(calc.area_triangle(10, 5), 25)

        with self.assertRaises(TypeError):
            calc.area_triangle("ab", 3.4)


if __name__ == "__main__":
    unittest.main()
