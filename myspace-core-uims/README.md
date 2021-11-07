# UIMS-用户身份管理系统

## 职责

### 权限注册申请

每个app服务都需要在这里注册该应用的权限配置信息，包括管理的角色权限配置、需要其他服务的权限申请

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
```
