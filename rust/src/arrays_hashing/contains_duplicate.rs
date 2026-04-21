// Contains Duplicate
// Given an integer array, return true if any value appears at least twice.
//
// Implement two approaches:
//   Approach 1 — HashSet: borrow the slice, O(n) time, O(n) space
//   Approach 2 — Sort:    mutate the slice in-place, O(n log n) time, O(1) extra space
//
// Bonus: first_duplicate — return the first value that appears more than once, if any.

use std::collections::HashSet;

pub fn contains_duplicate(nums: &[i32]) -> bool {
    todo!()
}

pub fn contains_duplicate_sort(nums: &mut [i32]) -> bool {
    todo!()
}

pub fn first_duplicate(nums: &[i32]) -> Option<i32> {
    todo!()
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

    #[test]
    fn first_duplicate_found() {
        assert_eq!(first_duplicate(&[1, 2, 3, 1, 2]), Some(1));
    }

    #[test]
    fn first_duplicate_none() {
        assert_eq!(first_duplicate(&[1, 2, 3]), None);
    }
}
