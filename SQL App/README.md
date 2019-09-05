# Application process - simple SQL application

Handling the application process at Codecool has always been a tedious task. Finally the HR department figured out that using only Java and long codecool.com.model.lists is a no-brainer if they want to get information quickly. To improve on data management, they collaborate with you to test out something they just heard about: "databases".

## The exercise

Luckily they managed to design a database, which can be described by the Entity-Relationship Diagram below:

You'll have to create this database and than write queries to retrieve data from the database.

![application_process_erd.png](/media/application_process_erd.png)

## Preparation

Create the database structure based on the ER Diagram above. Save database creation script to db.sql file.

Than fill your database with the data from the csv files that you'll find in the github repository. Save data filling script to data.sql file.

## The queries

The HR department wants answers to the following questions:

1.  Write a query that returns the 2 name columns of the mentors table.  
    *columns: first\_name, last\_name*
2.  Write a query that returns the nick_name-s of all mentors working at Miskolc.  
    *column: nick\_name*
3.  We had interview with an applicant, some Carol. We don't remember her name, but she left her hat at the school. We want to call her to give her back her hat. To look professional, we also need her full name when she answers the phone (for her full\_name, you want to include a concatenation into your query, to get her full\_name, like: "Carol Something" instead of having her name in 2 different columns in the result. This columns should be called: full\_name).  
    *columns: full\_name, phone\_number*
4.  We called Carol, and she said it's not her hat. It belongs to another girl, who went to the famous Adipiscingenimmi University.  
    You should write a query to get the same informations like with Carol, but for this other girl.  
    The only thing we know about her is her school e-mail address ending: '@adipiscingenimmi.edu'.  
    *columns: full\_name, phone\_number*
5.  After we returned the hat, a new applicant appeared at the school, and he wants to get into the application process.  
    His name is Markus Schaffarzyk, has a number: 003620/725-2666 and e-mail address: djnovus@groovecoverage.com  
    Our generator gave him the following application code: 54823

    After INSERTing the data, write a SELECT query, that returns with all the columns of this applicant! (use the unique application code for your condition!)

6.  Jemima Foreman, an applicant called us, that her phone number changed to: 003670/223-7459  
    Write an UPDATE query, that changes this data in the database for this applicant.  
    Also, write a SELECT query, that checks the phone_number column of this applicant.  
    Use both of her name parts in the conditions!
7.  Arsenio, an applicant called us, that he and his friend applied to Codecool.  
    They both want to cancel the process, because they got an investor for the site they run: mauriseu.net

    Write DELETE query to remove all the applicants, who applied with emails for this domain (e-mail address has this domain after the @ sign).


**Save your queries to queries.sql file.**
