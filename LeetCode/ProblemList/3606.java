/*
 * 3606. Coupon Code Validator
 *
 * You are given three arrays of length n that describe the properties of n coupons: code, businessLine, and isActive. The ith coupon has:
 * code[i]: a string representing the coupon identifier.
 * businessLine[i]: a string denoting the business category of the coupon.
 * isActive[i]: a boolean indicating whether the coupon is currently active.
 * A coupon is considered valid if all of the following conditions hold:
 * code[i] is non-empty and consists only of alphanumeric characters (a-z, A-Z, 0-9) and underscores (_).
 * businessLine[i] is one of the following four categories: "electronics", "grocery", "pharmacy", "restaurant".
 * isActive[i] is true.
 * Return an array of the codes of all valid coupons, sorted first by their businessLine in the order: "electronics", "grocery", "pharmacy", "restaurant", and then by code in lexicographical (ascending) order within each category.
*/

import java.util.*;

class Solution {
    static class Coupon {
        final String code;
        final String businessLine;

        Coupon(String code, String businessLine) {
            this.code = code;
            this.businessLine = businessLine;
        }
    }

    private boolean checkCode(String code) {
        if (code == null || code.isEmpty()) return false;

        for (char c : code.toCharArray()) {
            if (c == '_') continue;

            // Digits, uppercase letters, lowercase letters
            if ((c >= '0' && c <= '9') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= 'a' && c <= 'z')) {
                continue;
            }

            return false;
        }

        return true;
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        // Desired custom order
        Map<String, Integer> businessOrder = Map.of(
            "electronics", 0,
            "grocery", 1,
            "pharmacy", 2,
            "restaurant", 3
        );

        List<Coupon> validCoupons = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            String c = code[i];
            String b = businessLine[i];

            boolean codeCheck = checkCode(c);
            boolean businessCheck = b != null && businessOrder.containsKey(b);
            boolean activityCheck = isActive[i];

            if (codeCheck && businessCheck && activityCheck) {
                validCoupons.add(new Coupon(c, b));
            }
        }

        // Sort by businessLine order, then code lexicographically (ascending)
        validCoupons.sort((a, b) -> {
            int cmp = Integer.compare(
                businessOrder.get(a.businessLine),
                businessOrder.get(b.businessLine)
            );
            if (cmp != 0) return cmp;
            return a.code.compareTo(b.code);
        });

        // Extract only the codes in sorted order
        List<String> ans = new ArrayList<>(validCoupons.size());
        for (Coupon coupon : validCoupons) {
            ans.add(coupon.code);
        }

        return ans;
    }

    public static void main(String args[]) {
        Solution sol = new Solution();

        String[] code = {"SAVE20","","PHARMA5","SAVE@20"};
        String[] businessLine = {"restaurant","grocery","pharmacy","restaurant"};
        boolean[] isActive = {true,true,true,true};

        List<String> ans = sol.validateCoupons(code, businessLine, isActive);
        for(String answer: ans){
            System.out.println(answer);
        }
    }
}
