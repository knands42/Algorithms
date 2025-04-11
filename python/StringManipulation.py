class StringManipulation:
    @staticmethod
    def reverse_string(text: str) -> str:
        left_pointer = 0
        right_pointer = len(text) - 1

        while left_pointer < right_pointer:
            text = list(text)
            text[left_pointer], text[right_pointer] = text[right_pointer], text[left_pointer]
            left_pointer += 1
            right_pointer -= 1
        
        return ''.join(text)

    @staticmethod
    def remove_duplicates(text: str) -> str:
        seen = set()
        result = []

        for char in text:
            if char not in seen:
                seen.add(char)
                result.append(char)
        
        return ''.join(result)
    
    @staticmethod
    def has_duplicates(text: str) -> bool:
        seen = set()

        for char in text:
            if char not in seen:
                seen.add(char)
            else:
                return True
        
        return False
        # return len(text) != len(set(text))
    
if __name__ == '__main__':
    import unittest

    class TestStringManipulation(unittest.TestCase):
        def test_has_duplicates(self):
            self.assertFalse(StringManipulation.has_duplicates("abc"))
            self.assertTrue(StringManipulation.has_duplicates("aab"))
            self.assertFalse(StringManipulation.has_duplicates(""))
            self.assertTrue(StringManipulation.has_duplicates("  "))  # spaces are duplicates
            self.assertFalse(StringManipulation.has_duplicates("a b"))  # spaces are different from letters

    unittest.main()