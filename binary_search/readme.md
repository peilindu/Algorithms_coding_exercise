### binary_search_recursive
- Recursion
  - The definition of recursion
    - parameters
    - return value
  - The composition of recursion
    - decompose the problem to one or more problem with the same structure and smaller scale
  - The exit of recursion
    - The corner case when the recursion ends
  - Tail recursion
    - When the recursive call is located at the end of function body and its return value is not part of a expression
    - The compiler will cover the stack instead of allocate new space when it detects tail recursion
- Stack space & Heap space
  - Content stored in **stack** will be destroyed when the execution of that function is over
  - In other words, **heap space** is requested through ```new``` operation, while **stack space** is not 
### binary_search_nonrecursive
- ```start + 1 < end``` ends the while loop when the length of subarray is 2
- ```mid = start + (end - start)/2``` biases to ```start```
- ```start = mid; end = mid``` takes care of the corner case like ```int[] nums = [1, 1]```
- check ```nums[start]``` and ```nums[end]``` respectively
### 3_steps_rotate
- access components of List with index by ```get()``` and ```set()``` function
- The ```reverse``` function is concise
