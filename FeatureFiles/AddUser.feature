Feature:
Add User Functionality
Scenario Outline:
Validate Add User with multiple data
Given user navigate to OrangeHRM
When user logs in using username as "Admin" and password as "Qedge123!@#"
When user click login button
When user click Admin
When user click Add
When user selet role "<UserRole>"
When user enter ename "<EmployeeName>"
When user enter uname "<UserName>"
When user enter pass "<Password>"
When user enter cpass "<ConfirmPassword>"
When user click save button
Then user Validate url
Then user close browser
Examples:
|UserRole|EmployeeName|UserName|Password|ConfirmPassword|
|ESS|Abhishek Jena|Sanju09|sanchi@1234|sanchi@1234|
|Admin|Adinath Mali|Sanju91|sanchi@1234|sanchi@1234|
|ESS|ARUNPANDYA SADHU|Sanju12|sanchi@1234|sanchi@1234|
|Admin|Abhi Ram|Sanju08|sanchi@1234|sanchi@1234|
|ESS|Anjan Dhanduprolu|Sanju24|sanchi@1234|sanchi@1234|