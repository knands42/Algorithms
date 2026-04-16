//! # Rust Deep Dive
//!
//! Exercise-focused Rust learning through building small systems.
//! Each module teaches one concept by constructing something concrete
//! — not isolated puzzle functions, but coherent mini-systems with tests
//! that act as both specification and exercise.
//!
//! ## How to use
//!
//! 1. Open a module, read its `//!` doc block first.
//! 2. Read the implementation top-to-bottom — later items build on earlier ones.
//! 3. Run just that module's tests: `cargo test ownership`
//! 4. The `// EXERCISE` comments at the bottom of each file are your homework.
//!
//! ## Modules — recommended learning order
//!
//! | # | Module             | Builds                   | Teaches                              |
//! |---|--------------------|--------------------------|--------------------------------------|
//! | 1 | `ownership`        | `LogBuffer`              | move, borrow, &mut, drop             |
//! | 2 | `lifetimes`        | `TextAnalyzer`           | lifetime annotations, why they exist |
//! | 3 | `collections`      | `TaskManager`            | Vec/HashMap/BTreeMap/VecDeque        |
//! | 4 | `enums`            | connection state machine | algebraic types, exhaustive match    |
//! | 5 | `error_handling`   | config file parser       | Result, ?, custom errors             |
//! | 6 | `traits`           | notifier system          | dyn vs impl, dispatch cost           |
//! | 7 | `iterators`        | log analysis pipeline    | lazy eval, adapters, custom Iterator |
//! | 8 | `closures`         | middleware pipeline       | Fn/FnMut/FnOnce, capture             |
//! | 9 | `smart_pointers`   | BST + shared graph       | Box, Rc, Arc, RefCell, Weak          |
//! |10 | `concurrency`      | thread pool + cache      | threads, channels, Mutex, RwLock     |

pub mod ownership;
pub mod lifetimes;
pub mod collections;
pub mod enums;
pub mod error_handling;
pub mod traits;
pub mod iterators;
pub mod closures;
pub mod smart_pointers;
pub mod concurrency;
