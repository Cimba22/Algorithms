package org.example;

import java.util.ArrayList;
import java.util.List;

public class FasterSolution {

        List<String> history = new ArrayList<>();
        int current = 0, last = 0;

        public FasterSolution(String homepage) {
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

/*
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

