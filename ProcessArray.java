import java.util.ArrayList;

public interface ProcessArray {
    public abstract int maxByBruteForce();
    public abstract int maxByBruteForceImproved();
    public abstract int maxByRecursive();
    public abstract int maxByDynamicPrograming();
    public abstract int maxSub(int low, int high);
    public abstract int maxSub();
    public abstract int max(int wL, int wR, int wM);
    public abstract int maxLeft(int low, int mid);
    public abstract int maxRight(int mid, int high);
    public abstract int max(int x1, int x2);
}
