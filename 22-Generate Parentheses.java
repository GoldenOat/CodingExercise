/*
22. Generate Parentheses
*/

// DFS 
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> rslt = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int l = 0;
        int r = 0;
        return generateParenthesisHelper(n, rslt, sb, l, r);
    }
    private List<String> generateParenthesisHelper(int n, List<String> rslt, StringBuilder sb, int l, int r) {
        // base case
        if (sb.length() == 2*n) {
            rslt.add(sb.toString());
            sb = new StringBuilder();
        }

        if (l < n) {
            sb.append('(');
            generateParenthesisHelper(n, rslt, sb, l + 1, r);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (l > r) {
            sb.append(')');
            generateParenthesisHelper(n, rslt, sb, l, r + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        return rslt;
    }
}

/*
TC: O(2^(2n)*n)
SC: O(n)
*/