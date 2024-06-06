package com.Authentication.UserAuthentication.Repository;


import com.Authentication.UserAuthentication.Model.Myuser;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepo extends JpaRepository<Myuser,Long> {


    Optional<Myuser> findByUsername(String Username);

}
