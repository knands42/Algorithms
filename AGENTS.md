# AGENTS.md

## Project Structure
- Multi-language algorithm implementations under `/`
- Each language in own directory: `python/`, `go/`, `jvm-langs/`, `rust/`, `cpp/`
- 15 algorithm categories (NeetCode 150): Arrays & Hashing, Two Pointers, Sliding Window, Stack, Binary Search, Linked List, Trees, Tries, Heap, Backtracking, Graphs, 1-D DP, 2-D DP, Greedy, Bit Manipulation

## Running Tests
Can be located in their respective READMEs.
- [@rust_running_tests](rust/README.md#running-tests)
- [@cpp_running_tests](cpp/README.md#running-tests)

### Quick Reference

```
go/      cd go && go test ./...
jvm-langs cd jvm-langs && ./gradlew test
rust     cd rust && cargo test
python   cd python && pytest  # or python -m unittest
```

## Language-Specific Notes

Can be located in their respective READMEs.
- [@rust_constraints](rust/README.md#constraints)
- [@cpp_constraints](cpp/README.md#constraints)

## Learning Approach
- **All Languages**: Learn by algorithm category (NeetCode 150); each exercise has a bonus use case
- Follow per-language README for specific constraints

## Teaching & Coaching Style

1. **Give hints and skeleton code** — not complete solutions.
2. **Give tests** prior to implementation.
2. **Review submissions** when the user says they're done with a milestone.
3. **Point out all issues** (minor and major) but only advance to the next milestone when there are no blockers (minor style issues are fine to note and leave).
