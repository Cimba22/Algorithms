package org.example;

//# Write your MySQL query statement below
//select P.firstName, P.lastName, A.city, A.state
//from Person P left join Address A
//on P.personId = A.personId;

//Better solution
//# Write your MySQL query statement below
//select Person.firstName, Person.lastName, Address.city ,Address.state
//FROM Person
//LEFT JOIN Address
//ON Person.personId = Address.personId;