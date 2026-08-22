/**
 * Problem Link : https://leetcode.com/problems/market-analysis-i/
 * Platform     : LeetCode
 * Difficulty   : Medium
 */

#include <bits/stdc++.h>
using namespace std;

# Write your MySQL query statement below
SELECT u.user_id,
       u.join_date,
       MIN(YEAR(o.order_date)) AS first_buy_year
FROM Users u
LEFT JOIN Orders o
ON u.user_id = o.buyer_id
GROUP BY u.user_id, u.join_date;
