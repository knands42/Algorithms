// Product of Array Except Self
// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//
// Implement two approaches:
//   Approach 1 — Prefix/Suffix arrays: O(n) time, O(n) space
//   Approach 2 — O(1) extra space (constant space): use output array for both prefix and suffix

pub fn product_except_self(_nums: &[i32]) -> Vec<i32> {
    todo!("Implement using Prefix/Suffix arrays (O(n) space)")
}

pub fn product_except_self_const(_nums: &[i32]) -> Vec<i32> {
    todo!("Implement with O(1) extra space")
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn product_basic() {
        let result = product_except_self(&[1, 2, 3, 4]);
        assert_eq!(result, vec![24, 12, 8, 6]);
    }

    #[test]
    fn product_with_zeros() {
        let result = product_except_self(&[1, 2, 0, 4]);
        assert_eq!(result, vec![0, 0, 8, 0]);
    }

    #[test]
    fn product_const_basic() {
        let result = product_except_self_const(&[1, 2, 3, 4]);
        assert_eq!(result, vec![24, 12, 8, 6]);
    }
}
