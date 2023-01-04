# comp482_project3
Binary search finds whether a given target item is in a sorted array by checking the middle entry. If the middle entry is the value, it has been found. If the middle entry is smaller than the target it continues the search on the right half. If the middle entry is larger than the target then it continues on the left half.
Overview: Binary search finds whether a given target item is in a sorted array by checking the middle entry.
If the middle entry is the value, it has been found. If the middle entry is smaller than the target it continues
the search on the right half. If the middle entry is larger than the target then it continues on the left half.
What if you had an m by n array where each row and each column was sorted and you wanted to find a
given target item. There are obvious slow methods (just searching row by row and column by column would
be O(m · n), searching each row using binary search would be O(lg m · n)), but there is a divide and conquer
method that check the item in the middle row and middle column. If the value in the middle row and middle
column is the target, it has been found. If the value in the middle row and column is too small, we can rule
out the top left portion of the array. If the value in the middle row and middle column is too large we can rule
out the bottom right portion of the array. In either case where the value is not found, we have 3 cases each
approximately 1/4 the original size (or if you prefer 2 cases: 1 approximately 1/4 of the original size and one
approximately 1/2 the original size)
