# Guide_the_AGVT-bot-
Guide an AGVT (bot) to its target destination by giving the shortest path (Implementing Dijikstras Algorithm)

Algorithm Used: Dijikstras shortest path algorithm
Dependencies : Apache POI for xlsx file reading
Database : Mysql
Programming Language Used : Java

Scenario:(Automated Warehouse Management System)
    Once the order is received, the orderlist(contains ordered_item) is fed into the bot via Orders.xlsx file using Apache POI. Shortest path Algorithm calculates the minimum distance between from each source to destination. The shortest route of the given map with directions is fed into the AGVT. Finally AGVT start moving and directed to the nearest target location to pick the ordered_item and from there it will directed to the next location based on the shortest route.This process continues until bot completes its the task.
    The entire area of the warehouse (Map) will be converted to multidimensional array in order to calculate the shortest path.
Pathmatrix structure:
    if there is no path exists between source and destination then put "0"
    if there is path exists between source and destination then put "3L"
    "3L" - means destination is at 3 units distance from the source and its is Left (direction) to source.   
    The pathmatrix contents varies depends upon your warehouse blueprint.
Database Structure:
    Feed the location.xlsx(change this file according to your Warehouse blueprint) file to the database called location.sql using Apache       POI.
Orders.xlsx:
    This is the first file that (contains ordered_items and ordered_number and quantity of ordered items) fed into the bot
    
if you configured everything perfectly,you would get the command paragraph for the bot like this,

07005E723B10@B@@070054F48E29<br>070054F48E29@L@@070054C7F460<br>070054C7F460@B@@070054F48E29@F@@0700550A87DF<br>0700550A87DF@F@@070055527272@F@@070055526D6D@L@@0700550A8AD2@L@@0700550B5009<br>0700550B5009@F@@070054BD48A6@F@@070055522F27@L@@070054F48E29@F@@07005E723B10<br>

This is the output for the sample orders and location map given in the repository.
The output contains unique_rfid number for a particular location and directions to the destination
07005E723B10@B@@070054F48E29 = 07005E723B10 - source
                               B - direction (Backward)
                               070054F48E29 - destination
