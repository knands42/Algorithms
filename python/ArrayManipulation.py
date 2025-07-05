from typing import Optional


class ArrayManipulation:
    @staticmethod
    def rotate_array(arr: list[int], k: int) -> None:
        def reverse(arr: list[int], start_index: int, end_index: int) -> None:
            while start_index < end_index:
                arr[start_index], arr[end_index] = arr[end_index], arr[start_index]
                start_index += 1
                end_index -= 1 
            
        k = k % len(arr)

        reverse(arr, 0, len(arr) - 1)
        reverse(arr, 0, k - 1)
        reverse(arr, k, len(arr) - 1)

    @staticmethod
    def find_missing_number_in_a_consecutive_array(nums: list[int]) -> Optional[int, None]:
        for i in range(1, len(nums)):
            value_to_look_for = arr[i - 1] + 1
            if (value_to_look_for is not nums[i]):
                return value_to_look_for
        
        return None

    @staticmethod
    def find_intersection(nums1: list[int], nums2: list[int]) -> list[int]:
        set1 = set(nums1)
        final_result = set()
        
        for val in nums2:
            if val in set1:
                final_result.add(val)
        return list(final_result)

    @staticmethod
    def find_the_second_largest_number(numbers: list[int]) -> int:
        final_arr = []

        for i in numbers:
            final_arr.append(i)
            if len(final_arr) > 2:
                final_arr.remove(min(final_arr))

        return min(final_arr)

if __name__ == '__main__':
    arr = [1, 2, 3, 5, 6, 7]
    res = ArrayManipulation.find_the_second_largest_number(arr)
    print(res)