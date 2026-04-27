// Encode and Decode Strings
// Design an algorithm to encode a list of strings to a string and decode it back.
//
// Implement two approaches:
//   Approach 1 — Length prefix: prepend length before each string
//   Approach 2 — Delimiter-based: use special delimiter (e.g., "#") with escaping

pub struct Codec;

impl Codec {
    pub fn encode(_strs: &[String]) -> String {
        todo!("Implement length prefix encoding")
    }

    pub fn decode(_encoded: &str) -> Vec<String> {
        todo!("Implement length prefix decoding")
    }

    pub fn encode_delim(_strs: &[String]) -> String {
        todo!("Implement delimiter-based encoding")
    }

    pub fn decode_delim(_encoded: &str) -> Vec<String> {
        todo!("Implement delimiter-based decoding")
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn encode_decode_basic() {
        let strs = vec!["hello".to_string(), "world".to_string()];
        let encoded = Codec::encode(&strs);
        let decoded = Codec::decode(&encoded);
        assert_eq!(decoded, strs);
    }

    #[test]
    fn encode_decode_empty() {
        let strs: Vec<String> = vec![];
        let encoded = Codec::encode(&strs);
        let decoded = Codec::decode(&encoded);
        assert_eq!(decoded, strs);
    }

    #[test]
    fn encode_decode_special_chars() {
        let strs = vec!["#".to_string(), "".to_string(), "a#b".to_string()];
        let encoded = Codec::encode(&strs);
        let decoded = Codec::decode(&encoded);
        assert_eq!(decoded, strs);
    }

    #[test]
    fn encode_decode_delim() {
        let strs = vec!["hello".to_string(), "world".to_string()];
        let encoded = Codec::encode_delim(&strs);
        let decoded = Codec::decode_delim(&encoded);
        assert_eq!(decoded, strs);
    }
}
