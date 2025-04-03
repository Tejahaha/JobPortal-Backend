package com.example.demo.repo;

import com.example.demo.model.Menus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MenusRepository extends JpaRepository<Menus, Long> {

    @Query("select M from Menus M join Roles R on M.mid = R.menus.mid where R.roles=:role")
    public List<Menus> findByRole(@Param("role") int role);
}
