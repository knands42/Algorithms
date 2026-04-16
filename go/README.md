# Go Algorithms Implementation

This directory contains Go implementations of fundamental algorithms and data structures following the project roadmap. Go is chosen for its efficiency, strong typing, and excellent concurrency support.

## Go-Specific Guidelines

### Package Structure
- Each algorithm category has its own package (strings, arrays, stacks, sets, maps)
- Use Go's package naming conventions (lowercase, single word when possible)
- Export functions start with uppercase letters, unexported with lowercase

### Testing
- Use Go's built-in `testing` package
- Test files should be named `*_test.go` in the same package
- Run tests with `go test ./...` from the go directory
- Aim for high test coverage with edge cases

### Code Style
- Follow `gofmt` formatting (run `gofmt ./...` before committing)
- Use meaningful variable names, avoid abbreviations
- Add comprehensive comments explaining algorithm logic and complexity
- Include time and space complexity in function comments

### Performance Considerations
- Leverage Go's strong typing for efficient memory usage
- Use slices and maps appropriately for different use cases
- Consider goroutines for parallelizable algorithms
- Profile with `go test -bench` for performance-critical code

## Running the Code

### Testing All Implementations
```bash
cd go
go test ./...
```

### Running Specific Tests
```bash
go test ./arrays
go test ./strings
```

### Building and Running
```bash
go build ./...
go run main.go  # if there's a main package
```

