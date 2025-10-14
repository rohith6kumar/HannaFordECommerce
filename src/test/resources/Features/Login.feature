Feature: Verifying the Login Module
Scenario Outline: Login with valid credentials
Given User in on the HannaFord Page
When User enter details "<userName>" and "<password>"
And User click the login button
Then User should verify the success message after login
Examples:
| userName | password |
| 18a123rohithkumar@gmail.com | Rohith@2000 |