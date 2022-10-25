Some important points to consider.

1. Question Link:
https://workat.tech/machine-coding/practice/splitwise-problem-0kp2yneec2q2 


2. Optional Requirement 2 of Share Expense is very similar to Percentage Expense.
   - For Eg: u4 1200 4 u1 u2 u3 u4 SHARE 2 1 1 1
   - So, we have 2 + 1 + 1 + 1 = 5 parts in total
   - So, u1 has to pay (2/5) * 1200
   - Similarly, u2 has to pay (1/5) * 1200 and like so for others.
   


3. Give the input one by one. Say the sample input is:
   - SHOW
   - SHOW u1
   - EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL Nil Nil Nil 
   - SHOW u4
   - SHOW u1
   - EXPENSE u1 1250 2 u2 u3 EXACT 370 880 Nil Nil Nil 
   - SHOW
   - EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20 PizzaExpense www.images.com/pizza.gif Pizza_party_expense
   - SHOW u1
   - SHOW

   - So, give these inputs one by one 
   - First give SHOW
   - You get the output
   - Then give SHOW u1
   - Yout get the output and so on.
   - So that kind of works as a live 
   - ongoing app instead of passing all the
   - inputs at once we can get whatever we want
   - anytime.
   
   
   - Note 1:
     - See the Nil Nil Nil at the end of the expense input lines.
     - Those are for passing name, image_url and note, that is, 
     - for optional requirement 1. See the last expense input of
     - type percent, we have passed all the three values instead of
     - passing Nil
   
   - Note 2:
     - if we want to give all the inputs at once, then, we can design our code in a way
     - such that we take all the input lines at once in the main and store the inputs
     - and then pass the input to a separate Driver class which will handle the inputs
     - and give the outputs accordingly.


4. I didn't implement the 4th optional requirement. It was confusing.




