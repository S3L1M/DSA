# Sorted List Implementation

This Java class, `SortedList`, implements a sorted list data structure with the following characteristics:

- It maintains a sorted order of elements in ascending order.
- It provides methods for adding elements to the list while maintaining the sorted order.
- It offers methods for accessing the least and greatest elements in the list.
- It allows retrieving elements by index and searching for elements in a specified range.
- It supports methods for determining the size of the list and checking if it's empty.
- It provides a readable string representation of the list.

## Features

### Initialization

The `SortedList` class can be initialized in two ways:

1. **Default Constructor**: Creates an empty sorted list.

2. **Constructor with an Array**: Creates a sorted list from an array of comparable elements. The elements from the array are added to the list in sorted order.

### Adding Elements

The `add` method allows you to add elements to the sorted list while maintaining the sorted order. Elements are added in ascending order.

### Accessing Elements

- `least()`: Returns the least (smallest) element in the list.
- `greatest()`: Returns the greatest (largest) element in the list.
- `get(int index)`: Returns the element at the specified index.

### Searching and Ranges

- `indexOf(Comparable item)`: Returns the index of the specified item in the list.
- `searchRange(Comparable from, Comparable to)`: Searches for elements within a specified range and returns a new `SortedList` containing the matching elements.

### Size and Empty Check

- `size()`: Returns the number of elements in the list.
- `isEmpty()`: Checks if the list is empty.

### Removing Elements

- `remove(int index)`: Removes an element at the specified index (not yet implemented).

### Middle Element

The algorithm includes a point on the middle element of the list, which ensures that search and insert operations at the worst case will loop through at most half of the list. This design enhances the efficiency of these operations.

## Implementation Details

The implementation of the sorted list uses linked nodes to maintain the sorted order efficiently. Nodes are linked in such a way that elements are inserted in their correct positions while preserving the ascending order.

## Usage

To use the `SortedList` class:

1. Initialize an instance of `SortedList`.

2. Add elements to the sorted list using the `add` method.

3. Access elements using the provided methods such as `least`, `greatest`, `get`, `indexOf`, and `searchRange`.

4. Check the size of the list using `size` and determine if it's empty with `isEmpty`.

5. Optionally, remove elements using the `remove` method (not yet implemented).

## Note

The `remove` method is marked as "TODO" and is not yet implemented. You can extend the class to add this functionality if needed.

**Example Usage**:

```java
SortedList sortedList = new SortedList();
sortedList.add(3);
sortedList.add(1);
sortedList.add(5);

System.out.println(sortedList.least()); // Prints 1
System.out.println(sortedList.greatest()); // Prints 5
System.out.println(sortedList.get(1)); // Prints 3
System.out.println(sortedList.size()); // Prints 3
System.out.println(sortedList.isEmpty()); // Prints false
System.out.println(sortedList); // Prints [1, 3, 5]
```

This code creates a sorted list, adds elements, and demonstrates basic operations. The algorithm's design ensures efficient search and insert operations, particularly in cases where the middle element is involved.
