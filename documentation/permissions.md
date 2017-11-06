# Description
## Permission Structure
Permissions consist of subpermissions separated by periods.  
Subpermissions can contain the characters `A-Z`, `a-z`, `-`, and `_`.  
Users can be given permissions with `*` to match any subpermission.  
Users can be given permissions with `**` to match any remaining subpermissions.

## Examples
| User's Permission | Test Permission  | Has Permission?  |
|-------------------|------------------|------------------|
| hr.employees      | hr.employees     | True             |
| hr.*              | hr.employees     | True             |
| hr.**             | hr.employees     | True             |
| hr.**             | hr.employees.add | True             |
| hr.employees      | hr               | False            |
| hr.employees      | hr.employees.add | False            |
| hr.*              | hr               | False            |
| hr.*              | hr.users         | False            |
| hr.*              | hr.employees.add | False            |
| hr.**             | hr               | False            |

# Permissions
## Department permissions
| Permission    | Description                         |
|---------------|-------------------------------------|
| hr            | Member of department: HR            |
| sales         | Member of department: Sales         |
| support       | Member of department: Support       |
| inventory     | Member of department: Inventory     |
| accounting    | Member of department: Accounting    |
| manufacturing | Member of department: Manufacturing |

## HR Permissions
| Permission              | Description                    |
|-------------------------|--------------------------------|
| hr.employees.add        | Add employees                  |
| hr.employees.edit       | Edit employees                 |
| hr.employees.view       | View employees                 |
| hr.employees.delete     | Delete employees               |
| hr.users.add            | Add users                      |
| hr.users.edit           | Edit users                     |
| hr.users.view           | View users                     |
| hr.users.delete         | Delete users                   |
| hr.api.employees        | Get employee information       |
| hr.api.users            | Get user information           |
| hr.api.users.permission | Check if user has a permission |
