class Solution {
    public boolean squareIsWhite(String coordinates) {
        // A square is white if the sum of its column and row parity is odd
        return (coordinates.charAt(0) + coordinates.charAt(1)) % 2 != 0;
    }
}
