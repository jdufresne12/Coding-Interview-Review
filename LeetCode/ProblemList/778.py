# 778. Swim In Rising Water
# You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).
# It starts raining, and water gradually rises over time. At time t, the water level is t, meaning any cell with elevation less than equal to t is submerged or reachable.
# You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.
# Return the minimum time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).

# Example 1:
# Input: grid = [[0,2],[1,3]]
# Output: 3
# Explanation:
#   At time 0, you are in grid location (0, 0).
#   You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
#   You cannot reach point (1, 1) until time 3.
#   When the depth of water is 3, we can swim anywhere inside the grid.

import heapq
from typing import List

class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)

        pq = [(grid[0][0], 0, 0)]
        visited = set()
        visited.add((0,0))

        directions = [(0,1),(1,0),(-1,0),(0,-1)]
        
        while pq:
            max_elv, row, col = heapq.heappop(pq)
            if row == n - 1 and col == n - 1:
                return max_elv
            for dr, dc in directions:
                new_row, new_col = row + dr, col + dc
                if 0 <= new_row < n and 0 <= new_col < n and (new_row, new_col) not in visited:
                    visited.add((new_row, new_col))
                    heapq.heappush(pq, (max(max_elv, grid[new_row][new_col]), new_row, new_col))
                    
        return -1

if(__name__ == "__main__"):
    sol = Solution()
    grid = [[0,2],[1,3]]
    print(sol.swimInWater(grid))

