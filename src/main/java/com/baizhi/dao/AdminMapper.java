package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminMapper {
    Admin queryByUsername(String username);

}
