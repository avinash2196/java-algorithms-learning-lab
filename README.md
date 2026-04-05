# java-algorithms-learning-lab

> **This repository is intended for learning, experimentation, and reference purposes. It is not designed as a production-grade system.**

A structured collection of Java solutions to LeetCode problems, organized by difficulty level. Each solution is annotated with time/space complexity, algorithmic reasoning, and real-world context to make the patterns easier to internalize and apply.

---

## Overview

**What this project does**  
Provides clean, well-commented Java implementations of 116 algorithm and data-structure problems across three difficulty tiers: Easy, Medium, and Hard. Problems are drawn from the Meta (Facebook) interview track and cover the most commonly tested patterns.

**Why this matters in real-world systems**  
The problems here are not academic exercises. Hash maps, LRU caches, BFS/DFS traversals, dynamic programming, and topological sort all appear directly in production systems — from database engines and operating system schedulers to recommendation engines and distributed task queues.

---

## Real-World Context

| Pattern | Where it appears in production |
|---|---|
| Hash-based lookup (Two Sum) | Database index scans, deduplication pipelines |
| LRU Cache | Redis eviction, OS page replacement, CDN edge caches |
| Topological Sort (Course Schedule) | Build systems (Make, Gradle), CI/CD pipelines, package managers |
| BFS shortest path (Word Ladder) | Network routing, social graph traversal, spell checkers |
| Two-pointer (Trapping Water) | Stream processing, sliding-window analytics |
| Dynamic Programming (Word Break, Climb Stairs) | NLP tokenization, resource scheduling, route optimization |
| Heap-based median (MedianFinder) | Real-time percentile tracking (p50/p99 latency dashboards) |

---

## What This Repo Demonstrates

- **Core data structures**: arrays, linked lists, stacks, queues, trees, graphs, heaps, hash maps
- **Algorithmic patterns**: two pointers, sliding window, binary search, BFS/DFS, backtracking, dynamic programming, greedy, divide and conquer
- **Design patterns**: doubly-linked list + hash map (LRU), two-heap partition (streaming median), union-find
- **Complexity analysis**: every solution is annotated with time and space complexity

---

## Architecture / Component Flow

This project is a self-contained Java library — there is no server or external I/O. Each class represents one problem solution. The structure mirrors the tiered complexity model used in technical interviews.

```
Request (test input)
        │
        ▼
┌─────────────────────────────────────────────────────┐
│               Problem Class (e.g. LRUCache)         │
│                                                     │
│  ┌──────────────┐   ┌────────────────────────────┐  │
│  │  Core Logic  │   │  Supporting Data Structure │  │
│  │  (algorithm) │◄──│  (DoublyLinkedList/HashMap)│  │
│  └──────────────┘   └────────────────────────────┘  │
└─────────────────────────────────────────────────────┘
        │
        ▼
 Return value (verified by JUnit 5 test)
```

**Difficulty tiers and their focus:**

- **Easy** — Reinforce fundamentals: array manipulation, string parsing, basic tree/linked-list operations, stack/queue mechanics
- **Medium** — Combine data structures; apply sliding window, BFS/DFS, backtracking, and DP patterns; reason about trade-offs
- **Hard** — Compose multiple techniques; optimize for tight time/space bounds; handle edge cases in complex graph or interval problems

---

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Implementation language |
| Maven 3.x | Build, dependency management, test runner |
| JUnit 5 (Jupiter) | Unit testing framework |

---

## Project Structure

```
java-algorithms-learning-lab/
├── pom.xml                          # Maven build configuration
├── LICENSE                          # MIT License
├── README.md
├── src/
│   ├── main/
│   │   └── java/
│   │       └── meta/
│   │           ├── easy/            # 37 solutions  (array, string, basic DS)
│   │           │   ├── TwoSum.java
│   │           │   ├── ValidParenthesis.java
│   │           │   ├── ClimbStairs.java
│   │           │   └── ...
│   │           ├── medium/          # 59 solutions  (graphs, DP, design)
│   │           │   ├── LRUCache.java
│   │           │   ├── GroupAnagrams.java
│   │           │   ├── CourseSchedule.java
│   │           │   ├── WordBreak.java
│   │           │   └── ...
│   │           └── hard/            # 20 solutions  (complex optimization)
│   │               ├── TrappingWater.java
│   │               ├── WordLadder.java
│   │               ├── MedianFinder.java
│   │               └── ...
│   └── test/
│       └── java/
│           └── meta/
│               ├── easy/
│               │   ├── TwoSumTest.java
│               │   ├── ValidParenthesisTest.java
│               │   └── ClimbStairsTest.java
│               ├── medium/
│               │   ├── LRUCacheTest.java
│               │   ├── GroupAnagramsTest.java
│               │   ├── CourseScheduleTest.java
│               │   └── WordBreakTest.java
│               └── hard/
│                   ├── TrappingWaterTest.java
│                   └── WordLadderTest.java
```

