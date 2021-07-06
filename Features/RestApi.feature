Feature: End to end API test for book site

Given  User is authorized
Scenario: Authorized user can add or remove book
Given  List of all books
When I add a book to my reading list
Then The book is added
When I remove a book from my reading list
Then The book is removed