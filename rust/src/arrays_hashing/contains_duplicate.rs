// Contains Duplicate
// Given an integer array, return true if any value appears at least twice.
//
// Implement two approaches:
//   Approach 1 — HashSet: borrow the slice, O(n) time, O(n) space
//   Approach 2 — Sort:    mutate the slice in-place, O(n log n) time, O(1) extra space
use std::collections::HashSet;

pub fn contains_duplicate(nums: &[i32]) -> bool {
    let mut seen: HashSet<&i32> = HashSet::new();

    for num in nums {
        if seen.contains(num) {
            return true;
        }
        seen.insert(num);
    }

    false
}

pub fn contains_duplicate_sort(nums: &mut [i32]) -> bool {
    nums.sort();

    for i in 1..(nums.len() - 1) {
        if nums[i] == nums[i - 1] {
            return true;
        }
    }

    false
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn has_duplicate() {
        assert!(contains_duplicate(&[1, 2, 3, 1]));
    }

    #[test]
    fn no_duplicate() {
        assert!(!contains_duplicate(&[1, 2, 3, 4]));
    }

    #[test]
    fn single_element() {
        assert!(!contains_duplicate(&[1]));
    }

    #[test]
    fn empty() {
        assert!(!contains_duplicate(&[]));
    }

    #[test]
    fn sort_approach_duplicate() {
        assert!(contains_duplicate_sort(&mut [1, 2, 3, 1]));
    }

    #[test]
    fn sort_approach_unique() {
        assert!(!contains_duplicate_sort(&mut [1, 2, 3, 4]));
    }
}
