# TestAirCompany
1. Clone GIT repository to your local machine and open in IDE.
2. Using Maven command 'install' create *.jar file of the project.
3. Go to the terminal and type a command:
    - 'docker compose build'. 
    Wait until it is ready. 
4. Type a command 
    - 'docker compose up'. 
    Wait until it is ready. Now app is running on the port 8080.
5. Create a new MySQL DataSource using these settings: 
  - username 'user'
  - password 'user'
  - port '3308'
  - serverTimeZone 'UTC'. 
  Click Test Connection to ping the server and to verify that the connection profile is working. Press 'Ok'.
7. Go to file 'mockDataAirManagement.sql' in the root of the project and run this script in the console of database. Now you have 6 recordings in each table.
8. Go to Postman, click File->Import->Folder, choose folder where you copied the project. You'll see collection 'AirManagement' - choose it and press 'Import'. You'll see a collection of tabs with prepared requests for each task. Now you can simply press 'Send' and see the result in the bottom part of Postman.

Now a bit more information about tabs in Postman.
Tab#1 'task1.read all companies': You'll see all the companies that are currently stored in database.
Tab#2 'task1.read one company': You'll see one company, it's id is placed in url.
Tab#3 'task1.add new company':  You'll add new company, it's data will be passed to the app in body of the request.
Tab#4 'task1.update company':  You'll update company with id = 1 (id is placed in url), you can optionally enable or disable three options in body and see the result in Response.
Tab#5 'task1.delete company':  You'll delete one company, it's id is placed in url.
Tab#6 'task2.move airplane between companies':  You'll transfer airplane from it's company to another one which id is transferred in body.
Tab#7 'task3.find all aircompany's flights by status':  You'll get all flights of the company with a definite status, both name of the company and status are placed in url.
Tab#8 'task4.active flights started more than 24 hours ago':  You'll get all flights that are with the status ACTIVE and started more than 24 hours ago.
Tab#9 'task5.add airplane with or without company':  You'll add new airplane to database, data is transferred in body. You can disable or enable 'airCompanyId', it works in both variants.
Tab#10 'task6.add new flight':  You'll add new flight, data is transferred in body.
Tab#11 'task7.update flight status':  You'll update flight status. Flight's id is placed in url, it's status is transferred in body. When you change flight's status, in database both status and time that is connected with it are changed.
Tab#12 'task8 completed flights with delay':  You'll get all flights that are with COMPLETED status and their difference between started and ended time is bigger than estimated flight time.

Welcome on board and enjoy your flight!
