
# GS DSA Practice — Stubs + Tests (Java 17)

This repository contains a curated set of **Goldman Sachs (GS) interview questions** that have been **asked from our team’s batch mates since July 2025**. It ships **method stubs with TODOs** and a **comprehensive test suite**. Your job is to implement each stub so that the tests pass.

> **Heads-up:** There will be a **forthcoming review** in which trainees will be asked to **solve a given DSA problem from scratch**, live. Be prepared to discuss approach, complexity, and edge cases.

## How to use
1. Open a stub in `src/main/java/...`, read the problem statement and edge cases.
2. Implement the method(s) marked **TODO**.
3. Run tests locally:
   ```bash
   mvn -q -DskipTests clean package
   mvn -q test
   ```
4. Iterate until all tests pass.

## About the Complexity Gate
A few tests use a small gate to approximate Big‑O via wall‑clock ratios across sizes `n`, `2n`, `4n`. It’s not a formal proof—just a practical way to catch egregiously slow solutions.

## Structure
```
src/
  main/java/com/gs/dsa/...    # stubs (you implement)
  test/java/com/gs/dsa/...    # tests (do not modify)
```

## Notes
- Stubs currently return placeholders so tests will **fail** until you implement them.
- If timing‑based gates flap on noisy machines, increase iterations per test or run with fixed heap (e.g., `-Xms512m -Xmx512m`).
