import pytest

def test_sum(num_list):
    sum = 0
    
    for num in num_list:
        sum+=num
        
        
    print(sum)
    assert sum == 55
          