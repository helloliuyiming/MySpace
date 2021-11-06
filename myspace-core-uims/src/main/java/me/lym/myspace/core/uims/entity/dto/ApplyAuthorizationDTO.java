package me.lym.myspace.core.uims.entity.dto;

import lombok.Data;
import me.lym.myspace.core.uims.entity.Permission;
import me.lym.myspace.core.uims.entity.Role;

import java.util.List;

@Data
public class ApplyAuthorizationDTO {

    private String appName;
    private List<Permission> permissionList;
    private List<Role> roleList;

}
