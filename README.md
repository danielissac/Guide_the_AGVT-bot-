# Guide_the_AGVT-bot-
Guide an AGVT (bot) to its target destination by giving the shortest path (Implementing Dijikstras Algorithm)

Algorithm Used: Dijikstras shortest path algorithm
Dependencies : Apache POI for xlsx file reading
Database : Mysql
Programming Language Used : Java

Scenario:(Automated Warehouse Management System)
    Once the order is received, the orderlist(contains ordered_item) is fed into the bot via Orders.xlsx file using Apache POI. Shortest path Algorithm calculates the minimum distance between from each source to destination. The shortest route of the given map with directions is fed into the AGVT. Finally AGVT start moving and directed to the nearest target location to pick the ordered_item and from there it will directed to the next location based on the shortest route.This process continues until bot completes its the task.
    The entire area of the warehouse (Map) will be converted to multidimensional array in order to calculate the shortest path.
