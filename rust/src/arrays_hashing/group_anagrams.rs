// Group Anagrams
// Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
// Implement two approaches:
//   Approach 1 — HashMap with sorted string key: O(n * k log k) time where k is max string length
//   Approach 2 — HashMap with character count (26 letters): O(n * k) time

use std::collections::HashMap;

pub fn group_anagrams(strs: &[String]) -> Vec<Vec<String>> {
    let result = Vec::new();
    let anagram_store = HashMap::<char, Vec<char>>::new();

    for group in strs {
        let mut chars: Vec<char> = group.chars().collect();
        chars.sort();

        anagram_store.entry(chars)
    }

    result
}

pub fn group_anagrams_count(_strs: &[String]) -> Vec<Vec<String>> {
    todo!("Implement using character count approach")
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn group_anagrams_basic() {
        let strs = vec![
            "eat".to_string(),
            "tea".to_string(),
            "tan".to_string(),
            "ate".to_string(),
            "nat".to_string(),
            "bat".to_string(),
        ];
        let result = group_anagrams(&strs);
        assert_eq!(result.len(), 3);
    }

    #[test]
    fn group_anagrams_empty() {
        let strs: Vec<String> = vec![];
        let result = group_anagrams(&strs);
        assert!(result.is_empty());
    }

    #[test]
    fn group_anagrams_single() {
        let strs = vec!["a".to_string()];
        let result = group_anagrams(&strs);
        assert_eq!(result.len(), 1);
    }

    #[test]
    fn group_anagrams_count_basic() {
        let strs = vec![
            "eat".to_string(),
            "tea".to_string(),
            "tan".to_string(),
            "ate".to_string(),
            "nat".to_string(),
            "bat".to_string(),
        ];
        let result = group_anagrams_count(&strs);
        assert_eq!(result.len(), 3);
    }
}
