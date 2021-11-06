# UIMS-用户身份管理系统

## plain token format

```json
{
    "deadline": "2022-10-12 12:15:36",
    "version": 3,
    "user": {
        "id": 12,
        ...
    },
    "roles":["admin","reader"],
    "permission": ["blog:add","blog:edit"]
}