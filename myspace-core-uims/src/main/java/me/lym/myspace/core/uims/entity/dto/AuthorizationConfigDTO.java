package me.lym.myspace.core.uims.entity.dto;

import lombok.Data;
import me.lym.myspace.core.uims.entity.Permission;
import me.lym.myspace.core.uims.entity.Role;

import java.util.List;
import java.util.Map;

@Data
public class AuthorizationConfigDTO {

    private List<Permission> permissionList;
    private List<Role> roleList;
    private List<Map<String,List<String>>> roleJoinPermission;

}
