package com.crm.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crm.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	@Query("select a from Role a where a.status=1 and a.name in (:roleList) ")
	Optional<Set<Role>> getRole(List<String> roleList);
	
	@Query("select a from Role a where a.status=1 and a.name in ('USER','ADMIN','MODERATOR') ")
	List<Role> getRole();
}
