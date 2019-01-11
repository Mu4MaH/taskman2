#### Welcome to **Tasker v2**. Java training project by Alexey Lushchikhin.

##### **About Tasker**

Allows to manage and track tasks inside your dev team.

Used:
- Java ver. 1.8
- Maven 3.6.0

* Version 0.0.1
    * Initial version. Entities and repositories created
    * Some program logic created
    * Command pattern usage try

* Version 0.0.2
    * Basic commands added
    * Working menu added
    * Command list added
    * add/get task(s) added

* Version 0.0.3
    * Worker entity added
    * Worker repository added
    * basic logic (CRUD) fo Repositories implemented
    * varios minor changes and fixes

* Version 0.0.4
    * Worker logic added
    * several fixes
    * ...    

* Version 0.0.4.1
    * Delegating business-logic to service

* Version 0.0.5
    * Exceptions added
    * Services and repositories interfaces added
    * Delegated all business-logic to service layer
    * Enums fixed
    * Data to service layer as List

* Version 0.0.6
    * Flush data to disk services added
    * Assignees flushing data to disk added
    * Descriptions of commands added

* Version 0.0.6.1
    * Read/Write commands added
    * ...

* Version 0.0.7
    * Built-in admin account added
    * Assignment entity added
    * Assignment service added
    * Authorization controller added
    * Authorization data login/password to assignee entity added
    * Login/logout ability using existing assignees from assignee repository added
    * Session entity added
    * Exceptions added
    * Authentication two-sided service added
    * Access Control List repository added
    * Various minor fixes and changes

* Version 0.0.7.1
    * Valid data check to service layer added
    
* Version 0.0.8
    * Data check in service layers fixes
    * Access control for tasks/projects added
    * Forbidden project|task delete for everyone except Administrators group
    * Access Control for Administrators group fixes
    * Domain entity with I/O methods added
    * Save to Json format added
    * Varios minor fixes and refactoring
    
```
Build: mvn clean install 
```
```
Deploy: java -jar ./taskman2.jar
```