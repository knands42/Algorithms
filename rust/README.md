# Rust Algorithms

Exercise-focused Rust learning through implementing NeetCode 150 problems. Each exercise has a main problem and a bonus use case that adds slight complexity using the same technique.

## Structure

```
rust/src/
├── arrays_hashing/
├── two_pointers/
├── sliding_window/
├── stack/
├── binary_search/
├── linked_list/
├── trees/
├── tries/
├── heap/
├── backtracking/
├── graphs/
├── dp_1d/
├── dp_2d/
├── greedy/
└── bit_manipulation/
```

## Exercises by Category

Please refer to the root [README.md](../README.md) for the list of exercises.

## Running Tests

```bash
cd rust
cargo test              # all tests
cargo test <module>    # specific category
cargo test --release  # optimized
```

## Constraints

- No external dependencies (std only)
- No `unsafe` blocks
- For each exercise, show multiple approaches using different:
  - **Ownership/borrowing**: Use owned data (`String`) vs borrowed (`&str`)
  - ...
- Implement a bonus use case for more real-world applications (slightly more complex)
- Document trade-offs: readability, performance, memory as comments in the same file
