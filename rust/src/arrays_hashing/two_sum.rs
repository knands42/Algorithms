// Two Sum
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
// Implement two approaches:
//   Approach 1 — HashMap: store complements, O(n) time, O(n) space
//   Approach 2 — Brute Force: nested loops, O(n^2) time, O(1) extra space

pub fn two_sum(_nums: &[i32], _target: i32) -> Vec<i32> {
    todo!("Implement using HashMap approach")
}

pub fn two_sum_brute(_nums: &[i32], _target: i32) -> Vec<i32> {
    todo!("Implement using Brute Force")
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn two_sum_basic() {
        let result = two_sum(&[2, 7, 11, 15], 9);
        assert_eq!(result, vec![0, 1]);
    }

    #[test]
    fn two_sum_diff_indices() {
        let result = two_sum(&[3, 2, 4], 6);
        assert_eq!(result, vec![1, 2]);
    }

    #[test]
    fn two_sum_no_match() {
        let result = two_sum(&[3, 3], 6);
        assert_eq!(result, vec![0, 1]);
    }

    #[test]
    fn two_sum_brute_basic() {
        let result = two_sum_brute(&[2, 7, 11, 15], 9);
        assert_eq!(result, vec![0, 1]);
    }
}
