# Permissions in Use
## Department permissions
| Permission      | Description                            |
|-----------------|----------------------------------------|
| hr              | Member of department: HR               |
| sales           | Member of department: Sales            |
| inventory       | Member of department: Inventory        |
| accounting      | Member of department: Accounting       |
| manufacturing   | Member of department: Manufacturing    |
| customersupport | Member of department: Customer Support |

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

---

# How Permissions Work
## Permission Structure
Permissions consist of sub-permissions separated by `.`'s.  
Sub-permissions can contain the characters `A-Z`, `a-z`, `0-9`, `-`, and `_`.  
If the last sub-permission is `*`, then the remaining sub-permissions match.

## Examples
| User's Permission | Test Permission  | Has Permission?  |
|-------------------|------------------|------------------|
| hr.employees      | hr               | False            |
| hr.employees      | hr.employees     | True             |
| hr.employees      | hr.employees.add | False            |
| hr.*              | hr               | True             |
| hr.*              | hr.users         | True             |
| hr.*              | hr.employees     | True             |
| hr.*              | hr.employees.add | True             |
| hr.*              | manufacturing    | False            |
