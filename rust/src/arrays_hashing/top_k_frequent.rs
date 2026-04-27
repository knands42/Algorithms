// Top K Frequent Elements
// Given an integer array nums and an integer k, return the k most frequent elements.
//
// Implement two approaches:
//   Approach 1 — HashMap + Sort: count frequencies, sort by frequency, O(n log n) time
//   Approach 2 — Bucket Sort: use frequency as index, O(n) time

pub fn top_k_frequent(_nums: &[i32], _k: i32) -> Vec<i32> {
    todo!("Implement using HashMap + Sort")
}

pub fn top_k_frequent_bucket(_nums: &[i32], _k: i32) -> Vec<i32> {
    todo!("Implement using Bucket Sort")
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn top_k_basic() {
        let result = top_k_frequent(&[1, 1, 1, 2, 2, 3], 2);
        assert_eq!(result, vec![1, 2]);
    }

    #[test]
    fn top_k_single() {
        let result = top_k_frequent(&[1], 1);
        assert_eq!(result, vec![1]);
    }

    #[test]
    fn top_k_bucket() {
        let result = top_k_frequent_bucket(&[1, 1, 1, 2, 2, 3], 2);
        assert!(result.contains(&1) && result.contains(&2));
    }
}
