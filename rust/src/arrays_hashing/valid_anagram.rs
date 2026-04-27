// Valid Anagram
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//
// Implement two approaches:
//   Approach 1 — HashMap: count character frequencies, O(n) time, O(1) space (bounded)
//   Approach 2 — Sort: sort both strings and compare, O(n log n) time, O(1) extra space

use std::collections::hash_map::Entry;
use std::collections::HashMap;

pub fn is_anagram(s: &str, t: &str) -> bool {
    let mut seen: HashMap<char, u8> = HashMap::new();
    
    for c in s.chars() {
        seen.entry(c).and_modify(|v| *v += 1).or_insert(1);
    }

    for c in t.chars() {
        match seen.entry(c) {
            Entry::Vacant(_) => return false,
            Entry::Occupied(mut data) => {
                *data.get_mut() -= 1;
                if *data.get() == 0 {
                    data.remove();
                }
            }
        }
    }

    if !seen.is_empty() {
        return false;
    }

    true
}

pub fn is_anagram_sort(s: &mut String, t: &mut String) -> bool {
    let mut s_chars: Vec<char> = s.chars().collect();
    let mut t_chars: Vec<char> = t.chars().collect();
    
    s_chars.sort();
    t_chars.sort();
    
    s_chars == t_chars
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn is_anagram_true() {
        assert!(is_anagram("anagram", "nagaram"));
    }

    #[test]
    fn is_anagram_false() {
        assert!(!is_anagram("rat", "car"));
    }

    #[test]
    fn is_anagram_sort_true() {
        let mut s = "anagram".to_string();
        let mut t = "nagaram".to_string();
        assert!(is_anagram_sort(&mut s, &mut t));
    }

    #[test]
    fn is_anagram_sort_false() {
        let mut s = "rat".to_string();
        let mut t = "car".to_string();
        assert!(!is_anagram_sort(&mut s, &mut t));
    }
}
