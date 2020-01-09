package main.java.sort.simple;

import main.java.sequence.NumDataSequence;

public class NumSimpleSorter {
    public static void select(final NumDataSequence seq) {
        int n = seq.size();
        while (n > 1) {
            repeatForSelect(seq, n);
            n--;
        }
    }

    public static void insert(final NumDataSequence seq) {
        // ![1
        int n = seq.size();
        while (n > 0) {
            n = repeatForInsert(seq, n);
        }
        // !]
    }

    public static void gnome(final NumDataSequence seq) {
        int k = 1;
        while (k < seq.size()) {
            if (seq.order(k-1, k)) { k++; continue; }
            seq.swap(k-1, k);
            k += k > 1 ? - 1 : 1;
        }
    }

    public static void trans(final NumDataSequence seq) {
        boolean doing = true;
        while (doing) {
            doing = false;
            doing = repeatForTrans(seq, 0, seq.size());
            doing = repeatForTrans(seq, 1, seq.size());
        }
    }

    public static void shaker(final NumDataSequence seq) {
        int i = 1;
        int j = seq.size() - 1;
        while (i < j) {
            for (int k = i; k < j; k++) { seq.swapIfNeeded(k - 1, k); }
            for (int k = j; k >= i; k--) { seq.swapIfNeeded(k - 1, k); }
            i++;
            j--;
        }
    }

    private static void repeatForSelect(final NumDataSequence seq, int m) {
        int p = m - 1;
        for (int k = 0; k < m - 1; k++) {
            if (seq.order(p, k)) { p = k; }
        }
        seq.swap(p, m - 1);
    }

    private static boolean repeatForTrans(final NumDataSequence seq, int s, int m) {
        for (int k = s; k < m - 1; k += 2) {
            if (seq.swapIfNeeded(k, k + 1)) { return true; }
        }
        return false;
    }

    private static int repeatForInsert(final NumDataSequence seq, int m) {
        int p = m;
        for (int k = 1; k < m; k++) {
            seq.swapIfNeeded(k - 1, k);
            p = k;
        }
        if (p == m) { return 0; }
        return p;
    }
}
