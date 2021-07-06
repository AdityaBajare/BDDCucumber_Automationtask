Feature: Automate the Paytm site

Scenario: Status code verification

 Given User is on Amazon Page
 When Check actual & expected title of Amazon Page
 Then Verify status code 200 or 400
 When Click on Amazon Pay link
 Then Amazon Pay page should be open & verify status code 301 or 302 
 When User Click on electricity link
 Then Delete all cookies 
 When User Navigate to Amzon home page
 Then Handle multple frames 
 Then Verify resopnse headers
 Then Verify value/text in page source 
 


 