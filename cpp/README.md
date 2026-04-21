# C++ Algorithms

Implements NeetCode 150 problems, but with **multiple versions** per exercise — exploring different C++ approaches and trade-offs.

## Structure

```
cpp/src/
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
cd cpp
g++ -std=c++20 -o test src/**/*.cpp && ./test
```

Optional: CMakeLists.txt or Catch2.

## Code Style

- Default: C++20
- Prefer `<algorithm>`, standard containers
- Comment why each approach differs

## Constraints

- No external libraries (std only)
- For each problem, implement multiple versions showing different but keep using the latest C++ version:
- Data structures (array vs vector vs unordered_set)
- Memory models (in-place vs allocate)
- STL usage (manual loops vs algorithms library)
- Implement a bonus use case for more real-world applications (It can be slightly more complex than the main problem)
- Document trade-offs: readability, performance, memory, compile time on the same file exercise either as a header or footer note (or per approach).