---

## How to Run Locally

**Prerequisites:** Java 17+ installed. Maven is **not** required — this project includes the Maven wrapper (`mvnw`/`mvnw.cmd`).

```bash
# Clone the repository
git clone https://github.com/<your-username>/java-algorithms-learning-lab.git
cd java-algorithms-learning-lab

# Compile the project (downloads Maven automatically on first run)
./mvnw compile          # macOS / Linux
mvnw.cmd compile        # Windows

# Run all tests
./mvnw test             # macOS / Linux
mvnw.cmd test           # Windows
```

That's it — no application server, no database, no environment variables required.

<details>
<summary>Setup without Maven (IntelliJ IDEA)</summary>

1. Open IntelliJ IDEA → **File → Open** → select the project root
2. IntelliJ will detect `pom.xml` and auto-import Maven dependencies
3. Right-click any test file → **Run** to execute individual tests
4. Run all tests: **Run → Run All Tests** or use the Maven sidebar

</details>

<details>
<summary>Verify your Java version</summary>

```bash
java -version   # should print 17 or higher
```

</details>

---

## How to Run Tests

```bash
# Run all tests and print a summary
./mvnw test             # macOS / Linux
mvnw.cmd test           # Windows

# Run tests for a single class
./mvnw test -Dtest=TwoSumTest

# Run tests matching a pattern
./mvnw test -Dtest="*Test"

# Skip tests during a build
./mvnw package -DskipTests
```

Test output is printed to the console. Surefire HTML reports are generated under `target/surefire-reports/`.

---

## Example Usage

Most classes can be exercised directly in a main method or, more usefully, through their JUnit tests. Below are representative examples.

**Two Sum (HashMap approach — O(n))**
```java
TwoSum solver = new TwoSum();
int[] result = solver.twoSum(new int[]{2, 7, 11, 15}, 9);
// result → [0, 1]
```

**LRU Cache**
```java
LRUCache cache = new LRUCache(2);
cache.put(1, 10);
cache.put(2, 20);
cache.get(1);     // returns 10, marks key 1 as most-recently used
cache.put(3, 30); // evicts key 2 (LRU), not key 1
cache.get(2);     // returns -1 (evicted)
```

**Course Schedule (topological sort)**
```java
CourseSchedule cs = new CourseSchedule();
cs.canFinish(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}); // true — no cycle
cs.canFinish(2, new int[][]{{1,0},{0,1}});             // false — cycle
```

**Trapping Rain Water (two pointers — O(n) time, O(1) space)**
```java
TrappingWater tw = new TrappingWater();
tw.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}); // returns 6
```

---

## Learning Outcomes

After working through this repository you will be able to:

- Choose the right data structure for a given access pattern (O(1) lookup vs. ordered traversal)
- Recognize when to trade space for time (HashMap complement lookup vs. sorting)
- Apply BFS and DFS to both explicit and implicit graphs
- Build bottom-up DP solutions by identifying recurrence relations
- Explain the O(1) amortized get/put of an LRU cache in an interview
- Analyze time and space complexity for all major patterns

---

## Limitations

This project is simplified for teaching purposes. Specifically:

- **No production error handling** — inputs are assumed valid unless the problem statement specifies otherwise
- **No concurrency** — `LRUCache` and other mutable designs are not thread-safe
- **No persistence** — all state is in-memory; nothing is written to disk or a database
- **Simplified test coverage** — tests focus on correctness of representative cases, not exhaustive property-based testing
- **No build matrix** — tested against Java 11; compatibility with older versions is not guaranteed

---

## Future Improvements

- Add solutions for additional LeetCode categories (sliding window, segment tree, Trie)
- Add parametrized JUnit 5 tests for edge-case coverage
- Add a `SOLUTIONS.md` index linking each file to its LeetCode problem URL
- Add GitHub Actions CI workflow to run tests on every push

---

## License

This project is licensed under the MIT License — see the [LICENSE](LICENSE) file for details.
