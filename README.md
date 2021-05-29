# TestAirCompany
1. Clone GIT repository to Intellij IDEA.
2. In the menu on right side click 'Maven' and double click 'install'
3. Then connect to database: in the menu on right side click 'Database', then click '+' button, chose MySQL. In the tab 'Advanced' the field 'serverTimeZone' put 'UTC'. Then on the main tab put 'user' and password 'user'. Press 'Test connection' and then press 'Ok'.
4. Go to file 'mockDataAirManagement.sql' and copy all data in it. Then in the database menu chose 'Jump to query console' and paste data there. Press ctrl+enter and chose second option to run all queries. Now you have 6 recordings in each table.
5. Go to the terminal and print there 'docker compose build'. Wait until it is ready. Then print 'docker composer up' and wait until it is ready. Now app is running on the port 8080.
6. Go to Postman, click File-Import-Folder, chose folder where you copied project. You'll see file 'AirManagement' - chose it and press 'Import'. You'll see a collection of tabs with prepared requests to each task. Now you can simply press 'Send' and see a result in the bottom part of Postman.

Now a bit more information about tabs in Postman.
1. You'll see all the companies that are currently holded in database.
2. You'll see one company, it's id is placed in url.
3. You'll add new company, it's data will be passed to app in body of the request.
4. You'll update company with id = 1 (it is placed in url), you can optionally enable or disable three options and see the result in Response.
5. You'll delete one company, it's id is placed in url.
6. You'll transfer airplane from it's company to another one that is transferred in body.
7. You'll get all flights of a company with a definite status, both name of the company and status are placed in url.
8. You'll get all flights that are with status Active and started more than 24 hours ago.
9. You'll add new airplane to database, data is transferred in body. You can disable or enable 'airCompanyId', it works in both variants.
10. You'll add new flight, data is transferred in body.
11. You'll update flight status. Flight's id is placed in url, it's status is transferred in body. When you change flight's status, id database both status and time connected with it are changed.
12. You'll get all flights that are with Completed status and their difference between started and ended time is bigger than estimated flight time.

Welcome on board and enjoy your flight!
