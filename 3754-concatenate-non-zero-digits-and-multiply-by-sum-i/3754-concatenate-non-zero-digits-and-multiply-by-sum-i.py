class Solution(object):
    def sumAndMultiply(self, n):
        """
        :type n: int
        :rtype: int
        """
        num_str = str(n)

        concatenated_number = ""
        digit_sum = 0
          
         
        for char in num_str:
            if char != '0':  
             concatenated_number += char  
             digit_sum += int(char)  
          
         
        if concatenated_number:
            concatenated_number = int(concatenated_number)
        else:
            concatenated_number = 0  
          
         
        result = concatenated_number * digit_sum
          
        return result      