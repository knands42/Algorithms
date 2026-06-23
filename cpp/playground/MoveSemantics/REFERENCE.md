# Move Semantics & Copy Semantics — C++ Reference

A concise guide to deep copy, shallow copy, and move semantics in C++,
demonstrated through a manual `String` class implementation.

---

## Concepts Overview

### Deep Copy (Copy Constructor)

Creates an independent copy of another object's data. The new object gets
its own heap-allocated buffer and the bytes are copied over.

```
String a = "Hello";
String b = a;       // deep copy: b gets its own buffer
b[0] = 'X';         // a is unchanged — separate memory
```

In our `String` class:
```cpp
String(const String& other) : m_Size(other.m_Size) {
    m_Buffer = new char[m_Size + 1];
    memcpy(m_Buffer, other.m_Buffer, m_Size + 1);
}
```

### Shallow Copy (Pointer Sharing)

Copies the pointer directly without allocating new memory. Both objects share
the same underlying buffer.

```cpp
String(const String& other)
    : m_Buffer(other.m_Buffer)
    , m_Size(other.m_Size) {}
```

**Problem:** Double-free. When both objects are destroyed, both call
`delete[]` on the same pointer.

**Solutions:**
1. Use `std::shared_ptr<char[]>` — reference-counted, automatic cleanup
2. Disable copy entirely (`= delete`) and rely on moves
3. Implement manual reference counting (like `std::shared_ptr` pre-C++11)

### Move Constructor (Rvalue References)

Transfers ownership of resources from a temporary (rvalue) object. The source
is left in a valid but indeterminate state (typically null + zero size).

```cpp
String(String&& other) noexcept
    : m_Buffer(other.m_Buffer)
    , m_Size(other.m_Size)
{
    other.m_Buffer = nullptr;
    other.m_Size = 0;
}
```

When the compiler detects an rvalue — a temporary, or an object explicitly
marked with `std::move()` — it selects the move constructor instead of the
copy constructor. This avoids expensive heap allocation and byte copying.

---

## File Breakdown

### String.h

A minimal owning string class that demonstrates all three constructors:

| Constructor |Trigger | What happens |
|---|---|---|
| `String(const char*)` | String literal or raw C-string | Allocates buffer, copies bytes |
| `String(const String&)` | Lvalue copy (e.g., `b = a`) | Deep copy — new buffer, memcpy |
| `String(String&&)` | Rvalue/temporary (e.g., function return value) | Steals pointer, nulls source |

**Key design decisions:**
- `noexcept` on move constructor — required for STL containers to use moves during reallocation
- Moved-from object has `m_Buffer = nullptr` — destructor's `delete[]` is a no-op
- `operator[]` on const returns `char&` — allows buffer mutation through const references

### Entity.h

A class that owns a `String` and demonstrates how constructors propagate:

| Constructor | What happens |
|---|---|
| `Entity(const String& name)` | Deep-copies `name` into `m_Name` |
| `Entity(String&& name)` | Moves `name` into `m_Name` — no allocation |

When called with a temporary string literal:
```cpp
Entity entity("Hello");
```
1. `"Hello"` creates a temporary `String` (calls `String(const char*)`)
2. The temporary is an rvalue → `Entity(String&&)` is called
3. Inside: `m_Name(std::move(name))` invokes `String(String&&)` — buffer transfer
4. Temporary is destroyed — its buffer is now null, so `delete[]` does nothing

### Main.cpp

Demonstrates both concepts:

```cpp
// Deep copy: two independent buffers
const String first = "Airplane";
const String second = first;     // copy constructor
second[1] = '1';                  // first is unchanged

// Move semantics: buffer transfer
Entity entity("r-value: temporary string");  // move, no copy
```

---

## Common Pitfalls

1. **Bug in the original move constructor:** The code allocated a new buffer
   instead of stealing the pointer. A move should never allocate — that defeats
   its entire purpose.

2. **Shallow copy + raw pointer = double-free:** Without reference counting,
   two objects sharing the same pointer will crash in their destructors.

3. **Forgetting `std::move`:** `std::move()` is a cast to rvalue reference. It
   does not move anything by itself — it just enables the move constructor to
   be selected. Without it, the copy constructor is called even on rvalues in
   some contexts.

4. **Using a moved-from object:** After `String b = std::move(a)`, `a` is in a
   valid but unspecified state (null buffer, size 0). Accessing it is
   undefined behavior.

---

## Compiler-Generated Special Members

If you don't declare them, the compiler generates:

- **Copy constructor** — member-wise copy (shallow for pointers)
- **Copy assignment** — member-wise copy
- **Move constructor** — member-wise move
- **Move assignment** — member-wise move
- **Destructor** — calls destructors of members

**Rule of Five:** If you define any of these five, you likely need to define
(or `= delete`) all of them.

**Rule of Zero:** Prefer using RAII types (`std::string`, `std::unique_ptr`,
`std::vector`) so you don't need to define any of them.

---

## Quick Reference

| Scenario | Constructor called |
|---|---|
| `String a = "hi"` | `String(const char*)` |
| `String b = a` (lvalue) | `String(const String&)` — deep copy |
| `String b = std::move(a)` | `String(String&&)` — move |
| `String b = ReturnString()` | `String(String&&)` — move (or NRVO) |
| Passing by value (lvalue arg) | Copy |
| Passing by value (rvalue arg) | Move |
| `const T&` parameter | No copy, no move |
