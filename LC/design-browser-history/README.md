
---

# 🧭 1472. Design Browser History

**Difficulty:** Medium
**Topic:** Design, Stack, Array
**Problem link:** [LeetCode - Browser History](https://leetcode.com/problems/design-browser-history/)

---

## 📝 Problem Statement

You have a browser with only **one tab**. You start on the **homepage** and can:

* Visit a new URL
* Go **back** in history up to a certain number of steps
* Go **forward** in history up to a certain number of steps

Implement the `BrowserHistory` class:

```java
BrowserHistory(String homepage)
```

* Initializes the browser with the `homepage`.

```java
void visit(String url)
```

* Visits `url` from the current page.
* **Clears all forward history.**

```java
String back(int steps)
```

* Moves `steps` steps back in history.
* If `steps` exceeds available history, go as far back as possible.
* Returns the current URL.

```java
String forward(int steps)
```

* Moves `steps` steps forward in history.
* If `steps` exceeds available forward steps, go as far forward as possible.
* Returns the current URL.

---

## 📌 Constraints

* `1 <= homepage.length, url.length <= 20`
* `1 <= steps <= 100`
* Only lowercase English letters and dots `.` in URLs.
* At most **5000** calls to `visit`, `back`, or `forward`.

---

## 📈 Example

```java
Input:
["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]

Output:
[null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]
```

**Explanation:**

```java
BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
browserHistory.visit("google.com");       // leetcode -> google
browserHistory.visit("facebook.com");     // google -> facebook
browserHistory.visit("youtube.com");      // facebook -> youtube
browserHistory.back(1);                   // youtube -> facebook
browserHistory.back(1);                   // facebook -> google
browserHistory.forward(1);                // google -> facebook
browserHistory.visit("linkedin.com");     // facebook -> linkedin (clears youtube)
browserHistory.forward(2);                // no effect
browserHistory.back(2);                   // linkedin -> google
browserHistory.back(7);                   // google -> leetcode
```

---

## ✅ Solution Explanation

We implement the browser history using a `List<String>` to store URLs and use two integer pointers:

* `current` — index of the current page
* `last` — index of the last valid page in history (used to limit forward navigation)

### 🔧 Java Implementation

```java
class BrowserHistory {
    List<String> history = new ArrayList<>();
    int current = 0, last = 0;

    public BrowserHistory(String homepage) {
        history.add(homepage);
    }

    public void visit(String url) {
        last = current + 1;
        if (last < history.size()) {
            history.set(last, url);
        } else {
            history.add(url);
        }
        current++;
    }

    public String back(int steps) {
        current = Math.max(0, current - steps);
        return history.get(current);
    }

    public String forward(int steps) {
        current = Math.min(last, current + steps);
        return history.get(current);
    }
}
```

### 💡 Why this works efficiently

* **O(1)** time for all operations
* We don't need to remove items from the list manually — just track the `last` valid entry
* Simple and memory-efficient

---

