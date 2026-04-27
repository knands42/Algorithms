// Longest Consecutive Sequence
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//
// Implement two approaches:
//   Approach 1 — HashSet: put all numbers in set, then iterate checking for sequence starts, O(n) time, O(n) space
//   Approach 2 — Sort first: O(n log n) time, O(1) extra space

pub fn longest_consecutive(_nums: &[i32]) -> i32 {
    todo!("Implement using HashSet approach")
}

pub fn longest_consecutive_sort(_nums: &mut [i32]) -> i32 {
    todo!("Implement using Sort approach")
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn longest_basic() {
        assert_eq!(longest_consecutive(&[100, 4, 200, 1, 3, 2]), 4);
    }

    #[test]
    fn longest_empty() {
        assert_eq!(longest_consecutive(&[]), 0);
    }

    #[test]
    fn longest_single() {
        assert_eq!(longest_consecutive(&[1]), 1);
    }

    #[test]
    fn longest_sort() {
        let mut nums = vec![100, 4, 200, 1, 3, 2];
        assert_eq!(longest_consecutive_sort(&mut nums), 4);
    }
}
