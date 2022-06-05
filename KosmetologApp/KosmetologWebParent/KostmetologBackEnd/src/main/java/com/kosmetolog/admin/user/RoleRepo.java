package com.kosmetolog.admin.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kosmetolog.entity.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Integer>{

}
